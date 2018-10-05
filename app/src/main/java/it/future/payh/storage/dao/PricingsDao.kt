package it.future.payh.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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