package com.marcosfa.wonderboot.rest.location;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class LocationResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(final ClientHttpResponse clientHttpResponse)  {
        return false;
    }

    @Override
    public void handleError(final ClientHttpResponse clientHttpResponse)  {
        //hasError siempre devuelve false. Nunca se llama a este método.
    }
}
