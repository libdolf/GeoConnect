package br.com.libdolf.geoconnect.controllers;

import br.com.libdolf.geoconnect.DTOs.EmployeeDTO;
import br.com.libdolf.geoconnect.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/employee/")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDTO> postNewEmployee(@RequestBody EmployeeDTO request) throws Exception{
        return ResponseEntity.ok(service.saveNewEmployee(request));
    }
    @GetMapping
    public ResponseEntity getEmployee(){
        return ResponseEntity.ok().build();
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
