package com.pharmacy.turn.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmacy.turn.config.WSConfig;
import com.pharmacy.turn.domain.PharmacyData;
import com.pharmacy.turn.domain.ShiftInformationRQ;
import com.pharmacy.turn.domain.ShiftInformationRS;
import com.pharmacy.turn.exception.PharmacyRestException;
import com.pharmacy.turn.service.PharmacyService;
import com.pharmacy.turn.util.PharmacyByFilter;
import com.pharmacy.turn.ws.WSPharmacyClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PharmacyServiceImpl implements PharmacyService {

    private WSConfig config;

    @Autowired
    public PharmacyServiceImpl(WSConfig flightConfig) {
        this.config = flightConfig;
    }

    /**
     * Implementation that handles the service call and returns it as a list with
     * filters applied
     * 
     * @param rq
     * @return List<ShiftInformationRS> listResponse
     * @throws IOException
     */
    public List<ShiftInformationRS> pharmacyData(ShiftInformationRQ rq) throws IOException {

        WSPharmacyClient client = new WSPharmacyClient();
        PharmacyByFilter pharmacyByFilter = new PharmacyByFilter();
        ObjectMapper mapper = new ObjectMapper();

        List<ShiftInformationRS> listResponse = new ArrayList<>();
        ShiftInformationRS response = new ShiftInformationRS();

        try {
            String responseApi = client.call(rq, config);
            PharmacyData[] rs = mapper.readValue(responseApi, PharmacyData[].class);
            List<PharmacyData> pharmacyList = Arrays.asList(rs);

            if (null != pharmacyList) {
                for (PharmacyData pharmacy : pharmacyList) {
                    response = pharmacyByFilter.filter(rq, listResponse, response, pharmacy);
                }
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new PharmacyRestException(e.getMessage());
        }

        return listResponse;
    }

}
