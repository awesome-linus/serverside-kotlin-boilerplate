package com.example.springboot.controller

import com.example.springboot.entity.User
import com.example.springboot.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/")
    fun showUsers(model: Model): MutableIterable<User> {
        return userRepository.findAll()
    }

    @PostMapping("/add")
    fun addNewUser(@RequestParam name: String): User {
        return userRepository.save(User(0, name))
    }
}