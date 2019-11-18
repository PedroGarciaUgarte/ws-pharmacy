package com.pharmacy.turn.controller;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;

import com.pharmacy.turn.domain.ShiftInformationRQ;
import com.pharmacy.turn.service.PharmacyService;

public class PharmacyControllerTest {

    public static final String MUST_BE_A_NOTNULL = "can't be a null value";

    @Mock
    private MockHttpServletRequest req;
    @Mock
    private ShiftInformationRQ requestRq;
    @Mock
    private PharmacyService pharmacyService;
    @InjectMocks
    private PharmacyController pharmacyController;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPharmacyController() throws IOException {
        // prepare
        pharmacyController = Mockito.spy(pharmacyController);

        pharmacyController = new PharmacyController(pharmacyService);

        pharmacyService.pharmacyData(requestRq);
        pharmacyController.pharmacy(requestRq);

        Assert.assertNotNull(MUST_BE_A_NOTNULL, requestRq);

    }

}
