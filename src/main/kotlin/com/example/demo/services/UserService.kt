package com.example.demo.services

import org.springframework.stereotype.Service
import com.example.demo.entities.UserEntity
import com.example.demo.repos.UserRepository

@Service
class UserService(
  private val userRepository: UserRepository
) {
  fun createUser(user: UserEntity): UserEntity {
    return userRepository.save(user)
  }
}
