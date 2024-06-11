package com.home.web.controller

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

private val logger = KotlinLogging.logger {}

@Controller
@RequestMapping("", "/")
class MainController(
    @Value("\${spring.application.name}")
    private val appName: String,
) {
    @GetMapping("home")
    fun homePage(model: Model): String {
        logger.debug { "Invoke in homePage" }
        model.addAttribute("appName", appName)
        return "home"
    }
}