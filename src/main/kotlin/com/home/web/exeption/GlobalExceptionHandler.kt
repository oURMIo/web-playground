package com.home.web.exeption

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.resource.NoResourceFoundException

@ControllerAdvice
class GlobalExceptionHandler {
    private val logger = KotlinLogging.logger { GlobalExceptionHandler::class.java }

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleNoResourceFoundException(ex: Exception): ResponseEntity<String> {
        return ResponseEntity("This page is not serving", HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(ex: Exception): ResponseEntity<String> {
        logger.warn { "Got HttpMessageNotReadableException" }
        return ResponseEntity("Received invalid request", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException::class)
    fun handleHttpMediaTypeNotSupportedException(ex: Exception): ResponseEntity<String> {
        logger.warn { "Got HttpMediaTypeNotSupportedException" }
        return ResponseEntity("Received invalid request type", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(AppUserNotFoundException::class)
    fun handleAppUserNotFoundException(ex: Exception): ResponseEntity<String> {
        logger.warn { "Got AppUserNotFoundException" }
        return ResponseEntity("User not found", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(DatabaseException::class)
    fun handleDatabaseException(ex: Exception): ResponseEntity<String> {
        logger.error { "Got DatabaseException , $ex" }
        return ResponseEntity("Got issue with database", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleGlobalExceptions(ex: Exception): ResponseEntity<String> {
        logger.error { "Got undefined exception, $ex" }
        return ResponseEntity("Unexpectedly, but you broke everything", HttpStatus.INTERNAL_SERVER_ERROR)
    }
}