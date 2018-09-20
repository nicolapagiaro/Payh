package it.future.payh.storage.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import it.future.payh.storage.DatabaseContract
import it.future.payh.storage.entities.Account

@Dao
interface AccountsDao {
    @Query("SELECT * from ${DatabaseContract.accountTableName}")
    fun getAll(): LiveData<List<Account>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: Account)

    @Query("DELETE from ${DatabaseContract.accountTableName}")
    fun deleteAll()
}