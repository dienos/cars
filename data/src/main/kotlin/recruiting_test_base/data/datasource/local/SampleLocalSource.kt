package recruiting_test_base.data.datasource.local

import recruiting_test_base.data.db.dao.SampleDao
import recruiting_test_base.data.model.SampleEntity
import javax.inject.Inject

interface SampleLocalSource {
    suspend fun getLocalSimple(): List<SampleEntity>
}

class SampleLocalSourceImpl @Inject constructor(
    private val dao: SampleDao
) : SampleLocalSource {
    override suspend fun getLocalSimple(): List<SampleEntity> = dao.getSamples()
}