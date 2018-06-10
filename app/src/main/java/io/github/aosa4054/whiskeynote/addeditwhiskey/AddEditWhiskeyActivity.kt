package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.app.Activity
import android.app.AlertDialog
import android.arch.lifecycle.ViewModelProviders
import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import io.github.aosa4054.whiskeynote.R

class AddEditWhiskeyActivity: AppCompatActivity(), AddEditWhiskeyNavigator{

    lateinit var mViewModel: AddEditWiskeyViewModel
    private var typeFrag: Int = intent.getIntExtra("TYPE_FRAG", 0)

    companion object {
        val REQUEST_CODE: Int = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addeditwhiskey)

        mViewModel = ViewModelProviders.of(this).get(AddEditWiskeyViewModel::class.java)
        mViewModel.onActivityCreated(this, typeFrag)
    }

    override fun onDestroy() {
        mViewModel.onActivityDestroyed()
        super.onDestroy()
    }


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

}