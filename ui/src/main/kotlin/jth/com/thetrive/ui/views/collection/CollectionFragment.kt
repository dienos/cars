package jth.com.thetrive.ui.views.collection

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import jth.com.thetrive.ui.R
import jth.com.thetrive.ui.databinding.CollectionFragmentBinding
import jth.com.thetrive.ui.viewmodels.MainViewModel
import jth.com.thetrive.ui.views.base.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CollectionFragment : BaseFragment<CollectionFragmentBinding>() {
    lateinit var collectionListAdapter : CollectionPagingAdapter

    private val _viewModel: MainViewModel by activityViewModels()
    private val viewModel: MainViewModel
        get() = _viewModel

    override fun getLayoutResId(): Int = R.layout.collection_fragment

    override fun initializeUi() {
        setCollectionCars()
    }

    override fun initializeUiEvent() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getCollectionCars().collectLatest {
                collectionListAdapter.submitData(it)
            }
        }
    }

    private fun setCollectionCars() {
        collectionListAdapter = CollectionPagingAdapter(viewModel)
        val layoutManager =
            LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding?.collectionCarList?.layoutManager = layoutManager
        binding?.collectionCarList?.adapter = collectionListAdapter
    }
}