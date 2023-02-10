package jth.com.thetrive.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jth.com.thetrive.domain.model.CarData
import kotlinx.coroutines.launch
import jth.com.thetrive.domain.usecase.GetCollectionCarsUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCollectionCarsUseCase: GetCollectionCarsUseCase,
) : BaseViewModel() {

    private var _collectionCarData = MutableLiveData<List<CarData>>()
    val collectionCarData: LiveData<List<CarData>> = _collectionCarData

    fun getCollectionCars() {
        viewModelScope.launch {
            getCollectionCarsUseCase(
                scope = viewModelScope,
                { result ->
                    _collectionCarData.value = result
                },
                { msg ->
                })
        }
    }
}