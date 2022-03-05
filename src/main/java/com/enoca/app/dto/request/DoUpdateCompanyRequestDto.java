package com.enoca.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoUpdateCompanyRequestDto {
    @NotNull
    @Min(0)
    private long id;
    private String name;
    private String description;
}
