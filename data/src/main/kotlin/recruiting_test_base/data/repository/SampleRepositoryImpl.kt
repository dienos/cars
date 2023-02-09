package recruiting_test_base.data.repository

import recruiting_test_base.data.datasource.local.SampleLocalSource
import recruiting_test_base.data.datasource.remote.SampleRemoteSource
import recruiting_test_base.data.model.SampleEntity
import recruiting_test_base.data.model.SampleDTO
import javax.inject.Inject

interface SampleRepository {
    suspend fun getLocalSample(): List<SampleEntity>
    suspend fun getSample(): List<SampleDTO>
}

class SampleRepositoryImpl @Inject constructor(
    private val localSource: SampleLocalSource,
    private val remoteSource: SampleRemoteSource
) : SampleRepository {
    override suspend fun getLocalSample(): List<SampleEntity> = localSource.getLocalSimple()
    override suspend fun getSample(): List<SampleDTO> = remoteSource.getSimple()
}