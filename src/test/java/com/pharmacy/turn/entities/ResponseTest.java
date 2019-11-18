package com.pharmacy.turn.entities;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.pharmacy.turn.domain.PharmacyData;

@RunWith(MockitoJUnitRunner.class)
public class ResponseTest {
    public static final String MUST_BE_A_NOTNULL = "can't be a null value";
    
    PharmacyData responseAllFilter = getValidResponseAllFilter();
    PharmacyData responseCommuneFilter = getResponseCommuneFilter();
    PharmacyData responseLocalFilter = getResponseLocalFilter();
    PharmacyData responseNoFilter = getValidResponse();
    
    public static PharmacyData getValidResponseAllFilter() {
        PharmacyData rs = new PharmacyData();

        rs.setCommuneName("san bernardo");
        rs.setLocalName("ahumada");
        rs.setClosingTime("");
        rs.setDate("");
        rs.setFkCommune("");
        rs.setFkRegion("");
        rs.setLocalId("");
        
        return rs;
    }
    
    public static PharmacyData getResponseCommuneFilter() {
        PharmacyData rs = new PharmacyData();

        rs.setCommuneName("san bernardo");
        rs.setClosingTime("");
        rs.setDate("");
        rs.setFkCommune("");
        rs.setFkRegion("");
        rs.setLocalId("");
        
        return rs;
    }
    
    public static PharmacyData getResponseLocalFilter() {
        PharmacyData rs = new PharmacyData();

        rs.setLocalName("ahumada");
        rs.setClosingTime("");
        rs.setDate("");
        rs.setFkCommune("");
        rs.setFkRegion("");
        rs.setLocalId("");
        
        return rs;
    }
    
    public static PharmacyData getValidResponse() {
        PharmacyData rs = new PharmacyData();

        rs.setCommuneName("");
        rs.setLocalName("");
        rs.setClosingTime("");
        rs.setDate("");
        rs.setFkCommune("");
        rs.setFkRegion("");
        rs.setLocalId("");
        
        return rs;
    }
    
    @Test
    public void testParameters() {
        Assert.assertNotNull(MUST_BE_A_NOTNULL, responseAllFilter);
    }
    
}
