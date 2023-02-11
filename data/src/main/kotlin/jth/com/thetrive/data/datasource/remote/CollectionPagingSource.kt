package jth.com.thetrive.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import jth.com.thetrive.data.api.TheTriveService
import jth.com.thetrive.data.const.Status.RESULT_OK
import jth.com.thetrive.data.mapper.asCarData
import jth.com.thetrive.data.model.local.CarData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CollectionPagingSource @Inject constructor(
    private val service: TheTriveService,
) : PagingSource<Int, CarData>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CarData> {
        return try {
            val key = params.key
            val result: MutableList<CarData> = mutableListOf()

            val response = withContext(Dispatchers.IO) {
                service.getCollectionCars(key)
            }

            if(response.code == RESULT_OK) {
                response.result?.forEach { remoteData ->
                    result.add(remoteData.asCarData())
                }

                val nextKey = result[result.size.minus(1)].id

                LoadResult.Page(
                    data = result,
                    prevKey = key,
                    nextKey = nextKey
                )
            } else {
                LoadResult.Error(Exception())
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CarData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}