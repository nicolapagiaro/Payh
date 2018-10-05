package it.future.payh.storage

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import android.os.HandlerThread
import android.util.Log
import androidx.sqlite.db.SupportSQLiteDatabase
import it.future.payh.BuildConfig
import it.future.payh.storage.dao.AccountsDao
import it.future.payh.storage.dao.CategoriesDao
import it.future.payh.storage.dao.PricingsDao
import it.future.payh.storage.dao.SubscriptionsDao
import it.future.payh.storage.entities.Account
import it.future.payh.storage.entities.Category
import it.future.payh.storage.entities.Pricing
import it.future.payh.storage.entities.Subscription
import java.util.concurrent.Executors
import java.util.logging.Handler

/**
 * An abstract class that implements singleton guidelines to access to the subscriptions
 * database
 */
@Database(entities = [Subscription::class, Account::class, Category::class, Pricing::class],
        version = DatabaseContract.databaseVersion)
abstract class SubsDatabase : RoomDatabase() {

    abstract fun subscriptionsDao() : SubscriptionsDao
    abstract fun accountsDao() : AccountsDao
    abstract fun pricingsDao() : PricingsDao
    abstract fun categoryDao() : CategoriesDao

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

                    Executors.newSingleThreadExecutor().execute {
                        INSTANCE!!.categoryDao().insert(
                                Category(1, "Streaming video")
                        )

                        INSTANCE!!.accountsDao().insert(
                                Account(1, "Netflix", 1)
                        )

                        INSTANCE!!.pricingsDao().insert(
                                Pricing(1, 1, "Standard", "9.99")
                        )

                        INSTANCE!!.subscriptionsDao().insert(
                                Subscription(1,
                                        1,
                                        1,
                                        "First subs",
                                        "2018-04-14",
                                        1,
                                        "Year",
                                        "2019-10-05")
                        )

                        INSTANCE!!.subscriptionsDao().insert(
                                Subscription(2,
                                        1,
                                        1,
                                        "First subs",
                                        "2018-04-14",
                                        1,
                                        "Year",
                                        "2019-10-05")
                        )
                        INSTANCE!!.subscriptionsDao().insert(
                                Subscription(3,
                                        1,
                                        1,
                                        "First subs",
                                        "2018-04-14",
                                        1,
                                        "Year",
                                        "2019-10-05")
                        )
                        INSTANCE!!.subscriptionsDao().insert(
                                Subscription(4,
                                        1,
                                        1,
                                        "First subs",
                                        "2018-04-14",
                                        1,
                                        "Year",
                                        "2019-10-05")
                        )
                        INSTANCE!!.subscriptionsDao().insert(
                                Subscription(5,
                                        1,
                                        1,
                                        "First subs",
                                        "2018-04-14",
                                        1,
                                        "Year",
                                        "2019-10-05")
                        )

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