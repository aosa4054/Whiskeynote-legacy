package io.github.aosa4054.whiskeynote.data

import android.app.Application
import androidx.lifecycle.LiveData
import android.os.AsyncTask
import io.github.aosa4054.whiskeynote.data.dao.WhiskeyDao
import io.github.aosa4054.whiskeynote.data.entity.Whiskey

class WhiskeyRepository(application: Application){

    private var mWhiskeyDao: WhiskeyDao
    private var mAllWhiskeys: LiveData<List<Whiskey>>
    private var mAllScotches: LiveData<List<Whiskey>>
    private var mAllJapanese: LiveData<List<Whiskey>>
    private var mAllAmericans: LiveData<List<Whiskey>>
    private var mAllOthers: LiveData<List<Whiskey>>

    init {
        val db: WhiskeyDatabase = WhiskeyDatabase.getInstance(application)
        mWhiskeyDao = db.whiskeyDao()
        mAllWhiskeys = mWhiskeyDao.getAllWhiskeys()
        mAllScotches = mWhiskeyDao.getScotches()
        mAllJapanese = mWhiskeyDao.getJapanese()
        mAllAmericans = mWhiskeyDao.getAmericans()
        mAllOthers = mWhiskeyDao.getOthers()
    }

    companion object {
        var INSTANCE: WhiskeyRepository? = null //repositoryのgetInstanceメソッドを作る？

        fun getInstance(application: Application): WhiskeyRepository {
            if (INSTANCE == null) {
                INSTANCE = WhiskeyRepository(application)
            }
            return INSTANCE as WhiskeyRepository
        }

        fun deleteRepository(){
            INSTANCE == null
        }
    }

     fun getWhiskeyById(whiskeyId: String): Whiskey{
         return mWhiskeyDao.getWhiskeyById(whiskeyId)
     }

    fun getAllWhiskeys(): LiveData<List<Whiskey>> {
        return mAllWhiskeys
    }

    fun getScotches(): LiveData<List<Whiskey>> {
        return mAllScotches
    }

    fun getJapanese(): LiveData<List<Whiskey>> {
        return  mAllJapanese
    }

    fun getAmericans(): LiveData<List<Whiskey>> {
        return mAllAmericans
    }

    fun getOthers(): LiveData<List<Whiskey>> {
        return mAllOthers
    }

    fun deleteWhiskeyById(whiskeyId: String){
        mWhiskeyDao.deleteWhiskeyById(whiskeyId)
    }

    fun deleteAllWhiskeys(){
        mWhiskeyDao.deleteAll()
    }

    fun insert(scotch: Whiskey){
        insertAsyncTask(mWhiskeyDao).execute(scotch)
    }

    private  class insertAsyncTask internal constructor
    (private val mAsyncTaskDao: WhiskeyDao) : AsyncTask<Whiskey, Void, Void>() {
        override fun doInBackground(vararg params: Whiskey): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }

}