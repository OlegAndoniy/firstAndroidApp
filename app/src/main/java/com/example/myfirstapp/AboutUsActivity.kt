package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about_us.*


class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        description.setOnTouchListener { v, event ->
            val duration =  android.widget.Toast.LENGTH_SHORT
            android.widget.Toast.makeText(this, "Touch", duration).show()
            true
        }

        support.setOnClickListener {
            android.widget.Toast.makeText(this, "Support", 1).show()
        }

        email_info.setOnFocusChangeListener { v, event ->
            android.widget.Toast.makeText(this, "Focus", 1).show()
            true
        }
        version.setOnLongClickListener {
            android.widget.Toast.makeText(this, "Long click", 1).show()
            true
        }
    }
}


