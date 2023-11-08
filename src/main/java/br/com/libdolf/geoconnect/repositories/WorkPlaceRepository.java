package br.com.libdolf.geoconnect.repositories;

import br.com.libdolf.geoconnect.entities.WorkPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//TODO change "WORK PLACE" to other thing
@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlace, String> {
    WorkPlace save(WorkPlace workPlace);

}
