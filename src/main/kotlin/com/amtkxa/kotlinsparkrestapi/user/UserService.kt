package com.amtkxa.kotlinsparkrestapi.user


class UserService {
    private val userRepository = UserRepository()

    fun findAll(): List<User> = userRepository.findAll()
    fun findById(id: Long): List<User> = userRepository.findById(id)
    fun create(id: Long, name: String) = userRepository.create(id, name)
    fun update(id: Long, name: String) = userRepository.update(id, name)
    fun delete(id: Long) = userRepository.delete(id)
}
