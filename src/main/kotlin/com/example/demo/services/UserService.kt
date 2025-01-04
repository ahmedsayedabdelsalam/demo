package com.example.demo.services

import org.springframework.stereotype.Service
import com.example.demo.entities.UserEntity
import com.example.demo.repos.UserRepository
import com.example.demo.specs.UserSpecs
import com.example.demo.enums.UserStatusEnum

@Service
class UserService(
  private val userRepository: UserRepository
) {
  fun createUser(user: UserEntity): UserEntity {
    return userRepository.save(user)
  }

  // can chain scopes like query builder in rails or laravel
  fun countActiveUsersWithName(name: String): Long {
    return userRepository.count(
      UserSpecs.active().and(UserSpecs.hasName(name))
    )
  }

  // can pass custom scope
  fun countNotActiveUsers(): Long {
    return userRepository.count(UserSpecs.where {root, _, cb ->
      cb.equal(root.get<String>("status"), UserStatusEnum.INACTIVE)
    })
  }
}
