package it.future.payh.viewModels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import android.util.Log
import it.future.payh.storage.entities.Subscription

class SubscriptionsViewModel : ViewModel() {

    private var subsLiveData : MutableLiveData<ArrayList<Subscription>>? = null

    init {

        // lookup data from local db
        // ...

        subsLiveData = MutableLiveData()
        val fakeData = ArrayList<Subscription>().apply {
            add(Subscription(2, "Netflix", "13,99"))
            add(Subscription(3, "Spotify", "6,99"))
        }
        subsLiveData?.postValue(fakeData)

        Handler().postDelayed({
            fakeData.add(Subscription(4, "Tua madre in carrozza", "99999"))
            Log.d("Async completed", fakeData.toString())

            subsLiveData?.postValue(fakeData)
        }, 3000)
    }

    fun getSubsData(): LiveData<ArrayList<Subscription>>? = subsLiveData
}