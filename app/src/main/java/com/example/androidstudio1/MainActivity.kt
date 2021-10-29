package com.example.androidstudio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var img = "cool1"

        przod.setOnClickListener {
            if(img == "cool1"){
                imageView.setImageResource(R.drawable.grzechu2);
                img = "grzechu2"
            }
            else if(img == "grzechu2"){
                imageView.setImageResource(R.drawable.grzes3);
                img = "grzes3"
            }
            else if(img == "grzes3"){
                imageView.setImageResource(R.drawable.nibb4);
                img = "nibb4"
            }
            else if(img == "nibb4"){
                imageView.setImageResource(R.drawable.cool1);
                img = "cool1"
            }
        }
        tyl.setOnClickListener {
            if(img == "cool1"){
                imageView.setImageResource(R.drawable.nibb4);
                img = "nibb4"
            }
            else if(img == "grzechu2"){
                imageView.setImageResource(R.drawable.cool1);
                img = "cool1"
            }
            else if(img == "grzes3"){
                imageView.setImageResource(R.drawable.grzechu2);
                img = "grzechu2"
            }
            else if(img == "nibb4"){
                imageView.setImageResource(R.drawable.grzes3);
                img = "grzes3"
            }
        }
    }
}