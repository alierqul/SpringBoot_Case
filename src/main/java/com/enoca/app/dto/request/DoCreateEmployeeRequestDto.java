package com.enoca.app.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DoCreateEmployeeRequestDto {
    @NotNull
    @Size(min = 2,max = 255)
    private String firsName;
    @NotNull
    @Size(min = 2,max = 255)
    private String lastName;
    @NotNull
    @Size(min = 10,max = 10)
    private String phone;

}
