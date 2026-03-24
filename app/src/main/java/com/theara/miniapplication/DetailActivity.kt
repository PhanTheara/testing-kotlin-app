package com.theara.miniapplication

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("TITLE") ?: ""
        val desc  = intent.getStringExtra("DESC")  ?: ""

        findViewById<TextView>(R.id.detailTitle).text = title
        findViewById<TextView>(R.id.detailDesc).text  = desc

        findViewById<TextView>(R.id.backBtn).setOnClickListener {
            finish()
        }

        // ✅ WebView
        val webView = findViewById<WebView>(R.id.detailWebView)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        // ✅ Map title → HTML file
        val fileName = when (title) {
            "Kotlin" -> "kotlin.html"
            "Java" -> "java.html"
            "JavaScript" -> "javascript.html"
            "Python" -> "python.html"
            "Spring Boot" -> "spring.html"
            else -> "kotlin.html"
        }

        // ✅ Load from assets
        webView.loadUrl("file:///android_asset/$fileName")
    }
}