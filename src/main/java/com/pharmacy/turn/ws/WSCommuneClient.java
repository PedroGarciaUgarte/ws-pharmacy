package com.pharmacy.turn.ws;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmacy.turn.config.WSConfig;
import com.pharmacy.turn.domain.CommuneInformationRQ;
import com.pharmacy.turn.domain.ErrorResponse;
import com.pharmacy.turn.exception.PharmacyException;
import com.pharmacy.turn.exception.PharmacyRestException;
import com.pharmacy.turn.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WSCommuneClient {

    /**
     * Client to consume commune service
     * 
     * @param rq
     * @param config
     * @return String response
     * @throws IOException
     */
    public String call(CommuneInformationRQ rq, WSConfig communeConfig) throws IOException {

        log.debug(Constants.API_REQUEST, rq);
        String response = null;

        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add(Constants.REG_ID, rq.getRegionId());

        try {
            UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme(communeConfig.getCommuneScheme())
                    .host(communeConfig.getCommuneEndpoint()).path(communeConfig.getCommuneProcess());
            String build = builder.toUriString();
            log.info(Constants.URI, build);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            HttpEntity<MultiValueMap<String, String>> imageEntity = new HttpEntity<>(map, headers);

            ResponseEntity<String> restResponse = restTemplate.exchange(builder.toUriString(),
                    org.springframework.http.HttpMethod.POST, imageEntity, String.class);

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
