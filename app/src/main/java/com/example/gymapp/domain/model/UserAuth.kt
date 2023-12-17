package com.example.gymapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthedUser(
    val id: String,
    val avatar: String,
    val name: String,
    val firstname: String,
    val lastname : String,
    val email: String,
)

@Serializable
data class SignInDto(
    val email : String,
    val password : String,
)

@Serializable
data class SignUpDto(
    val firstname: String,
    val lastname: String,
    val userName : String,
    val email : String,
    val password : String,
)


