package com.example.kotlinexp1

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat.inflate
import javax.sql.CommonDataSource


class MainActivity : AppCompatActivity() {

    lateinit var mainlisView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val techlist = arrayOf<String>(
            "google",
            "facebook",
            "watsapp"
        )

        // supportActionBar?.hide(eb596e)
        mainlisView = findViewById(R.id.mainlisview)

//        val colors = Color.parseColor("#16c79a")
//
//        mainlisView.setBackgroundColor(colors)

        mainlisView.adapter = namesAdapter(this, techlist)

    }

    private class namesAdapter(val context: Context, val dataSource: Array<String>): BaseAdapter(){
        override fun getCount(): Int {
            return dataSource.size
        }

        override fun getItem(position: Int): Any {
           //Log.v("INDEX",position.toString())
            return dataSource[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val layoutinflater = LayoutInflater.from(context)
            val ListViewLayout = layoutinflater.inflate(R.layout.main_listview_layout, parent, false)
            val techtitle = ListViewLayout.findViewById<TextView>(R.id.techTitle)
            techtitle.text = dataSource[position]
            return ListViewLayout

//            val textview = TextView(context)
//            val color = Color.parseColor("#16c79a")
//            textview.setTextColor(color)
//            textview.text="super duper diaper"
//            return textview
        }
    }


}