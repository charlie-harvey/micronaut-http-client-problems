package com.example.controller

import com.example.service.ExampleService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@Controller("/example")
@ExecuteOn(TaskExecutors.IO)
class ExampleController(
    private val exampleService: ExampleService
) {

    @Get("/delay/{wait}")
    fun delay(@PathVariable("wait") wait: Int): HttpResponse<Unit> {
        return exampleService.httpbunDelay(
            wait = wait
        )
    }
}