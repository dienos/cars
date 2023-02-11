package jth.com.thetrive.ui.views.collection

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["car_image"])
fun setImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context).load(it).into(view)
    }
}

