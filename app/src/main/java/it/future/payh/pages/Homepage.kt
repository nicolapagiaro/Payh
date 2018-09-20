package it.future.payh.pages

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import it.future.payh.R
import it.future.payh.storage.SubsDatabase
import it.future.payh.subsList.SubscriptionsItemDecoration
import it.future.payh.subsList.SubscriptionsListAdapter
import it.future.payh.storage.entities.Subscription
import it.future.payh.viewModels.SubscriptionsViewModel
import kotlinx.android.synthetic.main.home_frag.view.*

/**
 * Homepage fragment: list of subscriptions
 */
class Homepage : Fragment() {
    private lateinit var mDb : SubsDatabase
    private var mListAdapter: SubscriptionsListAdapter? = null

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

        // get database instance
        mDb = SubsDatabase.getInstance(context!!)!!

        // setting up recycler view
        view.rvSubs.layoutManager = LinearLayoutManager(context)
        view.rvSubs.addItemDecoration(SubscriptionsItemDecoration())

        // init the observe pattern on the list of subscriptions
        ViewModelProviders.of(this)
                .get(SubscriptionsViewModel::class.java)
                .getSubscriptionData(mDb)
                .observe(this, Observer<List<Subscription>> {
                    val subs = ArrayList<Subscription>().apply {
                        addAll(it!!)
                    }

                    if(mListAdapter == null) {
                        mListAdapter = SubscriptionsListAdapter(subs, context!!, object : SubscriptionsListAdapter.SubscriptionsBridge {

                            override fun onItemClick(obj : Subscription) {
                                Toast.makeText(context, "Item with id${obj.id} clicked", Toast.LENGTH_SHORT).show()
                            }
                        })
                        view.rvSubs.adapter  = mListAdapter
                    }
                    else {
                        mListAdapter?.updateDataSet(subs)
                    }
                })

        return view
    }
}