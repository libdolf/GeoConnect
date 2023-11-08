package br.com.libdolf.geoconnect.controllers;

import br.com.libdolf.geoconnect.DTOs.Response.WorkPlaceResponse;
import br.com.libdolf.geoconnect.DTOs.WorkPlaceDTO;
import br.com.libdolf.geoconnect.services.WorkPlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO change "WORK PLACE" to other thing
@RestController
@RequestMapping("/v1/work-place/")
@AllArgsConstructor
public class WorkPlaceController {

    private WorkPlaceService service;

    @PostMapping
    public ResponseEntity<WorkPlaceDTO> postNewWorkPlace(@RequestBody WorkPlaceDTO request) throws Exception{
        return ResponseEntity.ok(service.saveNewWorkPlace(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkPlaceResponse> getWorkPlace(@PathVariable String id) {
        return ResponseEntity.ok(service.findWorkPlaceById(id));
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateEmployee(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}
