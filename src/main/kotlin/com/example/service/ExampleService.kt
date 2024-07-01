package com.example.service

import com.example.ExampleType
import com.example.client.HttpbunClient
import com.example.client.HttpbunDTO
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking

@Singleton
class ExampleService(
    private val httpbunClient: HttpbunClient
) {

    fun sendToHttpbun(id: Int, username: String): ExampleDomainObject = runBlocking {
        val resp = httpbunClient.postExample1(
            HttpbunDTO(
                id = id,
                username = username,
                type = ExampleType.Things
            )
        ).body()
        ExampleDomainObject(
            url = resp.url,
            type = ExampleType.Things
        )
    }
}