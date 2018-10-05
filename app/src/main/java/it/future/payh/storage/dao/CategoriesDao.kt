package it.future.payh.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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