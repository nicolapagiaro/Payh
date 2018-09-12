package it.future.payh

import android.support.annotation.Nullable
import android.support.v7.util.DiffUtil
import it.future.payh.storage.entities.Subscription

class SubscriptionsDiffUtil(
        var newList: List<Subscription>,
        var oldList: List<Subscription>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if(oldList[oldItemPosition].id != null && newList[newItemPosition].id != null)
            oldList[oldItemPosition].id!! == newList[newItemPosition].id
        else
            false
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if (oldList[oldItemPosition].name != null && newList[newItemPosition].name != null)
            oldList[oldItemPosition].name!! == newList[newItemPosition].name
        else
            false
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}