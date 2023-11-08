package br.com.libdolf.geoconnect.services;

import br.com.libdolf.geoconnect.DTOs.EmployeeDTO;
import br.com.libdolf.geoconnect.entities.Employee;
import br.com.libdolf.geoconnect.entities.WorkPlace;
import br.com.libdolf.geoconnect.location.Location;
import br.com.libdolf.geoconnect.repositories.EmployeeRepository;
import br.com.libdolf.geoconnect.repositories.WorkPlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository repository;
    private Location location;
    private WorkPlaceRepository repository2;
    public EmployeeDTO saveNewEmployee(EmployeeDTO employeeDTO) throws Exception {
        WorkPlace workPlace = repository2.findAll().get(0);
        Employee employee = Employee.builder()
                .name(employeeDTO.name())
                .location(employeeDTO.location().toEntity())
                .workPlace(workPlace)
                .build();
        repository.save(employee);
        return employeeDTO;
    }
}
