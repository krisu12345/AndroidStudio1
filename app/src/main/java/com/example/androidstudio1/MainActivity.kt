package com.example.androidstudio1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fota.isEnabled = false
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),111)
        }
        else
            fota.isEnabled = true
        fota.setOnClickListener {
            val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, 101)
        }

        var img = "cool1"

        przod.setOnClickListener {
            if(img == "cool1"){
                imageView.setImageResource(R.drawable.grzechu2)
                img = "grzechu2"
            }
            else if(img == "grzechu2"){
                imageView.setImageResource(R.drawable.grzes3)
                img = "grzes3"
            }
            else if(img == "grzes3"){
                imageView.setImageResource(R.drawable.nibb4)
                img = "nibb4"
            }
            else if(img == "nibb4"){
                imageView.setImageResource(R.drawable.cool1)
                img = "cool1"
            }
        }
        tyl.setOnClickListener {
            if(img == "cool1"){
                imageView.setImageResource(R.drawable.nibb4)
                img = "nibb4"
            }
            else if(img == "grzechu2"){
                imageView.setImageResource(R.drawable.cool1)
                img = "cool1"
            }
            else if(img == "grzes3"){
                imageView.setImageResource(R.drawable.grzechu2)
                img = "grzechu2"
            }
            else if(img == "nibb4"){
                imageView.setImageResource(R.drawable.grzes3)
                img = "grzes3"
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101)
        {
            val pic:Bitmap? = data?.getParcelableExtra<Bitmap>("data")
                imageView.setImageBitmap(pic)
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            fota.isEnabled = true
        }
    }

    fun sprawdz(view: View) {
        if(checkBox.isChecked){
            imageView.isInvisible = true
        }
        else
            imageView.isVisible = true
    }

}