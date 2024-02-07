package com.nandaadyatma.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val error: Boolean?,
    val message: String?,
    val data: T,
)
