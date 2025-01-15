package com.example.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.ModelAttribute
import org.slf4j.LoggerFactory
import com.example.demo.entities.UserEntity
import com.example.demo.services.UserService
import com.example.demo.enums.UserStatusEnum
import com.example.demo.request_dtos.UserRequest
import jakarta.validation.Valid

@RestController
class HelloController(
  private val userService: UserService
) {
  val log = LoggerFactory.getLogger(HelloController::class.java)

  @GetMapping
  fun test(@Valid @ModelAttribute userRequest: UserRequest): Map<String, Any> {
    log.info("User request: $userRequest")

    val validatedUser = userService.createUser(userRequest.toEntity())

    return mapOf(
      "validatedUser" to validatedUser,
    )
  }
}
