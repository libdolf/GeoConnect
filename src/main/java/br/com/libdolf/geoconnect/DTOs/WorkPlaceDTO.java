package br.com.libdolf.geoconnect.DTOs;

import br.com.libdolf.geoconnect.entities.Employee;
import br.com.libdolf.geoconnect.entities.WorkPlace;

import java.util.List;

//TODO change WP
public record WorkPlaceDTO(String name, Long internCode, LocationPointsDTO location) {

    public WorkPlace toEntity(List<Employee> employeeList){
        return WorkPlace.builder()
                .name(name())
                .internCode(internCode())
                .location(location().toEntity())
                .employees(employeeList)
                .build();
    }
}
