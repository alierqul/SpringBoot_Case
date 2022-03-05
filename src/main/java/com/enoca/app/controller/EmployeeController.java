package com.enoca.app.controller;

import com.enoca.app.dto.request.DoCreateEmployeeRequestDto;
import com.enoca.app.dto.request.DoUpdateEmployeeRequestDto;
import com.enoca.app.dto.response.GetEmployeeResponseDto;
import com.enoca.app.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @Operation(summary = "Yeni Personel eklemek için yapılan method.")
    @PostMapping("/save")
    public ResponseEntity<GetEmployeeResponseDto> createEmployee(@RequestBody @Valid DoCreateEmployeeRequestDto employeeDto){
        return ResponseEntity.ok(new GetEmployeeResponseDto(employeeService.createEmployee(employeeDto)));
    }

    @Operation(summary = "Personel güncellemek için  yapılan method. Personel id zorunlu alandır.")
    @PutMapping("/update")
    public ResponseEntity<GetEmployeeResponseDto> updateEmployee(@RequestBody @Valid DoUpdateEmployeeRequestDto employeeDto){
        return ResponseEntity.ok(new GetEmployeeResponseDto(employeeService.updateEmployee(employeeDto)));
    }

    @Operation(summary = "Personel silmek için  yapılan method. Personel id si verilen kayıt varsa DB den silinecektir.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted.");
    }
    @Operation(summary = "id'si bilinen personelin bilgilerini çağıran method.")
    @GetMapping("/{id}")
    public ResponseEntity<GetEmployeeResponseDto> getEmployee(@PathVariable long id){
        return ResponseEntity.ok(new GetEmployeeResponseDto(employeeService.getEmployeeById(id)));
    }

    @Operation(summary = "Tüm Personel Kayıtlarını getiren method.")
    @GetMapping("/all")
    public ResponseEntity<List<GetEmployeeResponseDto>> getAllEmployee(){
        return ResponseEntity.ok().body(employeeService.getAllEmployee()
                .stream().map(GetEmployeeResponseDto::new)
                .collect(Collectors.toList()));
    }



}
