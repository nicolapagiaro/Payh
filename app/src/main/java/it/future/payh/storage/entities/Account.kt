package it.future.payh.storage.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.ForeignKey.SET_NULL
import android.arch.persistence.room.PrimaryKey
import it.future.payh.storage.DatabaseContract

@Entity(tableName = DatabaseContract.accountTableName, foreignKeys = [
    ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["idCategory"],
            onDelete = SET_NULL,
            onUpdate = CASCADE)
])
data class Account(
        @PrimaryKey(autoGenerate = true) val id : Long?,
        @ColumnInfo(name = "name") val name : String?,
        @ColumnInfo(name = "idCategory") val idCategory : Long?
)