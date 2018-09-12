package it.future.payh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import it.future.payh.pages.Homepage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup a custom ActionBar
        DecorationHelper.setupCustomActionBar(supportActionBar!!)

        // display the home page fragment
        val homepage = Homepage.newInstance()
        supportFragmentManager.beginTransaction()
                .add(R.id.main_act_frag_space, homepage, "HomepageFrag")
                .commit()

        // simple fab implementation

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                Toast.makeText(applicationContext, "Search#1 menu tapped", Toast.LENGTH_SHORT).show()
            }
            R.id.main_act_fav_menu -> {
                Toast.makeText(applicationContext, "Fav menu tapped", Toast.LENGTH_SHORT).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
