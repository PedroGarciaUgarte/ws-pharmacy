package com.pharmacy.turn.util;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.pharmacy.turn.domain.PharmacyData;
import com.pharmacy.turn.domain.ShiftInformationRQ;
import com.pharmacy.turn.domain.ShiftInformationRS;
import com.pharmacy.turn.entities.RequestTest;
import com.pharmacy.turn.entities.ResponseTest;

@RunWith(MockitoJUnitRunner.class)
public class PharmacyByFilterTest {

    private static final String MUST_BE_A_NOTNULL = "Must be a not null";

    @InjectMocks
    ShiftInformationRQ rqAll = RequestTest.getValidFilterRequest();
    @InjectMocks
    ShiftInformationRQ rqCommune = RequestTest.getValidCommuneRequest();
    @InjectMocks
    ShiftInformationRQ rqLocal = RequestTest.getValidLocalRequest();
    @InjectMocks
    ShiftInformationRQ rq = RequestTest.getValidRequest();
    @InjectMocks
    PharmacyData pharmacyNotData = ResponseTest.getValidResponse();
    @InjectMocks
    PharmacyData pharmacyAllData = ResponseTest.getValidResponseAllFilter();
    @InjectMocks
    PharmacyData pharmacyCommuneData = ResponseTest.getResponseCommuneFilter();
    @InjectMocks
    PharmacyData pharmacyLocalData = ResponseTest.getResponseLocalFilter();
    @Mock
    List<ShiftInformationRS> listResponse;
    @Mock
    ShiftInformationRS response;
    @InjectMocks
    PharmacyByFilter pharmacy = new PharmacyByFilter();

    @Test
    public void notFilter() {
        pharmacy.filter(rq, listResponse, response, pharmacyNotData);
        Assert.assertNotNull(MUST_BE_A_NOTNULL, response);
        pharmacy.filter(rqAll, listResponse, response, pharmacyAllData);
        Assert.assertNotNull(MUST_BE_A_NOTNULL, response);
        pharmacy.filter(rqCommune, listResponse, response, pharmacyCommuneData);
        Assert.assertNotNull(MUST_BE_A_NOTNULL, response);
        pharmacy.filter(rqLocal, listResponse, response, pharmacyLocalData);
        Assert.assertNotNull(MUST_BE_A_NOTNULL, response);
    }

}
