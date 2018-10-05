package it.future.payh.subsList

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.future.payh.R
import it.future.payh.storage.entities.Subscription
import kotlinx.android.synthetic.main.subs_item_view.view.*

/**
 * Subscriptions adapter for the main activity recycler view
 */
class SubscriptionsListAdapter(
        private val context: Context,
        private val bridge: SubscriptionsBridge) : androidx.recyclerview.widget.RecyclerView.Adapter<SubscriptionsListAdapter.SubscriptionView>() {

    private var subs : List<Subscription> = ArrayList()

    /**
     * Function to change the data set with new data entry
     */
    fun updateDataSet(newSubs: List<Subscription>) {
        val diffResult = DiffUtil.calculateDiff(SubscriptionsDiffHelper(newSubs, this.subs))
        diffResult.dispatchUpdatesTo(this@SubscriptionsListAdapter)

        this.subs = newSubs
    }

    override fun onCreateViewHolder(view: ViewGroup, position: Int): SubscriptionView {
        return SubscriptionView(LayoutInflater.from(context).inflate(R.layout.subs_item_view, view, false))
    }

    override fun onBindViewHolder(view: SubscriptionView, position: Int) {
        view.display(subs[position])

        view.itemView.setOnClickListener {
            bridge.onItemClick(subs[position])
        }
    }

    override fun getItemCount(): Int = subs.size

    /**
     * Subscription item view holder
     */
    class SubscriptionView(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        /**
         * Function that prepare the data to be displayed in the view
         */
        fun display(sub: Subscription) {
            // custom border color of the item
            val bg = itemView.subsItemContainer.background as GradientDrawable
            bg.setStroke(4, Color.parseColor("#43A047"))

            // info of the subscription
            itemView.subsName.text = sub.id.toString()
        }
    }


    interface SubscriptionsBridge {
        fun onItemClick(obj : Subscription)
    }
}

