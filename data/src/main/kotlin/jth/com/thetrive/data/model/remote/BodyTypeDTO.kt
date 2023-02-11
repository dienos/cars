package jth.com.thetrive.data.model.remote

import com.google.gson.annotations.SerializedName

data class BodyTypeDTO(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?
)