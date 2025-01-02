package com.example.demo.entities

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@MappedSuperclass
open class BaseEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  val createdAt: Instant? = null,

  @UpdateTimestamp
  @Column(nullable = false)
  val updatedAt: Instant? = null,
)
