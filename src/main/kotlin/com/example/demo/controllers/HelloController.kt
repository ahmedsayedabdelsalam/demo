package com.example.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.example.demo.entities.UserEntity
import com.example.demo.services.UserService
import com.example.demo.enums.UserStatusEnum

@RestController
class HelloController(
  private val userService: UserService
) {

  @GetMapping
  fun test(): String {
    // seeding
    userService.createUser(UserEntity(name = "ahmed", status = UserStatusEnum.INACTIVE))
    userService.createUser(UserEntity(name = "sayed", status = UserStatusEnum.INACTIVE))
    val user = userService.createUser(UserEntity(name = "John Doe"))

    // queries
    val countOfActiveUsersJohn = userService.countActiveUsersWithName("john")
    val countOfNotActiveUsers = userService.countNotActiveUsers()

    // test
    return "Hello World ${user.name}, count of active users: $countOfActiveUsersJohn, count of not active users: $countOfNotActiveUsers"
  }
}
