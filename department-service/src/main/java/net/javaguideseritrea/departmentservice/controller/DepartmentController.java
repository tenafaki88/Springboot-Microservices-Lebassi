package net.javaguideseritrea.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.javaguideseritrea.departmentservice.dto.DepartmentDto;
import net.javaguideseritrea.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor 
@RequestMapping(value ="/api/departments")  
public class DepartmentController {

    private DepartmentService departmentService;

    // build save Department REST API  
    @PostMapping       
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.savedDepartment(departmentDto);
        
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // build get Department REST API
    @GetMapping("{department-code}")  
    
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);   
    }
}

