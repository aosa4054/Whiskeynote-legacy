package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.aosa4054.whiskeynote.addeditwhiskey.AddEditWhiskeyActivity
import io.github.aosa4054.whiskeynote.data.ScotchRepository
import io.github.aosa4054.whiskeynote.data.entity.Scotch

open class ScotchesViewModel(application: Application, private val mScotchRepository: ScotchRepository):
        AndroidViewModel(application){

    private var mAllScotches: LiveData<List<Scotch>> = mScotchRepository.getAllScotches()
    lateinit var imgTag: MutableLiveData<String>
    lateinit var name: MutableLiveData<String>
    private var mScotchesNavigator: ScotchesNavigator? = null
    private var mScotchItemNavigator: ScotchItemNavigator? = null

    init {
        if (mAllScotches.value != null) {
            mAllScotches.value!!.forEach {
                name.postValue(it.name)
                imgTag.postValue(it.type)
            }
        }
    }

    fun setNavigators(scotchesNavigator: ScotchesNavigator, scotchItemNavigator: ScotchItemNavigator){
        setNavigator(scotchesNavigator)
        setNavigator(scotchItemNavigator)
    }

    /*
    fun handleActivityResult(requestCode: Int, resultCode: Int){
        if (AddEditWhiskeyActivity.REQUEST_CODE == requestCode){
            when (resultCode){
                AddEditWhiskeyActivity.
            }
        }
    }
    */

    fun onActivityDestroyed(){
        mScotchesNavigator = null
        mScotchItemNavigator = null
    }

    fun addNewScotch(){
        if (mScotchesNavigator != null){
            mScotchesNavigator!!.addNewScotch()
        }
    }

    /*
    fun scotchClicked(position: Int){
        //LiveDataから個別のデータを取りたい. positionを使って配列から取り出せないかなあ
        val scotchId: String? = mAllScotches.value?.get(position)?.id
        if (scotchId == null){return}
        if (mScotchItemNavigator != null){
            mScotchItemNavigator!!.openScotchDetails(scotchId)
            //Activityで実装
        }
    }
    */

    //<editor-fold desc="methods to set navigators individually, called in setNavigators function">
    private fun setNavigator(navigator: ScotchesNavigator){
        mScotchesNavigator = navigator
    }

    private fun setNavigator(navigator: ScotchItemNavigator){
        mScotchItemNavigator = navigator
    }
    //</editor-fold>

    //<editor-fold desc="Wrapper methods of ScotchDao">
    fun insert(scotch: Scotch){
        mScotchRepository.insert(scotch)
    }

    fun getAllScotches(): LiveData<List<Scotch>>{
        return mAllScotches
    }

    fun getScotchById(scotchId: String): Scotch{
        return mScotchRepository.getScotchById(scotchId)
    }

    fun deleteScotchById(scotchId: String) {
        mScotchRepository.deleteScotchById(scotchId)
    }

    fun deleteAllScotches(){
        mScotchRepository.deleteAllScotches()
    }
    //</editor-fold>

}