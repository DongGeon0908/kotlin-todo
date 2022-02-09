package com.bunjang.todo.app.web.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SwaggerController {

    @GetMapping("/swagger")
    fun swagger() = "redirect:/swagger-ui.html"
}