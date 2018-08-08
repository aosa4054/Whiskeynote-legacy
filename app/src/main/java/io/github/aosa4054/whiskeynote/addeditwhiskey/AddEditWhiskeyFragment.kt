package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputLayout
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.data.entity.Scotch
import java.util.*

class AddEditWhiskeyFragment(): androidx.fragment.app.Fragment(), AddEditWhiskeyNavigator{

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
        setupCancelButton()
    }

    private fun setupSaveButton(){
        activity?.findViewById<AppCompatButton>(R.id.btn_save)?.setOnClickListener{mViewModel!!.saveWhiskey()}
    }
    private fun setupCancelButton(){
        activity?.findViewById<AppCompatButton>(R.id.btn_cancel)?.setOnClickListener { backToList() }
    }

    private fun setupViewModel(){
        mViewModel = ViewModelProviders.of(this).get(AddEditWhiskeyViewModel::class.java)
        mViewModel!!.setTypeFlag(typeFlag)
        val act = AddEditWhiskeyActivity()
        mViewModel!!.setupNavigator(this)
    }

    //こっからためし
    override fun getViewData(): Scotch {
        Log.d("yeah", "いけるね")
        val r = Random()
        val id = r.nextInt()
        val name = mView.findViewById<TextInputLayout>(R.id.text_input_name).editText!!.text.toString()
        val kind = mView.findViewById<TextInputLayout>(R.id.text_input_kind).editText!!.text.toString()
        val price = mView.findViewById<TextInputLayout>(R.id.text_input_price).editText!!.text.toString()
        val ml = mView.findViewById<TextInputLayout>(R.id.text_input_ml).editText!!.text.toString()
        val fragrance = mView.findViewById<TextInputLayout>(R.id.text_input_fragrance).editText!!.text.toString()
        val taste = mView.findViewById<TextInputLayout>(R.id.text_input_taste).editText!!.text.toString()
        val aftertaste = mView.findViewById<TextInputLayout>(R.id.text_input_aftertaste).editText!!.text.toString()
        val memo = mView.findViewById<TextInputLayout>(R.id.text_input_memo).editText!!.text.toString()

        Log.d("Result", "$name, $kind, $fragrance, $taste, $aftertaste, $memo")
        val scotch = Scotch(id, name, kind, price, ml, fragrance, taste, aftertaste, memo)

        return scotch
    }

    //Navigatorからウイスキーのflagを入力してもらうダイアログを生成、ViewModelに渡して保存してもらう
    override fun chooseWhiskeyType(){
        var selected: Int = 0
        val items = arrayOf("Scotch", "American", "Japanese", "Others")
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)

        builder.setMessage("ウィスキーの種類を選択してください")
                .setSingleChoiceItems(items, selected, DialogInterface.OnClickListener(fun (dialog: DialogInterface, which: Int){selected = which}))
                .setPositiveButton("OK", DialogInterface.OnClickListener(fun (dialog: DialogInterface, which: Int){mViewModel!!.saveWhiskeyViaDialog(selected + 1)}))
                .show()
    }

    override fun backToList() = Navigation.findNavController(mView).popBackStack()

}