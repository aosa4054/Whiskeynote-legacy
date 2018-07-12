package io.github.aosa4054.whiskeynote.data.dao

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.*
import io.github.aosa4054.whiskeynote.data.entity.Scotch

@Dao interface ScotchDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(scotch: Scotch)

    //@Update
    //abstract fun update(scotch: Scotch)

    @Query("SELECT * from scotch_table")
    fun getAllScotches(): LiveData<List<Scotch>>

    @Query("SELECT * from scotch_table WHERE entryid = :scotchId")
    fun getSctchById(scotchId: String): Scotch

    @Query("DELETE FROM scotch_table WHERE entryid = :scotchId")
    fun deleteScotchById(scotchId: String)

    @Query("DELETE FROM scotch_table")
    fun deleteAll()
}