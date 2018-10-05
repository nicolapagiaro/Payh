package it.future.payh.storage.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import it.future.payh.storage.SubsDatabase
import it.future.payh.storage.dao.AccountsDao
import it.future.payh.storage.entities.Account

class AccountsRepository(application: Application) {
    lateinit var mAccountList : LiveData<List<Account>>
    lateinit var mAccountDao : AccountsDao

    init {
        val db : SubsDatabase? = SubsDatabase.getInstance(application)

        if(db != null) {
            mAccountDao = db.accountsDao()
            mAccountList = mAccountDao.getAll()
        }
    }
}