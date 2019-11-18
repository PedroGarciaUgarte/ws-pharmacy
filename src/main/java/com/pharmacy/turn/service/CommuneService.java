package com.pharmacy.turn.service;

import java.io.IOException;

import com.pharmacy.turn.domain.CommuneInformationRQ;

public interface CommuneService {
    String communeData(CommuneInformationRQ rq) throws IOException;

}
