package com.example.cpas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class MyinfoActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var databaseReference : DatabaseReference
    var userInfoArr = arrayOfNulls<String>(5)

    private var email = 0
    private var id = 1
    private var name = 2
    private var nickname = 3
    private var password = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myinfo)
        val revert : ImageView = findViewById(R.id.iv_revert)
        val myid : TextView = findViewById(R.id.myid)
        val myemail : TextView = findViewById(R.id.myemail)
        val mynick : TextView = findViewById(R.id.nickname)

        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(auth.uid.toString())

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var i = 0
                for(data in snapshot.children){
                    userInfoArr[i] = data.getValue().toString()
                    i++
                }
                myid.text = userInfoArr[1]
                myemail.text = userInfoArr[0]
                mynick.text = userInfoArr[3]
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        revert.setOnClickListener {
            finish()
        }
    }
}
