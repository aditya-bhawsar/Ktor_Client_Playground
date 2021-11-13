package com.aditya.ktorclientplayground.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)
