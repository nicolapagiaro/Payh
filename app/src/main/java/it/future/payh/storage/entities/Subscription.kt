package it.future.payh.storage.entities

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import it.future.payh.storage.DatabaseContract

@Entity(tableName = DatabaseContract.subscriptionTableName, foreignKeys = [
    ForeignKey(
            entity = Account::class,
            parentColumns = ["id"],
            childColumns = ["idAccount"],
            onDelete = ForeignKey.SET_NULL,
            onUpdate = ForeignKey.CASCADE),
    ForeignKey(
            entity = Pricing::class,
            parentColumns = ["id"],
            childColumns = ["idPricing"],
            onDelete = ForeignKey.SET_NULL,
            onUpdate = ForeignKey.CASCADE)
])
data class Subscription(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @ColumnInfo(name = "idAccount") val idAccount : Long?,
        @ColumnInfo(name = "idPricing") val idPricing : Long?,
        @ColumnInfo(name = "description") var description: String?,
        @ColumnInfo(name = "dateFirstBill") var dateFirstBill: String?,
        @ColumnInfo(name = "expireCount") var expireCount: Int?,
        @ColumnInfo(name = "expireType") var expireType: String?,
        @ColumnInfo(name = "dateAdded") val dateAdded: String?)