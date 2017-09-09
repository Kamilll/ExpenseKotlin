package name.kamil.kamilkotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class AddExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

//        var string = intent.extras.putString(MainActivity.EXTRA_STRING, "value Second activity");
        val button = findViewById<Button>(R.id.okButton)
        button.setOnClickListener { view -> goBack(view) }
    }

    private fun goBack(view: View?) {
        var categoryEditText = findViewById<TextView>(R.id.categoryEditText)
        val priceEditText = findViewById<TextView>(R.id.priceEditText)

        val intent = Intent()
        val putExtra = intent.putExtra("cena", priceEditText.text.toString().toFloatOrNull())
        Log.d("tag", "Cena : " + priceEditText.text.toString().toFloatOrNull())

        intent.putExtra("kategoria", categoryEditText.text.toString())
        Log.d("tag", "kategoria: " + categoryEditText.text)

        setResult(Activity.RESULT_OK, intent)

        this.finish()
    }


}
