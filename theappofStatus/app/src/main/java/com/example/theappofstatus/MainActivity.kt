package com.example.theappofstatus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class User (val displayName: String = "", val state: String = "")

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)



class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var ryUser: RecyclerView
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth
        ryUser = findViewById(R.id.rcView)
        db = Firebase.firestore

        val querry = db.collection("users")

        val options: FirestoreRecyclerOptions<User> = FirestoreRecyclerOptions.Builder<User>().setQuery(querry, User::class.java)
            .setLifecycleOwner(this).build()

        val adapter  = object: FirestoreRecyclerAdapter<User, UserViewHolder>(options){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
                val view = LayoutInflater.from(this@MainActivity).inflate(android.R.layout.simple_list_item_2, parent, false)
                return UserViewHolder(view)
            }

            override fun onBindViewHolder(holder: UserViewHolder, position: Int, model: User) {
                val tvName: TextView = holder.itemView.findViewById(android.R.id.text1)
                val stateText: TextView = holder.itemView.findViewById(android.R.id.text2)

                tvName.text = model.displayName
                stateText.text = model.state

                stateText.setOnClickListener{
                    Log.i("MainActivity", "CLICKED")
                }
            }
        }

        ryUser.adapter = adapter
        ryUser.layoutManager = LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menulogout){
            Log.d("MainActivity", "Logout")
            auth.signOut()
        }

        val logOutIntent = Intent(this, LoginN::class.java)
        logOutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(logOutIntent)
        finish()


        return super.onOptionsItemSelected(item)
    }
}