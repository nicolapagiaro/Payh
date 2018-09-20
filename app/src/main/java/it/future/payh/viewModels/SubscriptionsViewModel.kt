package it.future.payh.viewModels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import android.util.Log
import it.future.payh.storage.DbWorkerThread
import it.future.payh.storage.SubsDatabase
import it.future.payh.storage.entities.Subscription

class SubscriptionsViewModel : ViewModel() {

    private lateinit var subsLiveData : LiveData<List<Subscription>>

    fun getSubscriptionData(db : SubsDatabase) : LiveData<List<Subscription>> {
        subsLiveData = db.subscriptionsDao().getAll()

        // some fake data

        return subsLiveData
    }
}