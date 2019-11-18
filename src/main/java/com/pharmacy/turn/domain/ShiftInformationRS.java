package com.pharmacy.turn.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class ShiftInformationRS implements Serializable {
    private static final long serialVersionUID = -4341946134861170219L;

    @Getter @Setter
    @JsonProperty("local_nombre")
    private String localName;
    
    @Getter @Setter
    @JsonProperty("local_direccion")
    private String localiityAddress;
    
    @Getter @Setter
    @JsonProperty("local_telefono")
    private String localPhone;
    
    @Getter @Setter
    @JsonProperty("local_lat")
    private String localLat;
    
    @Getter @Setter
    @JsonProperty("local_lng")
    private String localLng;
    
}
