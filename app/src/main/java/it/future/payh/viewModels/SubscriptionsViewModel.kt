package it.future.payh.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.AndroidViewModel
import it.future.payh.storage.entities.Subscription
import it.future.payh.storage.repositories.SubscriptionsRepository

class SubscriptionsViewModel(application: Application) : AndroidViewModel(application) {

    private var mRepository: SubscriptionsRepository = SubscriptionsRepository(application)
    var mSubscriptions: LiveData<List<Subscription>> = mRepository.mSubscriptionsList
}