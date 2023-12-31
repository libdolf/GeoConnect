package br.com.libdolf.geoconnect.entities;

import br.com.libdolf.geoconnect.DTOs.LocationPointsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationPoints implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double latitude;
    private Double longitude;

    public LocationPointsDTO toDTO() {
        return new LocationPointsDTO(this.latitude, this.longitude);
    }
}
