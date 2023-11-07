package br.com.libdolf.geoconnect.services;

import br.com.libdolf.geoconnect.DTOs.EmployeeDTO;
import br.com.libdolf.geoconnect.entities.Employee;
import br.com.libdolf.geoconnect.entities.WorkPlace;
import br.com.libdolf.geoconnect.location.Location;
import br.com.libdolf.geoconnect.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository repository;
    private Location location;
    public EmployeeDTO saveNewEmployee(EmployeeDTO employeeDTO) throws Exception {
        Employee employee = employeeDTO.toEntity();

        employee.setWorkPlace(location.getBestWorkPlaceByLocation(employeeDTO));

        Employee employeeSaved = repository.save(employee);

        if (employeeSaved == null){
            throw new Exception();
        } else return employeeDTO;
    }
}
