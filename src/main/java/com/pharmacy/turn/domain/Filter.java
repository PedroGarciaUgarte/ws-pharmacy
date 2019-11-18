package com.pharmacy.turn.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Filter implements Serializable {
    private static final long serialVersionUID = -8298445696750492851L;

    @Getter @Setter
    @JsonProperty("local_nombre")
    private String localName;
    
    @Getter @Setter
    @JsonProperty("comuna_nombre")
    private String communeName;
    
}
