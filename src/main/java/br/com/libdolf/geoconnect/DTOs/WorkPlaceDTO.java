package br.com.libdolf.geoconnect.DTOs;

import br.com.libdolf.geoconnect.entities.WorkPlace;
//TODO change WP
public record WorkPlaceDTO(String name, Long internCode, LocationPointsDTO location) {

    public WorkPlace toEntity(){
        return WorkPlace.builder()
                .name(name())
                .internCode(internCode())
                .location(location().toEntity())
                .build();
    }
}
