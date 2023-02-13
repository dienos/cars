package jth.com.thetrive.domain.usecase

import jth.com.thetrive.data.const.Status
import jth.com.thetrive.data.model.remote.CarListFilterDataDTO
import jth.com.thetrive.data.repository.CollectionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetCollectionCarsFilterDataUseCase(private val repository: CollectionRepository) {
    operator fun invoke(
        scope: CoroutineScope,
        onResult: (CarListFilterDataDTO) -> Unit = {},
        onFail: (String) -> Unit = {}
    ) {
        scope.launch {
            withContext(Dispatchers.Main) {
                val response = repository.getCarListFilters()

               if(response.code == Status.RESULT_OK) {
                   response.result?.let {
                       onResult(it)
                   }
               } else {
                   onFail("에러 발생")
               }
            }
        }
    }
}