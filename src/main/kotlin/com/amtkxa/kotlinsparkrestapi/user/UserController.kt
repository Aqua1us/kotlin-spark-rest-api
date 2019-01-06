package com.amtkxa.kotlinsparkrestapi.user

import org.sql2o.Sql2o
import spark.Route


class UserController {

    fun index(): Route = Route { request, response ->
        val sql2o = Sql2o(
            "jdbc:mysql://localhost:3306/sampledb",
            "testuser",
            "testuser"
        )

        sql2o.open().use { conn ->
            conn.createQuery("select * from user").executeAndFetch(User::class.java)
        }
    }
}
