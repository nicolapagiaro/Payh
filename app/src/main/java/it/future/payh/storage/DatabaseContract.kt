package it.future.payh.storage

class DatabaseContract {

    // static field
    companion object {
        const val databaseVersion = 1
        const val databaseName = "payhDatabase"

        const val subscriptionTableName = "subs"
        const val accountTableName = "account"
        const val categoryTableName = "category"
        const val pricingTableName = "pricing"
    }
}