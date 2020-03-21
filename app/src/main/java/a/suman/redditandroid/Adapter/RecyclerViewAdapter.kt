package a.suman.redditandroid.Adapter

import a.suman.redditandroid.Data.Local.RedTable
import a.suman.redditandroid.R
import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class RecyclerViewAdapter(var onClickRed: onClickRed) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>(){

    private var list:List<RedTable> = emptyList()
    var context: Context? = null
    inner class RecyclerViewHolder(view:View):RecyclerView.ViewHolder(view){
        val imageview=view.findViewById<ImageView>(R.id.imageView2)
        val title= view.findViewById<TextView>(R.id.title)
        val desc = view.findViewById<TextView>(R.id.desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        this.context=parent.context
        return RecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.title.text=list[position].title
        holder.desc.text=list[position].selftext
        Glide.with(context!!).load(list[position].thumbnail).placeholder(R.drawable.placeholder).into(holder.imageview)
        holder.itemView.setOnClickListener {
            onClickRed.onRedClick(list[position].url)
        }

    }

    fun setData(list:List<RedTable>){
        this.list=list
        notifyDataSetChanged()
    }

}

interface onClickRed{
    fun onRedClick(url:String)
}