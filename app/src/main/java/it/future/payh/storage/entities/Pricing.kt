package it.future.payh.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
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