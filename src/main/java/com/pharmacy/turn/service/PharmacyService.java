package com.pharmacy.turn.service;

import java.io.IOException;
import java.util.List;

import com.pharmacy.turn.domain.ShiftInformationRQ;
import com.pharmacy.turn.domain.ShiftInformationRS;

public interface PharmacyService {
    List<ShiftInformationRS> pharmacyData(ShiftInformationRQ rq) throws IOException;

}
