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

    fun create(id: Long, name: String) =
        DBConnectionManager.getConnection().open().use { conn ->
            conn.createQuery("INSERT INTO user (id, name) VALUES (:id, :name)")
                .addParameter("id", id)
                .addParameter("name", name)
                .executeUpdate()
            id
        }

    fun update(id: Long, name: String) =
        DBConnectionManager.getConnection().open().use { conn ->
            conn.createQuery("UPDATE user SET name = :name WHERE id = :id")
                .addParameter("id", id)
                .addParameter("name", name)
                .executeUpdate()
            id
        }

    fun delete(id: Long) =
        DBConnectionManager.getConnection().open().use { conn ->
            conn.createQuery("DELETE FROM user WHERE id = :id")
                .addParameter("id", id)
                .executeUpdate()
            id
        }
}
