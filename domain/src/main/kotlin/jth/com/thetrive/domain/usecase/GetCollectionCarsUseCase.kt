package jth.com.thetrive.domain.usecase

import jth.com.thetrive.data.repository.CollectionRepository
import jth.com.thetrive.domain.const.Status.RESULT_OK
import jth.com.thetrive.domain.mapper.asCarData
import jth.com.thetrive.domain.model.CarData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetCollectionCarsUseCase(private val repository: CollectionRepository) {
    operator fun invoke(
        scope: CoroutineScope,
        onResult: (List<CarData>) -> Unit = {},
        onFail: (String) -> Unit = {}
    ) {
        scope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result: MutableList<CarData> = mutableListOf()
                    val response = repository.getCollectionCars()

                    if(response.code == RESULT_OK) {
                        response.result?.forEach { item ->
                            result.add(item.asCarData())
                        }

                        onResult(result)
                    } else {
                        onFail("에러 발생")
                    }
                } catch (e: Exception) {
                    e.message?.let {
                        onFail(it)
                    }
                }
            }
        }
    }
}