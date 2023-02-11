package jth.com.thetrive.domain.usecase

import androidx.paging.PagingData
import jth.com.thetrive.data.model.local.CarData
import jth.com.thetrive.data.repository.CollectionRepository
import kotlinx.coroutines.flow.Flow

class GetCollectionCarsUseCase(private val repository: CollectionRepository) {
    operator fun invoke(
    ): Flow<PagingData<CarData>> {
        return repository.getCollectionCarsPaging(10)
    }
}