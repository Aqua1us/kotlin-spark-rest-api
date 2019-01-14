package com.amtkxa.kotlinsparkrestapi.domain.repository

import com.amtkxa.kotlinsparkrestapi.domain.model.User

interface UserRepository {
    fun findAll(): List<User>
    fun findById(id: Long): List<User>
    fun create(id: Long, name: String): Long
    fun update(id: Long, name: String): Long
    fun delete(id: Long): Long
}
