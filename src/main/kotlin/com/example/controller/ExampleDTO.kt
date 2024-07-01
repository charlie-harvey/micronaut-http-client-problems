package com.example.controller

import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotNull

@Serdeable
data class ExampleDTO(
    @field:NotNull
    val id: Int,
    @field:NotNull
    val username: String
)