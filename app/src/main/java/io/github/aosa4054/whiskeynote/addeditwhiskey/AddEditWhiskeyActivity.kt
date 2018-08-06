package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.data.entity.Scotch
import java.util.*

class AddEditWhiskeyActivity: AppCompatActivity(){

    lateinit var mViewModel: AddEditWhiskeyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_whiskey)
    }


    /*
    //Navigatorからウイスキーのflagを入力してもらうダイアログを生成、ViewModelに渡して保存してもらう
    override fun chooseWhiskeyType(){
        var selected: Int = 0
        val items = arrayOf("Scotch", "American", "Japanese", "Others")
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setMessage("ウィスキーの種類を選択してください")
                .setSingleChoiceItems(items, selected, DialogInterface.OnClickListener(fun (dialog: DialogInterface, which: Int){selected = which}))
                .setPositiveButton("OK", DialogInterface.OnClickListener(fun (dialog: DialogInterface, which: Int){mViewModel.saveWhiskeyViaDialog(selected + 1)}))
                .show()
    }

    override fun toastError() {
        Toast.makeText(application, "申し訳ございません、エラーが発生しました。もう一度お試しください", Toast.LENGTH_SHORT).show()
    }



    override fun getViewData(): Scotch {
        Log.d("yeah", "いけるね")
        val r = Random()
        val id = r.nextInt()
        val name = findViewById<TextInputLayout>(R.id.text_input_name).editText.toString()
        val kind = findViewById<TextInputLayout>(R.id.text_input_kind).editText.toString()
        val price = findViewById<TextInputLayout>(R.id.text_input_price).editText.toString().toInt()
        val ml = findViewById<TextInputLayout>(R.id.text_input_ml).editText.toString().toInt()
        val fragrance = findViewById<TextInputLayout>(R.id.text_input_fragrance).editText.toString()
        val taste = findViewById<TextInputLayout>(R.id.text_input_taste).editText.toString()
        val aftertaste = findViewById<TextInputLayout>(R.id.text_input_aftertaste).editText.toString()
        val memo = findViewById<TextInputLayout>(R.id.text_input_memo).editText.toString()

        Log.d("Result", "$name, $kind, $fragrance, $taste, $aftertaste, $memo")
        val scotch = Scotch(id, name, kind, price, ml, fragrance, taste, aftertaste, memo)

        return scotch
    }
    */
}