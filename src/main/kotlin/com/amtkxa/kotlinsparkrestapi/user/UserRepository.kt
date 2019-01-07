package com.amtkxa.kotlinsparkrestapi.user

import com.amtkxa.kotlinsparkrestapi.common.DBConnectionManager


class UserRepository {

    fun findAll(): List<User> =
        DBConnectionManager.getConnection().open().use { conn ->
            conn.createQuery("SELECT id, name FROM user")
                .executeAndFetch(User::class.java)
        }

    fun findById(id: String): List<User> =
        DBConnectionManager.getConnection().open().use { conn ->
            conn.createQuery("SELECT id, name FROM user WHERE id = :id")
                .addParameter("id", id)
                .executeAndFetch(User::class.java)
        }
}
