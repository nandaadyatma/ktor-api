package com.nandaadyatma.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Frog(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
)
