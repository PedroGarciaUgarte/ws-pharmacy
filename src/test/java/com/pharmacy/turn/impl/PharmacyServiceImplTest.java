package com.pharmacy.turn.impl;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import com.pharmacy.turn.config.WSConfig;
import com.pharmacy.turn.domain.PharmacyData;
import com.pharmacy.turn.domain.ShiftInformationRQ;
import com.pharmacy.turn.entities.RequestTest;
import com.pharmacy.turn.entities.ResponseTest;
import com.pharmacy.turn.service.impl.PharmacyServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@TestPropertySource("classpath:/application.properties")
public class PharmacyServiceImplTest {

    public static final String MUST_BE_A_NOTNULL = "can't be a null value";

    private ShiftInformationRQ rq = RequestTest.getValidRequest();
    private PharmacyData rs = ResponseTest.getValidResponse();

    @InjectMocks
    private WSConfig configMok;

    @InjectMocks
    private PharmacyServiceImpl impl;

    @InjectMocks
    private ResponseEntity<Object> restResponse = new ResponseEntity<>(rs, HttpStatus.OK);

    @Mock
    private RestTemplate restTemplate;

    @Test(expected = Exception.class)
    public void testImplements() throws IOException {
        configMok.setPharmacyEndpoint("");
        configMok.setPharmacyProcess("");
        configMok.setPharmacyScheme("");
        impl = new PharmacyServiceImpl(configMok);

        impl.pharmacyData(rq);
        Assert.assertNotNull(MUST_BE_A_NOTNULL, configMok);
    }

}
