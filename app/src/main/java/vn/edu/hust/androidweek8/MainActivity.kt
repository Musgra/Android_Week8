package vn.edu.hust.androidweek8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.addContact -> {
                val form = CreateFormFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView3, form, "FORM")
                    .addToBackStack("FORM")
                    .commit()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}