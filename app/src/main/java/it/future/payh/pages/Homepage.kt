package it.future.payh.pages

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import it.future.payh.helpers.DebugLog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import it.future.payh.R
import it.future.payh.subsList.SubscriptionsItemDecoration
import it.future.payh.subsList.SubscriptionsListAdapter
import it.future.payh.storage.entities.Subscription
import it.future.payh.viewModels.SubscriptionsViewModel
import kotlinx.android.synthetic.main.home_frag.view.*

/**
 * Homepage fragment: list of subscriptions
 */
class Homepage : androidx.fragment.app.Fragment() {
    private lateinit var mListAdapter: SubscriptionsListAdapter
    private lateinit var subsViewmodel : SubscriptionsViewModel

    companion object {

        fun newInstance(): Homepage {
            return Homepage()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bridge = object : SubscriptionsListAdapter.SubscriptionsBridge {

            override fun onItemClick(obj: Subscription) {
                Toast.makeText(context, "Item with id${obj.id} clicked", Toast.LENGTH_SHORT).show()
            }
        }

        mListAdapter = SubscriptionsListAdapter(context!!, bridge)
        subsViewmodel = ViewModelProviders.of(this@Homepage).get(SubscriptionsViewModel::class.java)
    }


    /**
     * View created and show the list of subscriptions
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.home_frag, container, false)

        // setting up recycler view
        view.rvSubs.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        view.rvSubs.addItemDecoration(SubscriptionsItemDecoration())
        view.rvSubs.adapter = mListAdapter

        // init the observe pattern on the list of subscriptions
        subsViewmodel.mSubscriptions.observe(this@Homepage, Observer<List<Subscription>> {
           DebugLog.d("Update data set", it.toString())

            mListAdapter.updateDataSet(it)
        })

        return view
    }
}