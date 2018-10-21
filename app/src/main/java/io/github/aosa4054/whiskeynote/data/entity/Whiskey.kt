package io.github.aosa4054.whiskeynote.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "whiskey_table")
data class Whiskey(@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name = "entryid")
                  var id: Int, var kind: String, var name: String, var type: String,
                  var price: String, var ml: String, var fragrance: String?,
                  var taste: String?, var aftertaste: String?, var memo: String?)