package it.future.payh

import android.support.v7.app.ActionBar

class DecorationHelper {

    companion object {

        /**
         * It sets up the custom action bar of the application
         */
        fun setupCustomActionBar(actionBar: ActionBar) {
            actionBar.elevation = 0F

            // custom view
            actionBar.setDisplayShowCustomEnabled(true)
            actionBar.displayOptions = android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM
            actionBar.setCustomView(R.layout.custom_action_bar)

            // search button
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_search_grey_24dp)
        }
    }
}