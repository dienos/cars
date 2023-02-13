package jth.com.thetrive.ui.views.collection

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import jth.com.thetrive.data.model.local.CarData
import jth.com.thetrive.ui.databinding.CollectionItemBinding
import jth.com.thetrive.ui.viewmodels.MainViewModel

class CollectionPagingAdapter(private val viewModel: MainViewModel) :
    PagingDataAdapter<CarData, CollectionPagingAdapter.ViewHolder>(DiffCallback) {

    inner class ViewHolder(_itemView: View, _bind: CollectionItemBinding) :
        RecyclerView.ViewHolder(_itemView) {
        private val bind: CollectionItemBinding = _bind

        fun bind(item: CarData?) {
            bind.item = item
            bind.viewModel = viewModel
            bind.adapter = this@CollectionPagingAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind = CollectionItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(bind.root, bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    object DiffCallback : DiffUtil.ItemCallback<CarData>() {
        override fun areItemsTheSame(oldItem: CarData, newItem: CarData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CarData, newItem: CarData): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private fun setLottie(view: View) {
        val process = (view as LottieAnimationView).progress

        if (process == 0f) {
            val animator = ValueAnimator.ofFloat(0f, 1f).setDuration(500)
            animator.addUpdateListener { animation: ValueAnimator ->
                view.progress = animation.animatedValue as Float
            }
            animator.start()
        } else {
            val animator = ValueAnimator.ofFloat(1f, 0f).setDuration(500)

            animator.addUpdateListener { animation: ValueAnimator ->
                view.progress = animation.animatedValue as Float
            }
            animator.start()
        }
    }

    fun onFavoriteClick(view: View) {
        setLottie(view)
    }
}