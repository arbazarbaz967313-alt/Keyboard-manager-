
package com.quickclipboard.adapter

import android.content.*
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.quickclipboard.R
import com.quickclipboard.database.ClipboardItem

class ClipboardAdapter(
 private val list: MutableList<ClipboardItem>,
 private val context: Context
):RecyclerView.Adapter<ClipboardAdapter.VH>(){

 class VH(v:View):RecyclerView.ViewHolder(v){
  val text:TextView=v.findViewById(R.id.text)
 }

 override fun onCreateViewHolder(p:ViewGroup,v:Int)=VH(LayoutInflater.from(p.context).inflate(R.layout.item_clipboard,p,false))
 override fun getItemCount()=list.size

 override fun onBindViewHolder(h:VH,i:Int){
  val item=list[i]
  h.text.text=item.text

  h.itemView.setOnClickListener{
   val cm=context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
   cm.setPrimaryClip(ClipData.newPlainText("",item.text))
   Toast.makeText(context,"Copied",Toast.LENGTH_SHORT).show()
  }
 }
}
