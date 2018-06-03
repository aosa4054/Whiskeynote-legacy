package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import io.github.aosa4054.whiskeynote.R

class AddEditWhiskeyActivity: AppCompatActivity(){

    companion object {
        val REQUEST_CODE: Int = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addeditwhiskey)
    }

    private var typeFrag: Int = intent.getIntExtra("TYPE_FRAG", 0)

}