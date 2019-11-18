package com.pharmacy.turn.entities;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.pharmacy.turn.domain.Filter;
import com.pharmacy.turn.domain.ShiftInformationRQ;

@RunWith(MockitoJUnitRunner.class)
public class RequestTest {
    public static final String MUST_BE_A_NOTNULL = "can't be a null value";

    ShiftInformationRQ requestAll = getValidFilterRequest();
    ShiftInformationRQ requestCommune = getValidCommuneRequest();
    ShiftInformationRQ requestLocal = getValidLocalRequest();
    ShiftInformationRQ request = getValidRequest();

    public static ShiftInformationRQ getValidFilterRequest() {
        ShiftInformationRQ rq = new ShiftInformationRQ();
        Filter filter = new Filter();

        filter.setCommuneName("San bernardo");
        filter.setLocalName("Ahumada");

        rq.setFilter(filter);
        rq.setRegionId("7");

        return rq;
    }

    public static ShiftInformationRQ getValidCommuneRequest() {
        ShiftInformationRQ rq = new ShiftInformationRQ();
        Filter filter = new Filter();

        filter.setCommuneName("San bernardo");

        rq.setFilter(filter);
        rq.setRegionId("7");

        return rq;
    }

    public static ShiftInformationRQ getValidLocalRequest() {
        ShiftInformationRQ rq = new ShiftInformationRQ();
        Filter filter = new Filter();

        filter.setLocalName("Ahumada");

        rq.setFilter(filter);
        rq.setRegionId("7");

        return rq;
    }

    public static ShiftInformationRQ getValidRequest() {
        ShiftInformationRQ rq = new ShiftInformationRQ();

        rq.setRegionId("7");

        return rq;
    }

    @Test
    public void testParameters() {
        Assert.assertNotNull(MUST_BE_A_NOTNULL, request);
    }
}
