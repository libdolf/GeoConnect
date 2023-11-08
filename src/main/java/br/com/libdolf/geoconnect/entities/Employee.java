package br.com.libdolf.geoconnect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    private LocationPoints location;

    @ManyToOne
    private WorkPlace workPlace;
}
