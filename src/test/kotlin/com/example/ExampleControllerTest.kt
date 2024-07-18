package com.example

import com.example.client.HttpbunClient
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.next
import io.kotest.property.arbitrary.nonNegativeInt
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactive.asFlow

@MicronautTest
class ExampleControllerTest(
    @Client("/") private val client: HttpClient,
    private val httpbunClient: HttpbunClient
): AnnotationSpec() {

    @Ignore
    suspend fun testClientDirectly() = coroutineScope {
        repeat(20) {
            launch {
                repeat(5) {
                    val genWait = Arb.nonNegativeInt(15).next()
                    val resp = httpbunClient.delay(wait = genWait)
                    println(" ** HttpbunClient - httpbun delay ($genWait) response status: ${resp.status}")
                }
            }
        }
    }

    @Test
    suspend fun testController() = coroutineScope {
        repeat(20) {
            launch {
                repeat(5) {
                    // val genWait = Arb.nonNegativeInt(15).next()
                    val genWait = 10   // Any Value >= 10 will fail if `micronaut.http.client.read-timeout` is not set
                    val req = HttpRequest.GET<HttpResponse<Unit>>("/example/delay/${genWait}")
                    client.exchange(req).asFlow().collect { resp ->
                        println(" ** ExampleControllerTest - httpbun delay ($genWait) response status: ${resp.status}")
                    }
                }
            }
        }
    }
}
