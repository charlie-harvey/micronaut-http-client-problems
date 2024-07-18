package com.example.controller

import com.example.ExampleType
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ExampleResponseDTO(
    val url: String,
    val type: ExampleType,
    val id: Int,
    val username: String
)