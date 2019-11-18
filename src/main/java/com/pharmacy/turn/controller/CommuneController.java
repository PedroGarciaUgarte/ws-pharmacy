package com.pharmacy.turn.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.turn.domain.CommuneInformationRQ;
import com.pharmacy.turn.service.CommuneService;
import com.pharmacy.turn.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class CommuneController extends BaseController {
    private CommuneService service;

    @Autowired
    public CommuneController(CommuneService service) {
        this.service = service;
    }

    @PostMapping(value = "information/commune", consumes = "application/json", produces = "text/html")
    public ResponseEntity<String> communes(@Valid @RequestBody CommuneInformationRQ rq) throws IOException {
        log.info(Constants.API_REQUEST, rq);
        String response = service.communeData(rq);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
