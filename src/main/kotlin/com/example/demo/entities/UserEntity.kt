package com.example.demo.entities

import jakarta.persistence.*;
import com.example.demo.enums.UserStatusEnum

@Entity
@Table(name = "users")
data class UserEntity(
  @Column(nullable = false)
  val name: String,

  @Enumerated(EnumType.STRING)
  val status: UserStatusEnum = UserStatusEnum.ACTIVE,
) : BaseEntity()
