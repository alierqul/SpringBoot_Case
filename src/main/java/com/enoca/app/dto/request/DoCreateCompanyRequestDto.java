package com.enoca.app.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DoCreateCompanyRequestDto {
    @NotNull
    @Size(min = 2,max=255)
    private String name;
    @NotNull
    @Size(min = 5,max=255)
    private String description;
}
