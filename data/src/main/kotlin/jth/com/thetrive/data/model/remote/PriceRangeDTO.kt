package jth.com.thetrive.data.model.remote

import com.google.gson.annotations.SerializedName

data class PriceRangeDTO(
    @SerializedName("min")
    val min: Long?,

    @SerializedName("max")
    val max: Long?
)