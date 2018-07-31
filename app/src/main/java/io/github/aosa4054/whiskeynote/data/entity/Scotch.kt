package io.github.aosa4054.whiskeynote.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull

@Entity (tableName = "scotch_table")
data class Scotch(@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name = "entryid")
                  var id: Int, var name: String, var type: String,
                  var price: Int, var ml: Int, var fragrance: String?,
                  var taste: String?, var aftertaste: String?, var memo: String?)