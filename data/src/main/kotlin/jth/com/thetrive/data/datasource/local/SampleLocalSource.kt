package jth.com.thetrive.data.datasource.local

import jth.com.thetrive.data.db.dao.SampleDao
import jth.com.thetrive.data.model.SampleEntity
import javax.inject.Inject

interface SampleLocalSource {
    suspend fun getLocalSimple(): List<SampleEntity>
}

class SampleLocalSourceImpl @Inject constructor(
    private val dao: SampleDao
) : SampleLocalSource {
    override suspend fun getLocalSimple(): List<SampleEntity> = dao.getSamples()
}