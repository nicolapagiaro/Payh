package it.future.payh.subsList

import androidx.recyclerview.widget.DiffUtil
import android.util.Log
import it.future.payh.helpers.DebugLog
import it.future.payh.storage.entities.Subscription

class SubscriptionsDiffHelper (
        var newList: List<Subscription>,
        var oldList: List<Subscription>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return  newList[newPosition].id == oldList[oldPosition].id
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return  newList[newPosition].description == oldList[oldPosition].description
    }
}