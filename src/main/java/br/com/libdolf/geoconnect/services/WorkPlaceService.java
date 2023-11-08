package br.com.libdolf.geoconnect.services;

import br.com.libdolf.geoconnect.DTOs.EmployeeDTO;
import br.com.libdolf.geoconnect.DTOs.Response.WorkPlaceResponse;
import br.com.libdolf.geoconnect.DTOs.WorkPlaceDTO;
import br.com.libdolf.geoconnect.entities.WorkPlace;
import br.com.libdolf.geoconnect.repositories.WorkPlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkPlaceService {

    private WorkPlaceRepository repository;
    public WorkPlaceDTO saveNewWorkPlace(WorkPlaceDTO workPlaceDTO) throws Exception{
        WorkPlace workPlaceSaved = repository.save(workPlaceDTO.toEntity());

        if (workPlaceSaved == null) {
            throw new Exception();
        } else return workPlaceSaved.toDTO();
    }

    public List<WorkPlace> findAllWorkPlaces(){
        return repository.findAll();
    }

    public WorkPlaceResponse findWorkPlaceById(String id) {
        WorkPlace workPlace = repository.findById(id).orElseThrow();
        return new WorkPlaceResponse(workPlace.getName(), workPlace.getInternCode(),
                workPlace.getEmployees()
                        .stream()
                        .map(employee -> new EmployeeDTO(employee.getName(), employee.getLocation().toDTO())).collect(Collectors.toSet()));
    }
}
