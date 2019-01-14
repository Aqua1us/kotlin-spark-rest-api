package com.amtkxa.kotlinsparkrestapi.domain.service

import com.amtkxa.kotlinsparkrestapi.domain.model.User
import com.amtkxa.kotlinsparkrestapi.domain.repository.UserRepository

interface UserService {
    val userRepository: UserRepository

    /**
     * Retrieve all user.
     *
     * @return list of User
     */
    fun findAll(): List<User>

    /**
     * Retrieve a user with a userId.
     *
     * @return list of User
     */
    fun findById(id: Long): List<User>

    /**
     * Create a user.
     *
     * @return userId
     */
    fun create(id: Long, name: String): Long

    /**
     * Update a user.
     *
     * @return userId
     */
    fun update(id: Long, name: String): Long

    /**
     * Delete a user.
     */
    fun delete(id: Long): Long
}
