package jth.com.thetrive.ui.viewmodels

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import jth.com.thetrive.data.model.local.CarData
import jth.com.thetrive.domain.usecase.GetCollectionCarsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCollectionCarsUseCase: GetCollectionCarsUseCase,
) : BaseViewModel() {

    fun getCollectionCars() : Flow<PagingData<CarData>>  {
       return getCollectionCarsUseCase.invoke().cachedIn(viewModelScope)
    }
}