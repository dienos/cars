package jth.com.thetrive.ui.views.collection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jth.com.thetrive.domain.model.CarData
import jth.com.thetrive.ui.databinding.CollectionItemBinding
import jth.com.thetrive.ui.viewmodels.MainViewModel

class CollectionPagingAdapter(private val viewModel: MainViewModel) :
    PagingDataAdapter<CarData, CollectionPagingAdapter.ViewHolder>(DiffCallback) {

    init {
        setHasStableIds(true)
    }

    inner class ViewHolder(_itemView: View, _bind: CollectionItemBinding) :
        RecyclerView.ViewHolder(_itemView) {
        val bind: CollectionItemBinding = _bind

        fun bind(item: CarData?) {
            bind.item = item
            bind.viewModel = viewModel
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
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

    object DiffCallback : DiffUtil.ItemCallback<CarData>() {
        override fun areItemsTheSame(oldItem: CarData, newItem: CarData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CarData, newItem: CarData): Boolean {
            return oldItem.id == newItem.id
        }
    }
}