package com.theara.miniapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val courses = listOf(
            Course("Kotlin",       "For web and mobile, Build API"),
            Course("Java",         "Backend Development"),
            Course("JavaScript",   "Web Development"),
            Course("Python",       "AI & Data Science"),
            Course("Spring Boot",  "Microservices & REST API")
        )

        val listView = findViewById<ListView>(R.id.listView1)
        listView.adapter = CourseAdapter(this, courses)

        // ✅ Click → send title to DetailActivity via Intent
        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("TITLE", courses[position].title)
            intent.putExtra("DESC",  courses[position].description)
            startActivity(intent)
        }
    }
}