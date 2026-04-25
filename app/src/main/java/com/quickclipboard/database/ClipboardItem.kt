
package com.quickclipboard.database
import androidx.room.*

@Entity
data class ClipboardItem(
 @PrimaryKey(autoGenerate=true) val id:Int=0,
 val text:String,
 val timestamp:Long
)
