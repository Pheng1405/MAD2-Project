package com.example.gymapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SignUpCredentials(
    val phone: String,
    val password: String,
)