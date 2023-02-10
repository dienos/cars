package jth.com.thetrive.data.model

import com.google.gson.annotations.SerializedName

data class CommonDTO<T>(
    @SerializedName("statusCode")
    val code: Int? = null,

    @SerializedName("result")
    val result: T? = null,
)