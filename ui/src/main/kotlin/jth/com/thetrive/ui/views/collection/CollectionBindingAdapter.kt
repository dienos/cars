package jth.com.thetrive.ui.views.collection

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import jth.com.thetrive.data.model.local.CarFiltersResult
import jth.com.thetrive.ui.viewmodels.MainViewModel

@BindingAdapter(value = ["car_image"])
fun setImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context).load(it).into(view)
    }
}

@BindingAdapter(value = ["car_filter"])
fun setFilters(
    view: RecyclerView,
    data: CarFiltersResult?
) {
    data?.let {
        val layoutManager =
            LinearLayoutManager(
                view.context,
                LinearLayoutManager.VERTICAL,
                false
            )
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        view.layoutManager = layoutManager
        view.adapter = FilterListAdapter(data.filterMap, data.favoritesOnly)
    }
}

