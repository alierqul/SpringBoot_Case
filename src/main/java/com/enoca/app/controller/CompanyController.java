package com.enoca.app.controller;

import com.enoca.app.dto.request.DoCreateCompanyRequestDto;
import com.enoca.app.dto.request.DoUpdateCompanyRequestDto;
import com.enoca.app.dto.response.GetCompanyResponseDto;
import com.enoca.app.dto.response.GetEmployeeResponseDto;
import com.enoca.app.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @Operation(summary = "Yeni Bir Şirket kaydı açmak için kullanılan method.")
    @PostMapping("/save")
    public ResponseEntity<GetCompanyResponseDto> createCompany(@RequestBody @Valid DoCreateCompanyRequestDto companyDto){
        return ResponseEntity.ok(new GetCompanyResponseDto(companyService.createCompany(companyDto)));
    }

    @Operation(summary = "Şirket bilgilerini güncellemek için kullanılan method. method içinde id zorunlu alandır.")
    @PutMapping("/update")
    public ResponseEntity<GetCompanyResponseDto> updateCompany(@RequestBody @Valid DoUpdateCompanyRequestDto companyDto){
        return ResponseEntity.ok(new GetCompanyResponseDto(companyService.updateCompany(companyDto)));
    }

    @Operation(summary = "Kayıtlı şirket Silme işleminin yapıldığı method. Uyarı İlişkili personel varsa silmeye izin vermicektir. Silmeden önce personelleri farklı bir şirkete taşımanız gerekir.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id){
        return ResponseEntity.ok(companyService.deleteCompany(id));
    }

    @Operation(summary = "id ye göre şirket bilgilerini çekmek için kullanılır.")
    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyResponseDto> getCompany(@PathVariable long id){

        return ResponseEntity.ok(new GetCompanyResponseDto(companyService.getCompanyById(id)));
    }

    @Operation(summary = "Kayıtlı olan tüm şirket bilgilerini çekmek için kullanılır.")
    @GetMapping("/all")
    public ResponseEntity<List<GetCompanyResponseDto>> getAllCompany(){
        return  ResponseEntity.ok().body(companyService.getAllCompany()
                .stream().map(GetCompanyResponseDto::new)
                .collect(Collectors.toList()));
    }

    @Operation(summary = "id si verilen şirket çalışanlarını bulma.")
    @GetMapping("/employees/{id}")
    public ResponseEntity<List<GetEmployeeResponseDto>> getAllEmployeesByCompany(@PathVariable long id){
        return  ResponseEntity.ok().body(companyService.getAllEmployeesByID(id)
                .stream().map(GetEmployeeResponseDto::new)
                .collect(Collectors.toList()));
    }

    @Operation(summary = "Şirkete Personel eklemek için kullanılır. ilk id şirkete ait ikinci id personelin id si.")
    @PostMapping("/{companyID}/{employeID}")
    public ResponseEntity<String> addEmployeetoList(@PathVariable(name = "companyID") long companyID,@PathVariable(name = "employeID") long employeID){
        return ResponseEntity.ok(companyService.addEmployee(companyID,employeID));
    }



}
