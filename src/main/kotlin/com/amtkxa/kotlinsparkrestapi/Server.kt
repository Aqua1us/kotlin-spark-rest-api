package com.amtkxa.kotlinsparkrestapi

import com.amtkxa.kotlinsparkrestapi.annotation.SparkController
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import org.reflections.scanners.SubTypesScanner
import org.reflections.scanners.TypeAnnotationsScanner
import org.slf4j.LoggerFactory
import spark.Spark.port
import spark.servlet.SparkApplication

class Server : SparkApplication {
    val logger = LoggerFactory.getLogger(Server::class.java)

    override fun init() = Unit

    constructor(args: Array<String>) {
        initServer()
        initControllers()
    }

    /**
     * Initialize the configuration for embedded Jetty server.
     */
    private fun initServer() {
        port(8080)
    }

    /**
     * Initialize controllers.
     *
     * @apiNote The Route setting is described in the class given the {@link SparkController) annotation.
     */
    private fun initControllers() {
        val reflections = Reflections(
            this.javaClass.`package`.name, MethodAnnotationsScanner(), TypeAnnotationsScanner(), SubTypesScanner()
        )
        val controllers = reflections.getTypesAnnotatedWith(SparkController::class.java)
        controllers.forEach {
            logger.info("Instantiating controller: " + it.name)
            it.newInstance()
        }
    }
}
