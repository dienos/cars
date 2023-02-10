package jth.com.thetrive.data.model

import com.google.gson.annotations.SerializedName

data class BrandDTO(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("logoUrl")
    val logoUrl: String?
)