package it.future.payh.storage

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import it.future.payh.BuildConfig
import it.future.payh.storage.dao.SubscriptionsDao
import it.future.payh.storage.entities.Subscription

/**
 * An abstract class that implements singleton guidelines to access to the subscriptions
 * database
 */
@Database(entities = [(Subscription::class)], version = 1)
abstract class SubsDatabase : RoomDatabase() {

    abstract fun subscriptionsDao() : SubscriptionsDao

    companion object {
        private const val FILE_NAME = "subs.db"
        private var INSTANCE: SubsDatabase? = null

        fun getInstance(context: Context): SubsDatabase? {
            if (INSTANCE == null) {
                synchronized(SubsDatabase::class) {
                    INSTANCE = if(BuildConfig.DEV) {
                        Room.inMemoryDatabaseBuilder(context.applicationContext, SubsDatabase::class.java)
                                .build()
                    }
                    else {
                        Room.databaseBuilder(context.applicationContext, SubsDatabase::class.java, FILE_NAME)
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