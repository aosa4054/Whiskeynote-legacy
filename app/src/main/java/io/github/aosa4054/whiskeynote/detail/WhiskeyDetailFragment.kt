package io.github.aosa4054.whiskeynote.detail

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.aosa4054.whiskeynote.R

class WhiskeyDetailFragment: androidx.fragment.app.Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v: View = inflater.inflate(R.layout.fragment_whiskey_detail, container, false)

        val toolbarLayout = v.findViewById<com.google.android.material.appbar.CollapsingToolbarLayout>(R.id.wd_toolbar_layout)
        toolbarLayout.title = "Title"

        return v
    }
}