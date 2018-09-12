package it.future.payh

import android.util.Log
import it.future.payh.storage.entities.Subscription

class SubscriptionsDiffHelper (
        newList: List<Subscription>,
        oldList: List<Subscription>) {

    private val IGNOREDNUMBER = -1L
    private var changes : ArrayList<ItemChanged> = ArrayList()

    init {
        val newIds : MutableList<Long?> = newList.map {
            return@map it.id
        }.toMutableList()

        val oldIds = oldList.map {
            return@map it.id
        }.toList()


        // first seek for updated and removed elements
        oldIds.forEachIndexed { index, it ->
            val position = newIds.binarySearch(it, 0, newIds.size)
            if(position >= 0) {
                if(isItemUpdated(newList[position], oldList[index]))
                    changes.add(SubscriptionsDiffHelper.ItemChanged(position, ItemChanges.UPDATED))
                else
                    newIds[position] = IGNOREDNUMBER
            }
            else {
                changes.add(SubscriptionsDiffHelper.ItemChanged(position, ItemChanges.REMOVED))
            }
        }

        // second seek for added elements
        newIds.forEachIndexed { index, it ->
            if(it != IGNOREDNUMBER)
                changes.add(SubscriptionsDiffHelper.ItemChanged(index, ItemChanges.INSERTED))
        }
    }

    private fun isItemUpdated(newIem : Subscription, oldItem : Subscription) : Boolean {
        return false
    }

    fun updateRecyclerview(adapter: SubscriptionsListAdapter) {
        changes.forEach {
            when(it.action) {
                ItemChanges.INSERTED -> adapter.notifyItemInserted(it.position)
                ItemChanges.REMOVED -> adapter.notifyItemRemoved(it.position)
                ItemChanges.UPDATED -> adapter.notifyItemChanged(it.position)
            }
        }
    }

    enum class ItemChanges {
        REMOVED,
        INSERTED,
        UPDATED
    }

    data class ItemChanged(
            var position : Int,
            var action : ItemChanges
    )
}