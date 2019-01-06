package com.amtkxa.kotlinsparkrestapi.user

import spark.Route


class UserController {
    private val userService = UserService()

    fun index(): Route = Route { request, response ->
        userService.findAll()
    }
}
