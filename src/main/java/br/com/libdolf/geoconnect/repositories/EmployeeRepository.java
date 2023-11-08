package br.com.libdolf.geoconnect.repositories;

import br.com.libdolf.geoconnect.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
