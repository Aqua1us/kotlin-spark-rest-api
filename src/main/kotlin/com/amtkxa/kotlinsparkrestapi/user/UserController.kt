package com.amtkxa.kotlinsparkrestapi.user

import com.amtkxa.kotlinsparkrestapi.common.DBConnectionManager
import spark.Route


class UserController {

    fun index(): Route = Route { request, response ->
        DBConnectionManager.getConnection().use { conn ->
            conn.createQuery("select * from user").executeAndFetch(User::class.java)
        }
    }
}
