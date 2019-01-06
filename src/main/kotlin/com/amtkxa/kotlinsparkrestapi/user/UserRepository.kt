package com.amtkxa.kotlinsparkrestapi.user

import com.amtkxa.kotlinsparkrestapi.common.DBConnectionManager


class UserRepository {

    fun findAll(): List<User> =
        DBConnectionManager.getConnection().use { conn ->
            conn.createQuery("select * from user").executeAndFetch(User::class.java)
        }
}
