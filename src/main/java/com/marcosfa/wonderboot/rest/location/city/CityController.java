package com.marcosfa.wonderboot.rest.location.city;

import com.marcosfa.wonderboot.rest.location.city.dto.CityDTO;
import com.marcosfa.wonderboot.rest.location.city.dto.CityDTOAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/cities")
@RestController
class CityController {

    private final CityService cityRService;
    private final CityDTOAdapter cityDTOAdapter;

    private CityController(final CityService cityRService,
                           final CityDTOAdapter cityDTOAdapter) {
        this.cityRService = cityRService;
        this.cityDTOAdapter = cityDTOAdapter;
    }


    /**
     * utilizamos term como parámetro por la biblioteca "select2" que utilizamos en la vista HTML, ya que este es el nombre por defecto del parametro que envía.
     */
    @GetMapping
    CityDTO[] searchCity(@RequestParam final String term) {
        City[] cities = cityRService.findCities(term);
        return cityDTOAdapter.adaptCities(cities);
    }
}
