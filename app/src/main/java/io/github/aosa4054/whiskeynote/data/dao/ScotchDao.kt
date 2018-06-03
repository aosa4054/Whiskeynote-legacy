package io.github.aosa4054.whiskeynote.data.dao

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.*
import io.github.aosa4054.whiskeynote.data.entity.Scotch

@Dao abstract class ScotchDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(scotch: Scotch)

    //@Update
    //abstract fun update(scotch: Scotch)

    @Query("SELECT * from scotch_table")
    abstract fun getAllScotches(): MutableLiveData<List<Scotch>>

    @Query("SELECT * from scotch_table WHERE entryid = :scotchId")
    abstract fun getSctchById(scotchId: String): Scotch

    @Query("DELETE FROM scotch_table WHERE entryid = :scotchId")
    abstract fun deleteScotchById(scotchId: String)

    @Query("DELETE FROM scotch_table")
    abstract fun deleteAll()
}