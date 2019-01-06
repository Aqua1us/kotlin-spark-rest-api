package com.amtkxa.kotlinsparkrestapi

import com.amtkxa.kotlinsparkrestapi.common.JsonTransformer
import com.amtkxa.kotlinsparkrestapi.user.UserController
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.*
import spark.servlet.SparkApplication

class Server : SparkApplication {
    private val jsonTransformer = JsonTransformer(ObjectMapper().registerKotlinModule())
    private val userController = UserController()

    constructor(args: Array<String>) {
        initServer()
        initRoutes()
    }

    override fun init() = Unit

    /**
     * Initialize the configuration for embedded Jetty server.
     */
    private fun initServer() {
        port(8080)
    }

    /**
     * Initialize the route of the Spark application.
     */
    private fun initRoutes() {
        redirect.any("/", "/users")

        path("/users") {
            get("", userController.index(), jsonTransformer)
        }
    }
}
