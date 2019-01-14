package com.amtkxa.kotlinsparkrestapi.infrastructure.util

import com.fasterxml.jackson.databind.ObjectMapper
import spark.ResponseTransformer

class JsonTransformer(private val objectMapper: ObjectMapper) : ResponseTransformer {
    /**
     * Generates a JSON from a Java object and returns the generated JSON as a string.
     *
     * @return list of User
     */
    override fun render(model: Any?): String = objectMapper.writeValueAsString(model)
}
