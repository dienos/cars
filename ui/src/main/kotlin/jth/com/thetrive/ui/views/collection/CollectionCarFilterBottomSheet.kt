package jth.com.thetrive.ui.views.collection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import jth.com.thetrive.ui.R
import jth.com.thetrive.ui.databinding.CollectionCarFilterBottomSheetBinding
import jth.com.thetrive.ui.viewmodels.MainViewModel
import kotlinx.coroutines.launch

class CollectionCarFilterBottomSheet : BottomSheetDialogFragment() {
    var binding: CollectionCarFilterBottomSheetBinding? = null
        private set

    private val _viewModel: MainViewModel by activityViewModels()
    private val viewModel: MainViewModel
        get() = _viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(
            STYLE_NORMAL,
            R.style.TransparentBottomSheetDialogFragment
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.collection_car_filter_bottom_sheet,
            container,
            false
        )
        binding?.data = viewModel.filterResultLiveData.value

        return binding?.root
    }
}