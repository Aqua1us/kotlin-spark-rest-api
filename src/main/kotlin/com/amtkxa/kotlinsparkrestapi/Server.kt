package com.amtkxa.kotlinsparkrestapi

import com.amtkxa.kotlinsparkrestapi.common.JsonTransformer
import com.amtkxa.kotlinsparkrestapi.user.UserController
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get
import spark.Spark.port
import spark.servlet.SparkApplication

class Server : SparkApplication {
    private val objectMapper = ObjectMapper().registerKotlinModule()
    private val jsonTransformer = JsonTransformer(objectMapper)
    private val userController = UserController()

    constructor(args: Array<String>) {
        // Start embedded server at this port
        port(8080)
        get("/") { request, response -> "Welcome" }
        get("/users", userController.index(), jsonTransformer)
    }

    override fun init() {

    }
}
