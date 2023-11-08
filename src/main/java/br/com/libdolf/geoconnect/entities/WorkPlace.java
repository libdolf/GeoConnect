package br.com.libdolf.geoconnect.entities;

import br.com.libdolf.geoconnect.DTOs.WorkPlaceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//TODO change "WORK PLACE" to other thing
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WorkPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Long internCode;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "locationId")
    private LocationPoints location;

    @OneToMany
    private Set<Employee> employees = new HashSet<>();


   public WorkPlaceDTO toDTO(){
        return new WorkPlaceDTO(this.name, this.internCode, this.location.toDTO());
    }
}
