package com.example.demo.entities

import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

@RestControllerAdvice
class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException::class)
  fun handleValidationExceptions(e: MethodArgumentNotValidException): ResponseEntity<Map<String, Map<String, String?>>> {
    val errors = e.bindingResult.fieldErrors.sortedBy { it.field }.map {
      mapOf(it.field to it.defaultMessage)
    }.flatMap { it.entries }.associate { it.toPair() }

    return ResponseEntity(mapOf("errors" to errors), HttpStatus.BAD_REQUEST)
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException::class)
  fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<String> {
      return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
  }
}
