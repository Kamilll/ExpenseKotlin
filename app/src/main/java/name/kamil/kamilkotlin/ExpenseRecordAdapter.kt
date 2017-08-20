package name.kamil.kamilkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by kamil on 20/08/17.
 */
class ExpenseRecordAdapter : ArrayAdapter<ExpenseRecord> {
    constructor(ctx: Context) : super(ctx,R.layout.item_expense)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val item = getItem(position)

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_expense, parent, false)

        view.findViewById<TextView>(R.id.ieCategory).text = item.category
        view.findViewById<TextView>(R.id.ieAmount).text = item.amount.toString()

        return view
    }

}