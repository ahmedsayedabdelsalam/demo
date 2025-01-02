package com.example.demo.repos

import com.example.demo.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface UserRepository : JpaRepository<UserEntity, Long> {
  fun findByName(name: String): UserEntity?
}
