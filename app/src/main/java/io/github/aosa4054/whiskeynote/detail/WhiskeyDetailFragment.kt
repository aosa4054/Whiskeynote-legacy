package io.github.aosa4054.whiskeynote.detail

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.aosa4054.whiskeynote.R

class WhiskeyDetailFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v: View = inflater.inflate(R.layout.fragment_whiskey_detail, container, false)

        val toolbarLayout = v.findViewById<CollapsingToolbarLayout>(R.id.wd_toolbar_layout)
        toolbarLayout.title = "Title"

        return v
    }
}