package br.com.libdolf.geoconnect.DTOs.Response;

import br.com.libdolf.geoconnect.DTOs.EmployeeDTO;

import java.util.Set;

public record WorkPlaceResponse(String name, Long internCode, Set<EmployeeDTO> employees)  {
}
