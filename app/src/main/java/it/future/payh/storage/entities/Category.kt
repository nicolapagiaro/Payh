package it.future.payh.storage.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
        @PrimaryKey(autoGenerate = true) val id : Long?,
        @ColumnInfo(name = "name") val name : String?
)