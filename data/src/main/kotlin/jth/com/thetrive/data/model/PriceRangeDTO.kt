package jth.com.thetrive.data.model

import com.google.gson.annotations.SerializedName

data class PriceRangeDTO(
    @SerializedName("min")
    val min: Long?,

    @SerializedName("max")
    val max: Long?
)