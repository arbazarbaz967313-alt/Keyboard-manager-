
package com.quickclipboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.quickclipboard.adapter.ClipboardAdapter
import com.quickclipboard.database.*

class ClipboardHistoryActivity: AppCompatActivity(){

 lateinit var db:ClipboardDatabase

 override fun onCreate(s:Bundle?){
  super.onCreate(s)
  setContentView(R.layout.activity_history)

  db=Room.databaseBuilder(this,ClipboardDatabase::class.java,"clip.db").build()

  recyclerView.layoutManager=LinearLayoutManager(this)

  Thread{
   val list=db.dao().getAll()
   runOnUiThread{
    recyclerView.adapter=ClipboardAdapter(list.toMutableList(),this)
   }
  }.start()
 }
}
