package uz.it_school.zakovatclubapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.it_school.zakovatclubapp.R
import uz.it_school.zakovatclubapp.model.room.entities.GroupEntity

class GroupAdpter: RecyclerView.Adapter<GroupAdpter.Holder>() {
    private val data: MutableList<GroupEntity> = ArrayList()
    private var onClickListener:((GroupEntity)->Unit)? = null
    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(newItems: List<GroupEntity>) {
        data.clear()
        data.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_group, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun onClick(l:(GroupEntity)->Unit) {
        onClickListener=l
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.text_name_group)

        fun bind(postion: Int) {
            val item: GroupEntity = data[postion]
            name.text = item.name

        }

        init {
            itemView.setOnClickListener {
                onClickListener?.invoke(
                    data[adapterPosition]
                )
            }
        }
    }
}
