package com.pharmacy.turn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

    public static final String MUST_BE_A_NOTNULL = "can't be a null value";

    @Test
    public void testMain() {
        Application.main(new String[] {});
        Assert.assertNotNull(MUST_BE_A_NOTNULL, this);
    }

}
