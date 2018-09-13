package it.future.payh.subsList

import android.support.v7.util.DiffUtil
import android.util.Log
import it.future.payh.storage.entities.Subscription

class SubscriptionsDiffHelper (
        var newList: List<Subscription>,
        var oldList: List<Subscription>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return newList[newPosition].id == oldList[oldPosition].id
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return newList[newPosition].name == oldList[oldPosition].name
    }
}