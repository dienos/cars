package jth.com.thetrive.ui.views

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jth.com.thetrive.ui.R
import jth.com.thetrive.ui.databinding.MainActivityBinding
import jth.com.thetrive.ui.viewmodels.SampleViewModel

@AndroidEntryPoint
class SampleActivity : BaseActivity<MainActivityBinding>() {
    private val _viewModel: SampleViewModel by viewModels()
    private val viewModel: SampleViewModel
        get() = _viewModel

    override fun getLayoutResId(): Int = R.layout.main_activity

    override fun initializeViewModel() {
        binding?.lifecycleOwner = this
        viewModel.getSimpleData()
    }

    override fun initializeUiEvent() {

    }

}