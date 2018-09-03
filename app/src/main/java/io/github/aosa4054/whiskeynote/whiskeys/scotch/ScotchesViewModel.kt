package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.aosa4054.whiskeynote.data.WhiskeyRepository
import io.github.aosa4054.whiskeynote.data.entity.Whiskey

open class ScotchesViewModel(application: Application):
        AndroidViewModel(application){

    private var mScotchRepository = WhiskeyRepository(application)
    private var mScotches: LiveData<List<Whiskey>> = mScotchRepository.getScotches()
    lateinit var type: MutableLiveData<String>
    lateinit var name: MutableLiveData<String>
    private var mScotchesNavigator: ScotchesNavigator? = null
    private var mScotchItemNavigator: ScotchItemNavigator? = null

    init {
        if (mScotches.value != null) {
            mScotches.value!!.forEach {
                name.postValue(it.name)
                type.postValue(it.type)
            }
        }
    }

    fun setNavigators(scotchesNavigator: ScotchesNavigator, scotchItemNavigator: ScotchItemNavigator){
        setNavigator(scotchesNavigator)
        setNavigator(scotchItemNavigator)
    }

    fun onActivityDestroyed(){
        mScotchesNavigator = null
        mScotchItemNavigator = null
    }

    fun addNewScotch(){
        if (mScotchesNavigator != null){
            mScotchesNavigator!!.addNewScotch()
        }
    }

    //<editor-fold desc="methods to set navigators individually, called in setNavigators function">
    private fun setNavigator(navigator: ScotchesNavigator){
        mScotchesNavigator = navigator
    }

    private fun setNavigator(navigator: ScotchItemNavigator){
        mScotchItemNavigator = navigator
    }
    //</editor-fold>
}