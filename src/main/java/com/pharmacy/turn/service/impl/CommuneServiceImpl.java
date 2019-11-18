package com.pharmacy.turn.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.turn.config.WSConfig;
import com.pharmacy.turn.domain.CommuneInformationRQ;
import com.pharmacy.turn.service.CommuneService;
import com.pharmacy.turn.ws.WSCommuneClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommuneServiceImpl implements CommuneService {

    private WSConfig config;

    @Autowired
    public CommuneServiceImpl(WSConfig flightConfig) {
        this.config = flightConfig;
    }

    /**
     * Implementation that handles the service call and returns it as a list
     * 
     * @param rq
     * @return List<ShiftInformationRS> listResponse
     * @throws IOException
     */
    public String communeData(CommuneInformationRQ rq) throws IOException {

        WSCommuneClient client = new WSCommuneClient();
        String responseApi = client.call(rq, config);

        log.info(responseApi);
        
        return responseApi;
    }
    
    
    

}
