package it.future.payh.storage.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import it.future.payh.storage.DatabaseContract
import it.future.payh.storage.entities.Pricing

@Dao
interface PricingsDao {
    @Query("SELECT * from ${DatabaseContract.pricingTableName}")
    fun getAll(): LiveData<List<Pricing>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pricing: Pricing)

    @Query("DELETE from ${DatabaseContract.pricingTableName}")
    fun deleteAll()
}