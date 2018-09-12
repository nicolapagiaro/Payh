package it.future.payh.pages

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.future.payh.R
import it.future.payh.SubscriptionsItemDecoration
import it.future.payh.SubscriptionsListAdapter
import it.future.payh.storage.entities.Subscription
import it.future.payh.viewModels.SubscriptionsViewModel
import kotlinx.android.synthetic.main.home_frag.*
import kotlinx.android.synthetic.main.home_frag.view.*

/**
 * Homepage fragment: list of subscriptions
 */
class Homepage : Fragment() {
    private var subsListAdapter : SubscriptionsListAdapter? = null

    companion object {

        fun newInstance(): Homepage {
            return Homepage()
        }
    }


    /**
     * View created and show the list of subscriptions
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.home_frag, container, false)

        // setting up recycler view
        view.rvSubs.layoutManager = LinearLayoutManager(context)
        view.rvSubs.addItemDecoration(SubscriptionsItemDecoration())

        // init the observe pattern on the list of subscriptions
        ViewModelProviders.of(this)
                .get(SubscriptionsViewModel::class.java)
                .getSubsData()?.observe(this, Observer<ArrayList<Subscription>> {

                    if(subsListAdapter == null) {
                        subsListAdapter =  SubscriptionsListAdapter(it, context!!)
                        view.rvSubs.adapter  = subsListAdapter
                    }
                    else {
                        subsListAdapter?.updateDataSet()
                    }
                })

        return view
    }
}