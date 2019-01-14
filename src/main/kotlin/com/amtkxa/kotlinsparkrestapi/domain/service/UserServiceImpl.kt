package com.amtkxa.kotlinsparkrestapi.domain.service

import com.amtkxa.kotlinsparkrestapi.domain.model.User
import com.amtkxa.kotlinsparkrestapi.infrastructure.repository.UserRepositoryImpl


class UserServiceImpl : UserService {
    override val userRepository = UserRepositoryImpl()

    /**
     * {@inheritDoc}
     */
    override fun findAll(): List<User> = userRepository.findAll()

    /**
     * {@inheritDoc}
     */
    override fun findById(id: Long): List<User> = userRepository.findById(id = id)

    /**
     * {@inheritDoc}
     */
    override fun create(id: Long, name: String) = userRepository.create(id = id, name = name)

    /**
     * {@inheritDoc}
     */
    override fun update(id: Long, name: String) = userRepository.update(id = id, name = name)

    /**
     * {@inheritDoc}
     */
    override fun delete(id: Long) = userRepository.delete(id = id)
}
