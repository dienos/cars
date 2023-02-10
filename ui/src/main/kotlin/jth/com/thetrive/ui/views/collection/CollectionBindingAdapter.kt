package jth.com.thetrive.ui.views.collection

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jth.com.thetrive.domain.model.CarData
import jth.com.thetrive.ui.viewmodels.MainViewModel

@BindingAdapter(value = ["viewModel", "collections"])
fun setCollectionCars(
    view: RecyclerView,
    viewModel: MainViewModel,
    currentList: List<CarData>?
) {
    currentList?.let {
        view.adapter?.apply {
            val adapter = view.adapter as CollectionPagingAdapter
            val list = ArrayList<CarData>()
            list.addAll(currentList)
        } ?: run {
            val layoutManager =
                LinearLayoutManager(
                    view.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            view.layoutManager = layoutManager
            view.adapter = CollectionPagingAdapter(viewModel)
        }
    }
}
