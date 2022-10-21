
package com.example.androidstudio1

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //rotacjaX.addTextChangedListener{

       // }
        seekBar2.min = 1
        seekBar2.max = 10
        seekBar2.incrementProgressBy(1)

        seekBar2.setOnSeekBarChangeListener(
            object:SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    var wartosc = progress
                    if(wartosc < 4){
                        imageView2.setImageResource(R.drawable.green)
                        imageView2.imageAlpha = 75
                    }
                    if((wartosc <= 7) && (wartosc > 4)){
                        imageView2.setImageResource(R.drawable.blue)
                        imageView2.imageAlpha = 50
                    }
                    if((wartosc <= 10) && (wartosc > 7)){
                        imageView2.setImageResource(R.drawable.red)
                        imageView2.imageAlpha = 75
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            }
        )





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

    @SuppressLint("SuspiciousIndentation")
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
    fun czysc1(view: View) {
        imageView.setImageResource(0)
    }

    fun rotujemy(view: View) {
        var nowa = rotacjaX.text.toString().toFloat()
        imageView.rotationY = nowa

        var nowa1 = rotacjaX2.text.toString().toFloat()
        imageView.rotationX = nowa1


        //postanowilem ze Y bedzie  ciekawsza a zmieniac mi sie juz nie chce
    }
    fun alphaaa(view: View){
        var nowa2 = smoke.text.toString().toInt()
        imageView.imageAlpha = nowa2
    }
}