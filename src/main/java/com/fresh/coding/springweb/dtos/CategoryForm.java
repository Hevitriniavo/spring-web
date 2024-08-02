package com.fresh.coding.springweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryForm(
        Long id,
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 100, message = "Name must be less than 100 characters")
        String name,
        @NotBlank(message = "Description cannot be blank")
        @Size(max = 255, message = "Description must be less than 255 characters")
        String description
) {
}
