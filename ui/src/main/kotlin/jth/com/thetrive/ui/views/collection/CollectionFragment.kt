package jth.com.thetrive.ui.views.collection

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import jth.com.thetrive.ui.R
import jth.com.thetrive.ui.databinding.CollectionFragmentBinding
import jth.com.thetrive.ui.extensions.close
import jth.com.thetrive.ui.extensions.show
import jth.com.thetrive.ui.viewmodels.BaseViewModel
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

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.progressFlow.collectLatest { needShow ->
                try {
                    if (needShow) {
                        activity?.supportFragmentManager?.let {
                            progress.show(it)
                        }
                    } else {
                        progress.close()
                    }

                }catch (e : Exception) {

                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiEventFlow.collectLatest {
                when(it) {
                    BaseViewModel.UiEvent.SHOW_CAR_FILTER_BOTTOM_SHEET.ui -> {
                        activity?.supportFragmentManager?.let {
                            manager ->
                            val sheet = CollectionCarFilterBottomSheet()
                            sheet.show(manager, sheet.tag)
                        }
                    }
                }

                viewModel.setDefaultUi()
            }
        }

        viewModel.getCollectionCarsFilter()
    }

    private fun setCollectionCars() {
        collectionListAdapter = CollectionPagingAdapter(viewModel)
        val layoutManager =
            LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )

        collectionListAdapter.addLoadStateListener {
            viewModel.updateProgress(it.source.append is LoadState.Loading)
        }

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding?.rvCollectionCarList?.layoutManager = layoutManager
        binding?.rvCollectionCarList?.adapter = collectionListAdapter
    }

    override fun initializeViewModel() {
        binding?.viewModel = viewModel
    }
}