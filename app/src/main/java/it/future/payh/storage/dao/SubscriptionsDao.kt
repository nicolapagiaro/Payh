package it.future.payh.storage.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import it.future.payh.storage.entities.Subscription

@Dao
interface SubscriptionsDao {
    @Query("SELECT * from subs")
    fun getAll(): List<Subscription>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(subscription: Subscription)

    @Query("DELETE from subs")
    fun deleteAll()
}