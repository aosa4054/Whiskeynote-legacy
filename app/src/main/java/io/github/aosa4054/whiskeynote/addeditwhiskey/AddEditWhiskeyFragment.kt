package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.os.Bundle
import android.text.InputType.TYPE_CLASS_NUMBER
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputLayout
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.data.entity.Scotch
import java.util.*

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
    }

}