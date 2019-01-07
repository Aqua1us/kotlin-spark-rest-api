package com.amtkxa.kotlinsparkrestapi.user

import com.amtkxa.kotlinsparkrestapi.annotation.SparkController
import com.amtkxa.kotlinsparkrestapi.common.JsonTransformer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Route
import spark.Spark.get
import spark.Spark.path

@SparkController
class UserController {
    private val jsonTransformer = JsonTransformer(ObjectMapper().registerKotlinModule())
    private val userService = UserService()

    init {
        path("/users") {
            get("", index(), jsonTransformer)
            get("/:id", show(), jsonTransformer)
        }
    }

    fun index(): Route = Route { request, response ->
        userService.findAll()
    }

    fun show(): Route = Route { request, response ->
        userService.findById(request.params("id"))
    }
}
