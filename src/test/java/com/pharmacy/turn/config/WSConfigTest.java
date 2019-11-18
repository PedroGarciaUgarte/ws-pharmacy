package com.pharmacy.turn.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WSConfigTest {

    public static final String MUST_BE_A_NOTNULL = "can't be a null value";
    public static final String ANY_STRING = "";

    private WSConfig config;

    @Before
    public void before() {

        config = new WSConfig(ANY_STRING, ANY_STRING, ANY_STRING, ANY_STRING, ANY_STRING, ANY_STRING);

        config.setPharmacyEndpoint(ANY_STRING);
        config.setPharmacyProcess(ANY_STRING);
        config.setPharmacyScheme(ANY_STRING);
        config.setCommuneEndpoint(ANY_STRING);
        config.setCommuneProcess(ANY_STRING);
        config.setCommuneScheme(ANY_STRING);

    }

    @Test
    public void testEnviromentValues() {
        Assert.assertNotNull(MUST_BE_A_NOTNULL, config);
        Assert.assertNotNull(MUST_BE_A_NOTNULL, config.getPharmacyEndpoint());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, config.getPharmacyProcess());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, config.getPharmacyScheme());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, config.getCommuneEndpoint());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, config.getCommuneProcess());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, config.getCommuneScheme());
    }
}
