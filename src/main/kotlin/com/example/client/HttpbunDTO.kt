package com.example.client

import com.example.ExampleType
import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class HttpbunDTO(
    @field:JsonProperty("id")
    val id: Int,
    @field:JsonProperty("username")
    val username: String,
    @field:JsonProperty("type")
    val type: ExampleType
)
