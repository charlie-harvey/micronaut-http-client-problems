package com.example.client

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import jakarta.validation.Valid

@Suppress("unused")
@Client("httpbun")
interface HttpbunClient {

    @Post("post")
    suspend fun post(
        @Valid @Body httpbunDTO: HttpbunDTO
    ): HttpResponse<HttpbunResponse>

    @Post("delay/{wait}")
    suspend fun delay(
        @PathVariable("wait") wait: Int
    ): HttpResponse<Unit>
}