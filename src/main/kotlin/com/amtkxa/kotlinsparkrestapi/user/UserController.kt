package com.amtkxa.kotlinsparkrestapi.user

import com.amtkxa.kotlinsparkrestapi.annotation.SparkController
import com.amtkxa.kotlinsparkrestapi.common.JsonTransformer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Route
import spark.Spark.*

@SparkController
class UserController {
    private val jsonTransformer = JsonTransformer(ObjectMapper().registerKotlinModule())
    private val mapper = ObjectMapper()
    private val userService = UserService()

    init {
        path("/users") {
            get("", index(), jsonTransformer)
            get("/:id", show(), jsonTransformer)
            post("", create(), jsonTransformer)
        }
    }

    fun index(): Route = Route { req, res ->
        userService.findAll()
    }

    fun show(): Route = Route { req, res ->
        userService.findById(req.params("id"))
    }

    fun create(): Route = Route { req, res ->
        val request = mapper.readValue(req.body(), User::class.java)
        val createdId = userService.save(request.id, request.name)
        res.status(201)
        createdId
    }
}
