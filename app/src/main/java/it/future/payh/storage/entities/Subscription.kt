package it.future.payh.storage.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
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
        @ColumnInfo(name = "accountType") val accountType: String?,
        @ColumnInfo(name = "dateFirstBill") var dateFirstBill: String?,
        @ColumnInfo(name = "expireCount") var expireCount: Int?,
        @ColumnInfo(name = "expireType") var expireType: String?,
        @ColumnInfo(name = "dateAdded") val dateAdded: String?)