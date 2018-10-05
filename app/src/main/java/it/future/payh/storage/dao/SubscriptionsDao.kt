package it.future.payh.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import it.future.payh.storage.entities.Subscription

@Dao
interface SubscriptionsDao {
    @Query("SELECT * from subs")
    fun getAll(): LiveData<List<Subscription>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(subscription: Subscription)

    @Query("DELETE from subs")
    fun deleteAll()
}