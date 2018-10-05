package it.future.payh.storage.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import it.future.payh.storage.SubsDatabase
import it.future.payh.storage.dao.SubscriptionsDao
import it.future.payh.storage.entities.Subscription

class SubscriptionsRepository(application: Application) {
    lateinit var mSubscriptionsList : LiveData<List<Subscription>>
    lateinit var mSubscriptionDao : SubscriptionsDao

    init {
        val db : SubsDatabase? = SubsDatabase.getInstance(application)

        if(db != null) {
            mSubscriptionDao = db.subscriptionsDao()
            mSubscriptionsList = mSubscriptionDao.getAll()
        }
    }
}