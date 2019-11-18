package com.pharmacy.turn.ws;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmacy.turn.config.WSConfig;
import com.pharmacy.turn.domain.ErrorResponse;
import com.pharmacy.turn.domain.ShiftInformationRQ;
import com.pharmacy.turn.exception.PharmacyException;
import com.pharmacy.turn.exception.PharmacyRestException;
import com.pharmacy.turn.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WSPharmacyClient {

    /**
     * Client to consume pharmacy service
     * 
     * @param rq
     * @param config
     * @return String response
     * @throws IOException
     */
    public String call(ShiftInformationRQ rq, WSConfig config) throws IOException {

        log.info(Constants.API_REQUEST, rq);
        String response = null;
        String uri = null;

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme(config.getPharmacyScheme())
                .host(config.getPharmacyEndpoint()).path(config.getPharmacyProcess());
        uri = builder.toUriString();

        if (rq.getRegionId() != null) {
            uri += Constants.SUFFIX + rq.getRegionId();
            log.info(Constants.URI, uri);
        }

        RestTemplate restTemplate = new RestTemplate();
        try {

            ResponseEntity<String> restResponse = restTemplate.getForEntity(uri, String.class);
            log.info(Constants.API_RESPONSE, restResponse.getStatusCode());

            if (restResponse.getStatusCode() == HttpStatus.OK) {
                response = restResponse.getBody();

            }

        } catch (HttpClientErrorException e) {
            httpClientErrorExtend(e);
        }

        return response;
    }

    /**
     * exception handler
     * 
     * @param e
     * @throws IOException
     */
    public void httpClientErrorExtend(HttpClientErrorException e) throws IOException {
        log.info(Constants.ERROR + e.getResponseBodyAsString());
        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse result = new ErrorResponse();
        String responseString = null;
        if (!(e.getStatusCode().toString()).equals(Constants.ERROR_UNAUTHORIZED_CODE)) {
            responseString = e.getResponseBodyAsString();
            result = mapper.readValue(responseString, ErrorResponse.class);
        }
        if ((e.getStatusCode().toString()).equals((HttpStatus.CONFLICT).toString())) {
            throw new PharmacyException(result.getMessage());
        } else if ((e.getStatusCode().toString()).equals((HttpStatus.UNAUTHORIZED).toString())) {
            throw new PharmacyRestException(Constants.ERROR_MESSAGE_UNAUTHORIZED);
        } else {
            throw new PharmacyException(result.getMessage());
        }
    }

}
