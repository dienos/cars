package jth.com.thetrive.domain.model

data class Error(
    val responseCode: String,
    val exception: Exception
)