package br.com.libdolf.geoconnect.DTOs;

import br.com.libdolf.geoconnect.entities.Employee;
import br.com.libdolf.geoconnect.entities.LocationPoints;

public record EmployeeDTO(String name, LocationPointsDTO location) {
    public Employee toEntity(){
        return Employee.builder()
                .name(name())
                .location(location().toEntity())
                .build();
    }
}
