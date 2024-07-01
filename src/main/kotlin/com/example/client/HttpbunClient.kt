package com.example.client

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import jakarta.validation.Valid

@Suppress("unused")
@Client("HttpbunClient")
interface HttpbunClient {

    @Post("post")
    suspend fun postExample1(
        @Valid @Body httpbunDTO: HttpbunDTO
    ): HttpResponse<HttpbunResponse>
}