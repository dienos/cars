package jth.com.thetrive.ui.views.collection

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import jth.com.thetrive.data.model.local.CarFilter
import jth.com.thetrive.ui.databinding.FilterItemBinding

class FilterListAdapter(
    var filterMap: HashMap<String, CarFilter>,
    val isFavorite: Boolean
) :
    RecyclerView.Adapter<FilterListAdapter.TagViewHolder>(
    ) {

    init {
        setHasStableIds(true)
    }

    inner class TagViewHolder(itemView: View, _bind: FilterItemBinding) :
        RecyclerView.ViewHolder(itemView) {
        private val bind = _bind

        fun bind(name: String, data: CarFilter?) {
            data?.let {
                bind.data = it
                bind.filterName = name
                bind.isFavorite = isFavorite
                bind.adapter = this@FilterListAdapter
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val bind = FilterItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TagViewHolder(bind.root, bind)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val key = filterMap.keys.toList()[position]
        holder.bind(key, filterMap[key])
    }

    override fun getItemCount(): Int = filterMap.size

    fun onFavoriteClick(view: View) {
        setLottie(view)
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
}
