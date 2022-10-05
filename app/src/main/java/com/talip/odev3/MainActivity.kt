package com.talip.odev3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.InputStream
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var film =findViewById<TextView>(R.id.textView5)
        var string: String? = ""

        if(Locale.getDefault().displayLanguage == "Türkçe"){
            try {
                val inputStream: InputStream = assets.open("lotr.txt")
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                string = String(buffer)
            } catch (e: Exception) {
                string = e.toString()
            }
        }   else{
            try {
                val inputStream: InputStream = assets.open("lotr-en.txt")
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                string = String(buffer)
            } catch (e: Exception) {
                string = e.toString()
            }
        }


        film.text = string
    }
}