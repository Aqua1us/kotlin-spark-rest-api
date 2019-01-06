package com.amtkxa.kotlinsparkrestapi.user

import com.amtkxa.kotlinsparkrestapi.common.DBConnectionManager


class UserRepository {

    fun findAll(): List<User> =
        DBConnectionManager.getConnection().open().use { conn ->
            conn.createQuery("SELECT id, name FROM user").executeAndFetch(User::class.java)
        }
}
