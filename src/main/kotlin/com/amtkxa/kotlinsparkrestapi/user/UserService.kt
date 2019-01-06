package com.amtkxa.kotlinsparkrestapi.user


class UserService {
    private val userRepository = UserRepository()

    fun findAll(): List<User> = userRepository.findAll()
}
