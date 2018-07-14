package io.github.aosa4054.whiskeynote.top

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.whiskeys.scotch.ScotchesActivity

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
