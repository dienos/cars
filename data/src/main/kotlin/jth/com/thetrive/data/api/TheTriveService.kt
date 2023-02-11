package jth.com.thetrive.data.api

import jth.com.thetrive.data.model.remote.CarDataDTO
import jth.com.thetrive.data.model.remote.CarListFilterDataDTO
import jth.com.thetrive.data.model.remote.CommonDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface TheTriveService {
    @GET("collection/cars/")
    suspend fun getCollectionCars(
        @Query("cursor") cursor: Int? = null,
        @Query("take") take: Int = 10
    ): CommonDTO<List<CarDataDTO>>

    @GET("carlistfilter")
    suspend fun getCarListFilter(): CommonDTO<CarListFilterDataDTO>
}