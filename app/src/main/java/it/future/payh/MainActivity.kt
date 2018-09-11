package it.future.payh

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import it.future.payh.storage.entities.Subscription
import it.future.payh.view_models.SubscriptionsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var subsListAdapter : SubscriptionsListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup a custom ActionBar
        DecorationHelper.setupCustomActionBar(supportActionBar!!)

        // setting up recycler view
        rvSubs.layoutManager = LinearLayoutManager(applicationContext)

        // init the observe pattern on the list of subscriptions
        ViewModelProviders.of(this)
                .get(SubscriptionsViewModel::class.java)
                .getSubsData()?.observe(this, Observer<List<Subscription>> {
                    Log.d("Data", it!!.toString())

                    if(subsListAdapter == null) {
                        subsListAdapter =  SubscriptionsListAdapter(it!!, applicationContext)
                        rvSubs.adapter  = subsListAdapter
                    }
                    else {
                        subsListAdapter?.subs = it!!
                        subsListAdapter?.notifyDataSetChanged()
                    }
                })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                Toast.makeText(applicationContext, "Search#1 menu tapped", Toast.LENGTH_SHORT).show()
            }
            R.id.main_act_fav_menu -> {
                Toast.makeText(applicationContext, "Fav menu tapped", Toast.LENGTH_SHORT).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
