package com.effone.windeworldpractical.data.model

data class ResponseCode(
    val access_token: String,
    val expires_in: Int,
    val scope: String,
    val token_type: String
)