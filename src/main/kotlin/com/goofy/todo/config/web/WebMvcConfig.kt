package com.goofy.todo.config.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.nio.charset.StandardCharsets

val MEDIA_TYPE_APPLICATION_JSON_UTF8 = MediaType("application", "json", StandardCharsets.UTF_8)
const val MEDIA_TYPE_APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8"

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    @Bean
    fun corsFilter(): CorsFilter? {
        val source = UrlBasedCorsConfigurationSource()

        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOrigin(CorsConfiguration.ALL)
        config.addAllowedHeader(CorsConfiguration.ALL)
        config.addAllowedMethod(CorsConfiguration.ALL)
        config.maxAge = 3600
        source.registerCorsConfiguration("/**", config)

        return CorsFilter(source)
    }
}
