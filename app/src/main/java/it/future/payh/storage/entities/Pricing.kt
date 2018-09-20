package it.future.payh.storage.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import it.future.payh.storage.DatabaseContract

@Entity(tableName = DatabaseContract.pricingTableName, foreignKeys = [
    ForeignKey(
            entity = Account::class,
            parentColumns = ["id"],
            childColumns = ["idAccount"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE)
])
data class Pricing(
        @PrimaryKey(autoGenerate = true) val id : Long?,
        @ColumnInfo(name = "idAccount") val idAccount : Long?,
        @ColumnInfo(name = "type") val type : String?,
        @ColumnInfo(name = "price") var price : String?
)