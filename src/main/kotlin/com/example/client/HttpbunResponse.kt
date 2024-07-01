package com.example.client

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class HttpbunResponse(
    @field:JsonProperty("method")
    val method: String,
    @field:JsonProperty("headers")
    val headers: Map<String, String>,
    @field:JsonProperty("origin")
    val origin: String,
    @field:JsonProperty("url")
    val url: String,
    // "args": {},
    // "form": {},
    // "data": "{\"stuff\":\"junk\"}",
    // "json": { "stuff": "junk" },
    // "files": {}
)