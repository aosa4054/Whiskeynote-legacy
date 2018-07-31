package io.github.aosa4054.whiskeynote.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import io.github.aosa4054.whiskeynote.data.dao.ScotchDao
import io.github.aosa4054.whiskeynote.data.entity.Scotch

@Database(entities = arrayOf(Scotch::class), version = 1)
abstract class ScotchDatabase: RoomDatabase(){
    abstract fun scotchDao(): ScotchDao

    companion object {

        @Volatile private var INSTANCE: ScotchDatabase? = null

        fun getInstance(context: Context): ScotchDatabase =
                INSTANCE ?: synchronized(this){
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it}
                }

        fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext, ScotchDatabase::class.java, "Scotch.db")
                        .build()
    }


}