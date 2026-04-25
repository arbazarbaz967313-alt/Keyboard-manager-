
package com.quickclipboard.database
import androidx.room.*

@Database(entities=[ClipboardItem::class],version=1)
abstract class ClipboardDatabase:RoomDatabase(){
 abstract fun dao():ClipboardDao
}
