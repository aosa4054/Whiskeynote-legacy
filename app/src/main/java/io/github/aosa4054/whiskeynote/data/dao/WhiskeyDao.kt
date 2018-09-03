package io.github.aosa4054.whiskeynote.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.github.aosa4054.whiskeynote.data.entity.Whiskey

@Dao interface WhiskeyDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(whiskey: Whiskey)

    @Query("SELECT * from whiskey_table")
    fun getAllWhiskeys(): LiveData<List<Whiskey>>

    @Query("SELECT * from whiskey_table WHERE kind = 'Scotch'")
    fun getScotches(): LiveData<List<Whiskey>>

    @Query("SELECT * from whiskey_table WHERE kind = 'Japanese'")
    fun getJapanese(): LiveData<List<Whiskey>>

    @Query("SELECT * from whiskey_table WHERE kind = 'American'")
    fun getAmericans(): LiveData<List<Whiskey>>

    @Query("SELECT * from whiskey_table WHERE kind = 'Others'")
    fun getOthers(): LiveData<List<Whiskey>>

    @Query("SELECT * from whiskey_table WHERE entryid = :whiskeyId")
    fun getWhiskeyById(whiskeyId: String): Whiskey

    @Query("DELETE FROM whiskey_table WHERE entryid = :whiskeyId")
    fun deleteWhiskeyById(whiskeyId: String)

    @Query("DELETE FROM whiskey_table")
    fun deleteAll()
}