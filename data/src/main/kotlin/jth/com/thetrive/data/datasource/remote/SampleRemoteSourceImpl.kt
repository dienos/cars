package jth.com.thetrive.data.datasource.remote

import jth.com.thetrive.data.api.TheTriveService
import jth.com.thetrive.data.model.SampleDTO
import javax.inject.Inject

interface SampleRemoteSource {
    suspend fun getSimple(): List<SampleDTO>
}

class SampleRemoteSourceImpl @Inject constructor(
    private val sampleService: TheTriveService
) : SampleRemoteSource {
    override suspend fun getSimple(): List<SampleDTO> = sampleService.getCollectionCars(3056)
}