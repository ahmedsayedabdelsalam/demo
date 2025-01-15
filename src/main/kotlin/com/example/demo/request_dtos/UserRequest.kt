package com.example.demo.request_dtos

import com.example.demo.entities.UserEntity
import jakarta.validation.constraints.*

data class UserRequest(
  @field:NotBlank
  val name: String?,
  @field:Email
  val email: String?
) {
  fun toEntity() = UserEntity(name = name!!, email = email!!)
}
