package jth.com.thetrive.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import jth.com.thetrive.domain.model.LocalSample
import jth.com.thetrive.domain.model.Sample
import jth.com.thetrive.domain.usecase.GetSampleUseCase
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val getSampleUseCase: GetSampleUseCase,
) : BaseViewModel() {

    private var _sampleData = MutableLiveData<List<Sample>>()
    val sampleRepository : LiveData<List<Sample>> = _sampleData

    private var _sampleLocalData = MutableLiveData<List<LocalSample>>()
    val sampleLocalRepository : LiveData<List<LocalSample>> = _sampleLocalData

    fun getSimpleData() {
        viewModelScope.launch {
            _sampleData.value = getSampleUseCase.invoke()
        }
    }
}