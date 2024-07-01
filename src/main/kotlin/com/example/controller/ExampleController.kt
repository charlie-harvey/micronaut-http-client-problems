package com.example.controller

import com.example.service.ExampleService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.validation.Validated
import jakarta.validation.Valid

@Controller("/example")
@Validated
@ExecuteOn(TaskExecutors.VIRTUAL)
class ExampleController(
    private val exampleService: ExampleService
) {

    @Post("/sample")
    fun sample(@Valid @Body req: ExampleDTO): ExampleResponseDTO =
        exampleService.sendToHttpbun(
            id = req.id,
            username = req.username
        ).let {
            ExampleResponseDTO(
                url = it.url,
                type = it.type
            )
        }
}