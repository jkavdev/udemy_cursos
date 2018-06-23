package br.com.jkavdev.springintro

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorld {

    @RequestMapping("/")
    String home() {
        "Massa, ta funcionando..........."
    }

}