package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import io.github.aosa4054.whiskeynote.addeditwhiskey.AddEditWhiskeyActivity
import io.github.aosa4054.whiskeynote.data.ScotchRepository
import io.github.aosa4054.whiskeynote.data.entity.Scotch

open class ScotchesViewModel(application: Application):
        AndroidViewModel(application){

    private var mScotchRepository: ScotchRepository = ScotchRepository(application)
    private var mAllScotches: LiveData<List<Scotch>> = mScotchRepository.getAllScotches()
    lateinit var type: MutableLiveData<String>
    lateinit var name: MutableLiveData<String>
    private var mScotchesNavigator: ScotchesNavigator? = null
    private var mScotchItemNavigator: ScotchItemNavigator? = null

    init {
        if (mAllScotches.value != null) {
            mAllScotches.value!!.forEach {
                name.postValue(it.name)
                type.postValue(it.type)
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