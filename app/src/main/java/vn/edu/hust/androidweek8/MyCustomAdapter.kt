package vn.edu.hust.androidweek8

import android.content.Context
import android.view.*
import android.view.View.OnLongClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class MyCustomAdapter(private val items: ArrayList<ItemModel>, val context: Context) :
    RecyclerView.Adapter<MyCustomAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(p0.context)
            .inflate(R.layout.custom_item, p0, false)
        return RecyclerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewHolder, p0: Int) {
        viewHolder.name.text = items[p0].name
        viewHolder.itemAvatar.text = items[p0].name[0].toString().uppercase()


        viewHolder.setItemClickListener(object : ItemClickListener {

            override fun onClick(view: View?, position: Int, isLongClick: Boolean) {
                val params: Bundle = Bundle()
                params.putString("NAME", items[position].name)
                params.putString("PHONE_NUMBER", items[position].phoneNumber)
                params.putString("GMAIL", items[position].gmail)
                view?.findNavController()?.navigate(R.id.action_listFragment_to_itemFragment, params)

                Toast.makeText(context, "click item" + items[position].name, Toast.LENGTH_SHORT)
                    .show()

            }
        })
    }


    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, OnLongClickListener {
        val name: TextView = itemView.findViewById(R.id.item_title)
        val itemAvatar: TextView = itemView.findViewById(R.id.item_avatar)
        private var itemClickListener: ItemClickListener? = null

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        fun setItemClickListener(itemClickListener: ItemClickListener?) {
            this.itemClickListener = itemClickListener
        }

        override fun onClick(v: View) {
            itemClickListener?.onClick(v, adapterPosition, false)
        }

        override fun onLongClick(v: View): Boolean {
            itemClickListener?.onClick(v, adapterPosition, true)
            return true
        }


    }
}