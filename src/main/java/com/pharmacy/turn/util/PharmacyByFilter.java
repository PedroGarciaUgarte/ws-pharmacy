package com.pharmacy.turn.util;

import java.util.List;

import com.pharmacy.turn.domain.PharmacyData;
import com.pharmacy.turn.domain.ShiftInformationRQ;
import com.pharmacy.turn.domain.ShiftInformationRS;

public class PharmacyByFilter {

    /**
     * Receive a list of answers to which filters apply
     * 
     * @param rq
     * @param listResponse
     * @param response
     * @param pharmacy
     * @return
     */
    public ShiftInformationRS filter(ShiftInformationRQ rq, List<ShiftInformationRS> listResponse,
            ShiftInformationRS response, PharmacyData pharmacy) {

        response.setLocaliityAddress(pharmacy.getLocalityAddress());
        response.setLocalLat(pharmacy.getLocalLat());
        response.setLocalLng(pharmacy.getLocalLng());
        response.setLocalName(pharmacy.getLocalName());
        response.setLocalPhone(pharmacy.getLocalPhone());

        if (null != rq.getFilter()) {
            if (null != rq.getFilter().getCommuneName() && null != rq.getFilter().getLocalName()
                    && rq.getFilter().getCommuneName().equalsIgnoreCase(pharmacy.getCommuneName())
                    && rq.getFilter().getLocalName().equalsIgnoreCase(pharmacy.getLocalName())) {

                listResponse.add(response);
                response = new ShiftInformationRS();

            }

            if ((null == rq.getFilter().getCommuneName() || rq.getFilter().getCommuneName().equals(Constants.EMPTY_LINE))
                    && null != rq.getFilter().getLocalName()
                    && rq.getFilter().getLocalName().equalsIgnoreCase(pharmacy.getLocalName())) {

                listResponse.add(response);
                response = new ShiftInformationRS();

            }

            if ((null == rq.getFilter().getLocalName() || rq.getFilter().getLocalName().equals(Constants.EMPTY_LINE))
                    && null != rq.getFilter().getCommuneName()
                    && rq.getFilter().getCommuneName().equalsIgnoreCase(pharmacy.getCommuneName())) {

                listResponse.add(response);
                response = new ShiftInformationRS();

            }

        } else {

            listResponse.add(response);
            response = new ShiftInformationRS();

        }

        return response;
    }
}
