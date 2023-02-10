package jth.com.thetrive.domain.model

data class CommonResponse<T>(
    val statusCode: Int?,
    val result: T?,
    val error : Error?,
)