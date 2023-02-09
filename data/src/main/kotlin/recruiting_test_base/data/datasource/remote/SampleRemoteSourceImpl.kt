package recruiting_test_base.data.datasource.remote

import recruiting_test_base.data.api.SampleService
import recruiting_test_base.data.model.SampleDTO
import javax.inject.Inject

interface SampleRemoteSource {
    suspend fun getSimple(): List<SampleDTO>
}

class SampleRemoteSourceImpl @Inject constructor(
    private val sampleService: SampleService
) : SampleRemoteSource {
    override suspend fun getSimple(): List<SampleDTO> = sampleService.getSample()
}