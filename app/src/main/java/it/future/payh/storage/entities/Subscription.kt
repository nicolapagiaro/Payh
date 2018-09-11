package it.future.payh.storage.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "subs")
data class Subscription(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "name") val name: String?,
        @ColumnInfo(name = "price") val price: String?) {

    constructor() : this(0, null, null)
}