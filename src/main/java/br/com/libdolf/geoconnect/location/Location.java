package br.com.libdolf.geoconnect.location;

import br.com.libdolf.geoconnect.DTOs.EmployeeDTO;
import br.com.libdolf.geoconnect.DTOs.LocationPointsDTO;
import br.com.libdolf.geoconnect.entities.Employee;
import br.com.libdolf.geoconnect.entities.LocationPoints;
import br.com.libdolf.geoconnect.entities.WorkPlace;
import br.com.libdolf.geoconnect.services.WorkPlaceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//TODO change "WORK PLACE" to other thing

@Component
@AllArgsConstructor
public class Location {
    private WorkPlaceService workPlaceService;

    public WorkPlace getBestWorkPlaceByLocation(EmployeeDTO employee){
        List<WorkPlace> allWorkPlaces = workPlaceService.findAllWorkPlaces();

        List<WorkPlace> bestWP = new ArrayList<>();

        for (WorkPlace workPlace: allWorkPlaces){
            Double distance = calculateDistance(workPlace.getLocation(), employee.location());
            if (distance <= 20.0){
                bestWP.add(workPlace);
            }
        }
        return bestWP.get(0);
    }


    private static double calculateDistance(LocationPoints workPlaceLocation, LocationPointsDTO employeeLocation){
        double R = 637.0; //Raio médio da terra

        double latWP = Math.toRadians(workPlaceLocation.getLatitude());
        double lonWP = Math.toRadians(workPlaceLocation.getLongitude());

        double latE = Math.toRadians(employeeLocation.latitude());
        double lonE = Math.toRadians(employeeLocation.longitude());

        double dlat = latE - latWP;
        double dlon = lonE - lonWP;

        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) + Math.cos(latWP) * Math.cos(latE) * Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }


}
