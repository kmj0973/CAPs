package com.example.cpas

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class               MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //코드작성 예시
        //테스트2

        val search : ImageView = findViewById(R.id.iv_search)
        val more : ImageView = findViewById(R.id.iv_more)
        val category : ImageView = findViewById(R.id.iv_category)

        val comunity : Button = findViewById(R.id.btn_comunity)
        val planner : Button = findViewById(R.id.btn_planner)
        val myInfo : Button = findViewById(R.id.btn_myInfo)

        more.setOnClickListener {
            val drawer : DrawerLayout = findViewById(R.id.layout_drawer)
            drawer.openDrawer(GravityCompat.END)
        }
        val nav : NavigationView = findViewById(R.id.naviView)
        nav.setNavigationItemSelectedListener(this)

        val tmp  = arrayListOf<Posting>(
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment),
            Posting("제목", "미리 보기", "1분 전", "3", R.drawable.comment)
        )
        val rv : RecyclerView = findViewById(R.id.rv_posting)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.adapter = PostingAdapter(tmp)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.tmp1 -> Toast.makeText(applicationContext, "임시", Toast.LENGTH_SHORT).show()
            R.id.tmp2 -> Toast.makeText(applicationContext, "임시", Toast.LENGTH_SHORT).show()
            R.id.tmp3 -> Toast.makeText(applicationContext, "임시", Toast.LENGTH_SHORT).show()
        }

        val drawer : DrawerLayout = findViewById(R.id.layout_drawer)
        drawer.closeDrawers()

        return false
    }

    override fun onBackPressed() {
        val drawer : DrawerLayout = findViewById(R.id.layout_drawer)
        if(drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawers()
        }
        else {
            super.onBackPressed()
        }
    }
}