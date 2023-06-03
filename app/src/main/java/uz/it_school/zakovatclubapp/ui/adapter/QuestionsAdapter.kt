package uz.it_school.zakovatclubapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.it_school.zakovatclubapp.R
import uz.it_school.zakovatclubapp.model.room.entities.QuestionEntity


class QuestionsAdapter: RecyclerView.Adapter<QuestionsAdapter.Holder>() {
    private val data: MutableList<QuestionEntity> = ArrayList()
    private var onClickListener:((QuestionEntity)->Unit)? = null
    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(newItems: List<QuestionEntity>) {
        data.clear()
        data.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun onClick(l:(QuestionEntity)->Unit) {
        onClickListener=l
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.text_question_name)

        fun bind(postion: Int) {

            name.text = "${postion+1}-question"

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
