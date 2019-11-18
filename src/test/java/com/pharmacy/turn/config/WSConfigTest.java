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

    private WSConfig avlConfig;

    @Before
    public void before() {

        avlConfig = new WSConfig(ANY_STRING, ANY_STRING, ANY_STRING, ANY_STRING, ANY_STRING, ANY_STRING);

        avlConfig.setPharmacyEndpoint(ANY_STRING);
        avlConfig.setPharmacyProcess(ANY_STRING);
        avlConfig.setPharmacyScheme(ANY_STRING);
        avlConfig.setCommuneEndpoint(ANY_STRING);
        avlConfig.setCommuneProcess(ANY_STRING);
        avlConfig.setCommuneScheme(ANY_STRING);

    }

    @Test
    public void testEnviromentValues() {
        Assert.assertNotNull(MUST_BE_A_NOTNULL, avlConfig);
        Assert.assertNotNull(MUST_BE_A_NOTNULL, avlConfig.getPharmacyEndpoint());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, avlConfig.getPharmacyProcess());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, avlConfig.getPharmacyScheme());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, avlConfig.getCommuneEndpoint());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, avlConfig.getCommuneProcess());
        Assert.assertNotNull(MUST_BE_A_NOTNULL, avlConfig.getCommuneScheme());
    }
}
