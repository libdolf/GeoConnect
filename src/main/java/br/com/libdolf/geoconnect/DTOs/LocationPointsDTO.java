package br.com.libdolf.geoconnect.DTOs;

import br.com.libdolf.geoconnect.entities.LocationPoints;

public record LocationPointsDTO(Double latitude, Double longitude) {
    public LocationPoints toEntity(){
        return LocationPoints.builder()
                .latitude(latitude())
                .longitude(longitude())
                .build();
    }
}
