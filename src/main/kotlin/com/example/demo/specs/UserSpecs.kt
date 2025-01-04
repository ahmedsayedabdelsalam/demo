package com.example.demo.specs

import com.example.demo.entities.UserEntity
import com.example.demo.enums.UserStatusEnum
import org.springframework.data.jpa.domain.Specification

class UserSpecs {
  companion object {
    fun where(spec: Specification<UserEntity>): Specification<UserEntity> {
      return spec
    }

    fun active(): Specification<UserEntity> {
      return Specification { root, _, cb ->
        cb.equal(root.get<UserStatusEnum>("status"), UserStatusEnum.ACTIVE)
      }
    }

    fun hasName(name: String): Specification<UserEntity> {
      return Specification { root, _, cb -> 
        cb.like(root.get<String>("name"), "%$name%") 
      }
    }
  }
}
