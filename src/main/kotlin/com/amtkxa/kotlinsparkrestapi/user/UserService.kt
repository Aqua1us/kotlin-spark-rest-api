package com.amtkxa.kotlinsparkrestapi.user


class UserService {
    private val userRepository = UserRepository()

    /**
     * Retrieve all user.
     *
     * @return list of User
     */
    fun findAll(): List<User> = userRepository.findAll()

    /**
     * Retrieve a user with a userId.
     *
     * @return list of User
     */
    fun findById(id: Long): List<User> = userRepository.findById(id = id)

    /**
     * Create a user.
     *
     * @return userId
     */
    fun create(id: Long, name: String) = userRepository.create(id = id, name = name)

    /**
     * Update a user.
     *
     * @return userId
     */
    fun update(id: Long, name: String) = userRepository.update(id = id, name = name)

    /**
     * Delete a user.
     */
    fun delete(id: Long) = userRepository.delete(id = id)
}
