package com.example.gymapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthedUser(
    val id: String,
    val avatar: String,
    val name: String,
    val firstname: String,
    val lastname : String,
    val phone: String,
)