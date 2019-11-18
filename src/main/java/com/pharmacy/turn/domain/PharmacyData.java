package com.pharmacy.turn.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class PharmacyData implements Serializable {
    private static final long serialVersionUID = 4737103734517848269L;

    @Getter @Setter
    @JsonProperty("fecha")
    private String date;
    
    @Getter @Setter
    @JsonProperty("local_id")
    private String localId;
   
    @Getter @Setter
    @JsonProperty("local_nombre")
    private String localName;
    
    @Getter @Setter
    @JsonProperty("comuna_nombre")
    private String communeName;
    
    @Getter @Setter
    @JsonProperty("localidad_nombre")
    private String localityName;
    
    @Getter @Setter
    @JsonProperty("local_direccion")
    private String localityAddress;
    
    @Getter @Setter
    @JsonProperty("funcionamiento_hora_apertura")
    private String openingTime;
    
    @Getter @Setter
    @JsonProperty("funcionamiento_hora_cierre")
    private String closingTime;
    
    @Getter @Setter
    @JsonProperty("local_telefono")
    private String localPhone;
    
    @Getter @Setter
    @JsonProperty("local_lat")
    private String localLat;
    
    @Getter @Setter
    @JsonProperty("local_lng")
    private String localLng;
    
    @Getter @Setter
    @JsonProperty("funcionamiento_dia")
    private String operatingDay;
    
    @Getter @Setter
    @JsonProperty("fk_region")
    private String fkRegion;
    
    @Getter @Setter
    @JsonProperty("fk_comuna")
    private String fkCommune;
    
}
