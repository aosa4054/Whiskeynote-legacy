package io.github.aosa4054.whiskeynote.top

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import io.github.aosa4054.whiskeynote.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mToolbar = findViewById<Toolbar>(R.id.topToolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun toJapanese(view: View){
        Toast.makeText(applicationContext, "ジャパ", LENGTH_SHORT).show()
    }

    fun toAmerican(view: View){
        Toast.makeText(applicationContext, "アメ", LENGTH_SHORT).show()
    }

    fun toOthers(view: View){
        Toast.makeText(applicationContext, "その他", LENGTH_SHORT).show()
    }

}
