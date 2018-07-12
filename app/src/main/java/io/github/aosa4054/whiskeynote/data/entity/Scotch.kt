package io.github.aosa4054.whiskeynote.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity (tableName = "scotch_table")
data class Scotch(@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name = "entryid")
                  var id: Int, var name: String, var type: String,
                  var price: Int, var ml: Int, var fragrance: String?,
                  var taste: String?, var aftertaste: String?, var memo: String?)