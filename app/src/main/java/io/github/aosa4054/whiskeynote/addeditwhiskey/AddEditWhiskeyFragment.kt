package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProviders
import io.github.aosa4054.whiskeynote.R

class AddEditWhiskeyFragment(): androidx.fragment.app.Fragment(){

    private var typeFlag = 0
    private lateinit var mView: View
    private var mViewModel: AddEditWhiskeyViewModel? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_add_edit_whiskey, container, false)
        typeFlag = AddEditWhiskeyFragmentArgs.fromBundle(arguments).flag
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViewModel()
        setupSaveButton()
    }

    private fun setupSaveButton(){
        activity?.findViewById<AppCompatButton>(R.id.btn_save)?.setOnClickListener{mViewModel!!.saveWhiskey()}
    }

    private fun setupViewModel(){
        mViewModel = ViewModelProviders.of(this).get(AddEditWhiskeyViewModel::class.java)
        mViewModel!!.setTypeFlag(typeFlag)
        val act = AddEditWhiskeyActivity()
        mViewModel!!.setupNavigator(act)
    }

}