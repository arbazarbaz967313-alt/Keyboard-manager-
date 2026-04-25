
package com.quickclipboard.database
import androidx.room.*

@Dao
interface ClipboardDao{
 @Insert suspend fun insert(item:ClipboardItem)

 @Query("SELECT * FROM ClipboardItem ORDER BY timestamp DESC")
 fun getAll():List<ClipboardItem>
}
