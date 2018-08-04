package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.app.AlertDialog
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import android.content.Intent
import android.content.Intent.getIntent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import io.github.aosa4054.whiskeynote.data.ScotchRepository
import io.github.aosa4054.whiskeynote.data.entity.Scotch



class AddEditWhiskeyViewModel(application: Application): AndroidViewModel(application){

    private var mScotchRepository: ScotchRepository = ScotchRepository(application)
    private var mAddEditWhiskeyNavigator: AddEditWhiskeyNavigator? = null
    private var typeflag: Int = 0

    fun saveWhiskey(){
        when (typeflag){
            1 -> saveScotch()
            2 -> saveAmerican()
            3 -> saveJapanese()
            4 -> saveOthers()
            else -> mAddEditWhiskeyNavigator?.chooseWhiskeyType()
                    ?: mAddEditWhiskeyNavigator?.toastError()
        }
    }

    fun onActivityCreated(navigator: AddEditWhiskeyNavigator){
        mAddEditWhiskeyNavigator = navigator
    }

    fun setTypeFlag(type: Int){typeflag = type}

    //saveWhiskeyでうまく保存できず、Dialog経由で保存する場合のメソッド
    fun saveWhiskeyViaDialog(flag: Int){
        when (flag){
            1 -> saveScotch()
            2 -> saveAmerican()
            3 -> saveJapanese()
            4 -> saveOthers()
            else -> mAddEditWhiskeyNavigator?.toastError()
        }
    }

    private fun saveScotch(){
        val newScotch = mAddEditWhiskeyNavigator?.getViewData()
        if (newScotch != null) {
            mScotchRepository.insert(newScotch)
        }else {
            mAddEditWhiskeyNavigator?.toastError()
        }
    }

    private fun saveAmerican(){}

    private fun saveJapanese(){}

    private fun saveOthers(){}

    fun onActivityDestroyed(){
        mAddEditWhiskeyNavigator = null
    }
}
