package jth.com.thetrive.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import jth.com.thetrive.data.model.local.CarData
import jth.com.thetrive.data.model.local.CarFiltersResult
import jth.com.thetrive.domain.usecase.GetCollectionCarsFilterDataUseCase
import jth.com.thetrive.domain.usecase.MakeCollectionCarsFiltersResultUseCase
import jth.com.thetrive.domain.usecase.GetCollectionCarsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCollectionCarsUseCase: GetCollectionCarsUseCase,
    private val getCollectionCarsFilterUseCase: GetCollectionCarsFilterDataUseCase,
    private val makeCollectionCarsFiltersResultUseCase: MakeCollectionCarsFiltersResultUseCase
) : BaseViewModel() {
    private val filterResult = MutableLiveData<CarFiltersResult>()
    val filterResultLiveData: LiveData<CarFiltersResult>
        get() = filterResult

    fun getCollectionCars(): Flow<PagingData<CarData>> {
        return getCollectionCarsUseCase.invoke().cachedIn(viewModelScope)
    }

    fun getCollectionCarsFilter() {
        updateProgress(true)

        getCollectionCarsFilterUseCase(scope = viewModelScope, {
            filterResult.value = makeCollectionCarsFiltersResultUseCase.invoke(it)
            updateProgress(false)
        }, { msg ->
            updateProgress(false)
        })
    }

    fun showCarFilterSheet() {
        updateUi(UiEvent.SHOW_CAR_FILTER_BOTTOM_SHEET.ui)
    }
}