package it.future.payh.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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