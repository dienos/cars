package jth.com.thetrive.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel : ViewModel() {
    private val progress = MutableStateFlow(false)
    val progressFlow
        get() = progress.asStateFlow()

    fun updateProgress(show: Boolean) {
        progress.value = show
    }
}