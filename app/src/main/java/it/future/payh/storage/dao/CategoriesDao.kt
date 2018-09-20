package it.future.payh.storage.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import it.future.payh.storage.DatabaseContract
import it.future.payh.storage.entities.Category

@Dao
interface CategoriesDao {
    @Query("SELECT * from ${DatabaseContract.categoryTableName}")
    fun getAll(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)

    @Query("DELETE from ${DatabaseContract.categoryTableName}")
    fun deleteAll()
}