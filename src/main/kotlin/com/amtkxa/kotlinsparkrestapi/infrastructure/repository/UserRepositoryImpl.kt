package com.amtkxa.kotlinsparkrestapi.infrastructure.repository

import com.amtkxa.kotlinsparkrestapi.domain.model.User
import com.amtkxa.kotlinsparkrestapi.domain.repository.UserRepository
import com.amtkxa.kotlinsparkrestapi.infrastructure.database.DBConnectionManager


class UserRepositoryImpl : UserRepository {

    override fun findAll(): List<User> =
        DBConnectionManager.getSql2o().open().use { conn ->
            conn.createQuery("SELECT id, name FROM user")
                .executeAndFetch(User::class.java)
        }

    override fun findById(id: Long): List<User> =
        DBConnectionManager.getSql2o().open().use { conn ->
            conn.createQuery("SELECT id, name FROM user WHERE id = :id")
                .addParameter("id", id)
                .executeAndFetch(User::class.java)
        }

    override fun create(id: Long, name: String) =
        DBConnectionManager.getSql2o().open().use { conn ->
            conn.createQuery("INSERT INTO user (id, name) VALUES (:id, :name)")
                .addParameter("id", id)
                .addParameter("name", name)
                .executeUpdate()
            id
        }

    override fun update(id: Long, name: String) =
        DBConnectionManager.getSql2o().open().use { conn ->
            conn.createQuery("UPDATE user SET name = :name WHERE id = :id")
                .addParameter("id", id)
                .addParameter("name", name)
                .executeUpdate()
            id
        }

    override fun delete(id: Long) =
        DBConnectionManager.getSql2o().open().use { conn ->
            conn.createQuery("DELETE FROM user WHERE id = :id")
                .addParameter("id", id)
                .executeUpdate()
            id
        }
}
