package jth.com.thetrive.data.api

import jth.com.thetrive.data.model.SampleDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface TheTriveService {
    @GET("collection/cars/")
    suspend fun getCollectionCars(
        @Query("cursor") cursor: Int,
        @Query("take") take: Int = 10
    ): List<SampleDTO>

    @GET("carlistfilter")
    suspend fun getCarListFilter(): SampleDTO
}