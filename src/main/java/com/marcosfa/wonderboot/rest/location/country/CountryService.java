package com.marcosfa.wonderboot.rest.location.country;

import com.marcosfa.wonderboot.config.LocationApiProperties;
import com.marcosfa.wonderboot.rest.location.LocationResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CountryService {
    private static final String PATH = "/api/countries";
    private static final String TERM_QUERY_PARAM = "term";

    private final RestTemplate restTemplate;
    private final String locationApiHost;

    public CountryService(final RestTemplateBuilder restTemplateBuilder,
                          final LocationApiProperties locationApiProperties,
                          final LocationResponseErrorHandler errorHandler) {
        this.restTemplate = restTemplateBuilder.errorHandler(errorHandler)
                .build();
        this.locationApiHost = locationApiProperties.getHost();
    }
    Country[] searchCountry(final String term) {
        URI uri = UriComponentsBuilder.fromUriString(locationApiHost)
                .path(PATH)
                .queryParam(TERM_QUERY_PARAM, term)
                .build().toUri();
        return restTemplate.getForObject(uri, Country[].class);
    }
    public Optional<Country> findCountryByCode(final String code) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("code", code);
        URI uri = UriComponentsBuilder.fromUriString(locationApiHost)
                .path(PATH + "/{code}")
                .uriVariables(uriVariables)
                .build().toUri();

        //En caso de error devolvemos un Optional vacío, para que la clase que llama decida si quiere lanzar una excepción o continuar de alguna forma.
        //Puedes buscar las llamadas a findCountryByCode para ver los diferentes escenarios.
        ResponseEntity<Country> responseEntity = restTemplate.getForEntity(uri, Country.class);
        if (responseEntity.getStatusCode().isError()) {
            return Optional.empty();
        }
        return Optional.ofNullable(responseEntity.getBody());
    }


}
