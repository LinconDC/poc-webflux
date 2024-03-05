package br.com.webflux.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "Must not be null or empty")
        @Size(min = 3, max = 50, message = "Must be between 3 and 50 characters")
        String name,
        @NotBlank(message = "Must not be null or empty")
        @Email(message = "Invalid email")
        String email,
        @NotBlank(message = "Must be between 3 and 50 characters")
        @Size(min = 3, max = 20, message = "Must be between 3 and 20 characters")
        String password
) {}
