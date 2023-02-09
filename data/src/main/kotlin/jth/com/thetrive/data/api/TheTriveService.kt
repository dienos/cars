package jth.com.thetrive.data.api

import jth.com.thetrive.data.model.SampleDTO
import retrofit2.http.GET

interface TheTriveService {
    @GET("sample")
    suspend fun getSample() : List<SampleDTO>
}