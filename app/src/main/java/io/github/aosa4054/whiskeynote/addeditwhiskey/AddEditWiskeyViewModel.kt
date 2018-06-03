package io.github.aosa4054.whiskeynote.addeditwhiskey

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Intent
import android.content.Intent.getIntent
import io.github.aosa4054.whiskeynote.data.ScotchRepository
import io.github.aosa4054.whiskeynote.data.entity.Scotch

class AddEditWiskeyViewModel(application: Application, private val mScotchRepository: ScotchRepository,
                             private val typeFrag: Int) {

    /*LiveDataいらんくね
    private val mAllScotches: MutableLiveData<List<Scotch>> = mScotchRepository.getAllScotches()
    lateinit var name: MutableLiveData<String>
    lateinit var imgTag: MutableLiveData<String>
    lateinit var price: MutableLiveData<Int>
    lateinit var ml: MutableLiveData<Int>
    lateinit var fragnance: MutableLiveData<String?>
    lateinit var taste: MutableLiveData<String?>
    lateinit var afterTaste: MutableLiveData<String?>
    lateinit var memo: MutableLiveData<String?>

    init {
        if (mAllScotches.value != null) {
            mAllScotches.value!!.forEach {
                name.postValue(it.name)
                imgTag.postValue(it.type)
                price.postValue(it.price)
                ml.postValue(it.ml)
                fragnance.postValue(it.fragrance)
                taste.postValue(it.taste)
                afterTaste.postValue(it.aftertaste)
                memo.postValue(it.memo)
            }
        }
    }
    */


    //private var mIsNewWhiskey: Boolean = false

    //frag: 1->Scotch, 2->American, 3->Japanese, 4->Others
    fun saveWhiskey(){
        when (typeFrag){
            1 -> saveScotch()
            2 -> saveAmerican()
            3 -> saveJapanese()
            4 -> saveOthers()
            //else ->
        }
    }

    fun saveScotch(){
        //val newScotch: Scotch = Scotch(/*viewからgetしまくり*/)
        //mScotchRepository.insert(newScotch)
    }

    fun saveAmerican(){}

    fun saveJapanese(){}

    fun saveOthers(){}

    //fun isNewWhiskey(): Boolean{return mIsNewWhiskey}
}
