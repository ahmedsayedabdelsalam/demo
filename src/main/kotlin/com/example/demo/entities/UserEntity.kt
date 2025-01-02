package com.example.demo.entities

import jakarta.persistence.*;

@Entity
@Table(name = "users")
data class UserEntity(
  @Column(nullable = false)
  val name: String,

) : BaseEntity()
