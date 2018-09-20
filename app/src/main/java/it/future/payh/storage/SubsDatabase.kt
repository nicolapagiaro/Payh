package it.future.payh.storage

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import it.future.payh.BuildConfig
import it.future.payh.storage.dao.SubscriptionsDao
import it.future.payh.storage.entities.Account
import it.future.payh.storage.entities.Category
import it.future.payh.storage.entities.Pricing
import it.future.payh.storage.entities.Subscription

/**
 * An abstract class that implements singleton guidelines to access to the subscriptions
 * database
 */
@Database(entities = [Subscription::class, Account::class, Category::class, Pricing::class],
        version = DatabaseContract.databaseVersion)
abstract class SubsDatabase : RoomDatabase() {

    abstract fun subscriptionsDao() : SubscriptionsDao

    companion object {
        private var INSTANCE: SubsDatabase? = null

        fun getInstance(context: Context): SubsDatabase? {
            if (INSTANCE == null) {
                synchronized(SubsDatabase::class) {
                    INSTANCE = if(BuildConfig.DEV) {
                        Room.inMemoryDatabaseBuilder(context.applicationContext, SubsDatabase::class.java)
                                .build()
                    }
                    else {
                        Room.databaseBuilder(context.applicationContext, SubsDatabase::class.java, DatabaseContract.databaseName)
                                .build()
                    }
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}