package it.future.payh.view_models

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import it.future.payh.storage.entities.Subscription

class SubscriptionsViewModel : ViewModel() {

    private var subsLiveData : LiveData<List<Subscription>>? = null

    init {

        // lookup data from local db
        // ...

        var tempList = MutableLiveData<List<Subscription>>()
        val fakeData = ArrayList<Subscription>().apply {
            add(Subscription(2, "Netflix", "13,99"))
            add(Subscription(3, "Spotify", "6,99"))
        }
        tempList.postValue(fakeData)
        subsLiveData = tempList
    }

    fun getSubsData(): LiveData<List<Subscription>>? = subsLiveData
}