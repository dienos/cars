package jth.com.thetrive.data.model

import com.google.gson.annotations.SerializedName

data class BodyTypeDTO(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?
)