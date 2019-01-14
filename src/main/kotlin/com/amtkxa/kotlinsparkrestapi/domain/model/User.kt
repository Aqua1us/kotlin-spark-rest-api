package com.amtkxa.kotlinsparkrestapi.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class User(
    @JsonProperty("id", required = true)
    val id: Long,

    @JsonProperty("name", required = true)
    val name: String
)
