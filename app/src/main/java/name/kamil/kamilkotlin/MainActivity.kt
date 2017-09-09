package name.kamil.kamilkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object  {
        val EXTRA_STRING = "name.kamil.extra_string"
        val REQUEST_CODE = 200
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view -> showAddExpenseActivity(view) }

        val listView = findViewById<ListView>(R.id.ListView)
        listView.adapter = ExpenseRecordAdapter(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE ) {

            val category = data.extras.getString("kategoria")
            val price = data.extras.getFloat("cena")
            Toast.makeText(this,category, Toast.LENGTH_SHORT).show()

            addExpenseElement(category, price)
        }
    }

    private fun addExpenseElement(category: String, price: Float) {
        val listView = findViewById<ListView>(R.id.ListView)
        val adapter = listView.adapter as ExpenseRecordAdapter
        adapter.add(ExpenseRecord(category, price))
    }


    private fun showAddExpenseActivity(view : View) {
        val intent = Intent(this, AddExpenseActivity::class.java)
        startActivityForResult(intent,  REQUEST_CODE)
    }

}

