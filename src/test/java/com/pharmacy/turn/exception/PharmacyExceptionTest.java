package com.pharmacy.turn.exception;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PharmacyExceptionTest {
    public static final String MUST_BE_A_NOTNULL = "can't be a null value";

    PharmacyException ex = new PharmacyException("Authorization error");

    @Test
    public void testErrorHandlerTest() {
        Assert.assertNotNull(MUST_BE_A_NOTNULL, ex);
        Assert.assertNotNull(MUST_BE_A_NOTNULL, ex.getMessage());

    }
}
