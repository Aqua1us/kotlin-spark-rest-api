package com.amtkxa.kotlinsparkrestapi.user

import spark.Route


class UserController {
    private val repository = UserRepository()

    fun index(): Route = Route { request, response ->
        repository.findAll()
    }
}
