package jth.com.thetrive.ui.views.collection

import androidx.fragment.app.activityViewModels
import jth.com.thetrive.ui.R
import jth.com.thetrive.ui.databinding.CollectionFragmentBinding
import jth.com.thetrive.ui.viewmodels.MainViewModel
import jth.com.thetrive.ui.views.base.BaseFragment

class CollectionFragment : BaseFragment<CollectionFragmentBinding>() {
    private val _viewModel: MainViewModel by activityViewModels()
    private val viewModel: MainViewModel
        get() = _viewModel

    override fun getLayoutResId(): Int = R.layout.collection_fragment

    override fun initializeViewModel() {
        binding?.viewModel = viewModel
        binding?.viewModel?.getCollectionCars()
    }
}