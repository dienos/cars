package jth.com.thetrive.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel : ViewModel() {
    enum class UiEvent(val ui: String) {
        SHOW_CAR_FILTER_BOTTOM_SHEET("show_car_filter_bottom_sheet")
    }

    private val toast = MutableStateFlow("")
    val toastFlow
        get() = toast.asStateFlow()

    private val progress = MutableStateFlow(false)
    val progressFlow
        get() = progress.asStateFlow()

    private val uiEvent = MutableStateFlow("")
    val uiEventFlow
        get() = uiEvent.asStateFlow()

    fun updateProgress(show: Boolean) {
        progress.value = show
    }

    fun updateUi(ui: String) {
        uiEvent.value = ui
    }

    fun setDefaultUi() {
        uiEvent.value = ""
    }

    fun updateToast(text: String) {
        toast.value = text
    }
}