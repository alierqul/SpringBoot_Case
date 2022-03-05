package com.enoca.app.dto.request;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
public class DoUpdateCompanyRequestDto {
    @NotNull
    @Min(0)
    private long id;
    private String name;
    private String description;
}
