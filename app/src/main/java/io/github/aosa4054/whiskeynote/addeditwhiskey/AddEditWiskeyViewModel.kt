package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.Navigation
import io.github.aosa4054.whiskeynote.data.ScotchRepository
import kotlin.math.log


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
        }
    }

    //former onActivityCreated
    fun setupNavigator(navigator: AddEditWhiskeyNavigator){
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
        }
    }

    private fun saveScotch(){
        val newScotch = mAddEditWhiskeyNavigator?.getViewData()

        if (newScotch != null) {
            mScotchRepository.insert(newScotch)
        }else {
            //mAddEditWhiskeyNavigator?.toastError()
            Log.d("nullScotch", "newScotchがnull")
        }


        mAddEditWhiskeyNavigator!!.backToList()


    }

    private fun saveAmerican(){}

    private fun saveJapanese(){}

    private fun saveOthers(){}

    fun deleteNavigator(){
        mAddEditWhiskeyNavigator = null
    }
}
