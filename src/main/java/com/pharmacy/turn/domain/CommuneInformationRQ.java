package com.pharmacy.turn.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CommuneInformationRQ implements Serializable{
    private static final long serialVersionUID = 6897318141055803191L;

    @JsonProperty("reg_id")
    private String regionId;
    
}
