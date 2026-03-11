package com.example.emptask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    private Integer id;

    @NotBlank(message="Name required")
    private String name;

    @NotNull
    private Double salary;

    private String department;

    private String location;

    private LocalDate hireDate;
}
