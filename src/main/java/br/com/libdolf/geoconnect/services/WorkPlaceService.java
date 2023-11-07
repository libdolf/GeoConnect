package br.com.libdolf.geoconnect.services;

import br.com.libdolf.geoconnect.entities.WorkPlace;
import br.com.libdolf.geoconnect.repositories.WorkPlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkPlaceService {

    private WorkPlaceRepository repository;

    public List<WorkPlace> findAllWorkPlaces(){
        return repository.findAll();
    }
}
