package it.future.payh.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import it.future.payh.storage.DatabaseContract

@Entity(tableName = DatabaseContract.categoryTableName)
data class Category(
        @PrimaryKey(autoGenerate = true) val id : Long?,
        @ColumnInfo(name = "name") val name : String?
)