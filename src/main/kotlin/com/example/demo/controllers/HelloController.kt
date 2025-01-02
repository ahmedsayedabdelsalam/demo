package com.example.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.example.demo.entities.UserEntity
import com.example.demo.services.UserService

@RestController
class HelloController(
  private val userService: UserService
) {

  @GetMapping
  fun test(): String {
    val user = userService.createUser(UserEntity(name = "John Doe"))
    return "Hello World ${user.name}"
  }
}
