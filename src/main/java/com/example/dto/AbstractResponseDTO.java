package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class AbstractResponseDTO {

    private String type = "Response";
    @ApiModelProperty(required = true, example = "2020-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate time = LocalDate.now();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
