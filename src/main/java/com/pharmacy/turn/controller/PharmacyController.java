package com.pharmacy.turn.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.turn.domain.ShiftInformationRQ;
import com.pharmacy.turn.domain.ShiftInformationRS;
import com.pharmacy.turn.service.PharmacyService;
import com.pharmacy.turn.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class PharmacyController extends BaseController {
    private PharmacyService service;

    @Autowired
    public PharmacyController(PharmacyService service) {
        this.service = service;
    }

    @GetMapping(value = "information/pharmacy", produces = Constants.TYPE_JSON)
    public ResponseEntity<List<ShiftInformationRS>> pharmacy(@Valid @RequestBody ShiftInformationRQ rq) throws IOException {
        log.info(Constants.API_REQUEST, rq);
        List<ShiftInformationRS> response = service.pharmacyData(rq);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
