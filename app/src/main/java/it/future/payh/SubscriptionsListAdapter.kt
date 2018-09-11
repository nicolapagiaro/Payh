package it.future.payh

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.future.payh.storage.entities.Subscription
import kotlinx.android.synthetic.main.subs_item_view.view.*

/**
 * Subscriptions adapter for the main activity recycler view
 */
class SubscriptionsListAdapter(var subs: List<Subscription>, private val context: Context) : RecyclerView.Adapter<SubscriptionsListAdapter.SubscriptionView>() {

    override fun onCreateViewHolder(view: ViewGroup, position: Int): SubscriptionView {
        return SubscriptionView(LayoutInflater.from(context).inflate(R.layout.subs_item_view, view, false))
    }

    override fun onBindViewHolder(view: SubscriptionView, position: Int) {
        view.bind(subs[position])
    }

    override fun getItemCount(): Int = subs.size

    /**
     * Item view holder
     */
    class SubscriptionView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(sub: Subscription) {
            itemView.subsTitle.text = sub.name
        }
    }
}

