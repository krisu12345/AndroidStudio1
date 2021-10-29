package com.example.androidstudio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        przod.setOnClickListener {
            imageView.setImageResource(R.drawable.cool1);
            if(
        }
        tyl.setOnClickListener {
            imageView.setImageResource(R.drawable.nibb4);
        }
    }
}