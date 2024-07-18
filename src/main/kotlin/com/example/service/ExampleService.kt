package com.example.service

import com.example.client.HttpbunClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.exceptions.HttpClientResponseException
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking

@Singleton
class ExampleService(
    private val httpbunClient: HttpbunClient
) {

    fun httpbunDelay(
        wait: Int
    ): HttpResponse<Unit> = runBlocking {
        try {
            httpbunClient.delay(wait = wait)
        } catch (ex: HttpClientResponseException) {
            println(ex.localizedMessage)
            throw ex
        }
    }
}