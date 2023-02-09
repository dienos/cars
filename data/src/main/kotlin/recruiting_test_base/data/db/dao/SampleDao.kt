package recruiting_test_base.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import recruiting_test_base.data.model.SampleEntity

@Dao
interface SampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: SampleEntity)

    @Query("SELECT * FROM sample")
    suspend fun getSamples(): List<SampleEntity>
}