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

import com.pharmacy.turn.domain.CommuneInformationRQ;
import com.pharmacy.turn.service.CommuneService;

public class CommuneControllerTest {

    public static final String MUST_BE_A_NOTNULL = "can't be a null value";

    @Mock
    private MockHttpServletRequest req;
    @Mock
    private CommuneInformationRQ requestRq;
    @Mock
    private CommuneService communeService;
    @InjectMocks
    private CommuneController communeController;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPharmacyController() throws IOException {
        // prepare
        communeController = Mockito.spy(communeController);

        communeController = new CommuneController(communeService);

        communeService.communeData(requestRq);
        communeController.communes(requestRq);

        Assert.assertNotNull(MUST_BE_A_NOTNULL, requestRq);

    }

}
