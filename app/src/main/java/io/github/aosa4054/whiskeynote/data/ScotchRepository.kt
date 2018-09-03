package io.github.aosa4054.whiskeynote.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.os.AsyncTask
import io.github.aosa4054.whiskeynote.data.dao.ScotchDao
import io.github.aosa4054.whiskeynote.data.entity.Scotch

class ScotchRepository(application: Application){

    private var mScotchDao: ScotchDao
    private var mAllScotches: LiveData<List<Scotch>>

    init {
        val db: ScotchDatabase = ScotchDatabase.getInstance(application)
        mScotchDao = db.scotchDao()
        mAllScotches = mScotchDao.getAllScotches()
    }

    companion object {
        var INSTANCE: ScotchRepository? = null //repositoryのgetInstanceメソッドを作る？

        fun getInstance(application: Application): ScotchRepository {
            if (INSTANCE == null) {
                INSTANCE = ScotchRepository(application)
            }
            return INSTANCE as ScotchRepository
        }

        fun deleteRepository(){
            INSTANCE == null
        }
    }

     fun getScotchById(scotchId: String): Scotch{
         return mScotchDao.getSctchById(scotchId)
     }

    fun getAllScotches(): LiveData<List<Scotch>> {
        return mAllScotches
    }

    fun deleteScotchById(scotchId: String){
        mScotchDao.deleteScotchById(scotchId)
    }

    fun deleteAllScotches(){
        mScotchDao.deleteAll()
    }

    fun insert(scotch: Scotch){
        insertAsyncTask(mScotchDao).execute(scotch)
    }

    //AsyncTask class for inserting new item
    private  class insertAsyncTask internal constructor
    (private val mAsyncTaskDao: ScotchDao) : AsyncTask<Scotch, Void, Void>() {

        override fun doInBackground(vararg params: Scotch): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }

    }

}