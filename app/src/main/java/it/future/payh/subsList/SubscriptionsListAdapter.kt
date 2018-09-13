package it.future.payh.subsList

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
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
        private var subs: ArrayList<Subscription>?,
        private val context: Context,
        private val bridge: SubscriptionsBridge) : RecyclerView.Adapter<SubscriptionsListAdapter.SubscriptionView>() {

    /**
     * Function to change the data set with new data entry
     */
    fun updateDataSet(newSubs: ArrayList<Subscription>?) {
        val diffResult = DiffUtil.calculateDiff(SubscriptionsDiffHelper(newSubs!!, this.subs!!))
        diffResult.dispatchUpdatesTo(this@SubscriptionsListAdapter)

        this.subs = newSubs
    }

    override fun onCreateViewHolder(view: ViewGroup, position: Int): SubscriptionView {
        return SubscriptionView(LayoutInflater.from(context).inflate(R.layout.subs_item_view, view, false))
    }

    override fun onBindViewHolder(view: SubscriptionView, position: Int) {
        view.display(subs!![position])

        view.itemView.setOnClickListener {
            bridge.onItemClick(subs!![position])
        }
    }

    override fun getItemCount(): Int = subs!!.size

    /**
     * Item view holder
     */
    class SubscriptionView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun display(sub: Subscription) {
            // custom border color of the item
            val bg = itemView.subsItemContainer.background as GradientDrawable
            bg.setStroke(4, Color.parseColor("#43A047"))

            // info of the subscription
            itemView.subsName.text = sub.name
        }
    }

    interface SubscriptionsBridge {
        fun onItemClick(obj : Subscription)
    }
}

