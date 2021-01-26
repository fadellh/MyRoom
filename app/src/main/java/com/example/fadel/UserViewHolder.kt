package com.example.fadel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Constraints
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fadel.data.entity.UserEntity

class UserViewHolder : RecyclerView.Adapter<UserViewHolder.ListViewHolder>() {

    inner class ListViewHolder(item : View) : RecyclerView.ViewHolder(item)
    private var userList = emptyList<UserEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false))
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.tvId).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.tvFirstName).text = currentItem.firstName
        holder.itemView.findViewById<TextView>(R.id.tvLast).text = currentItem.lastName
        holder.itemView.findViewById<TextView>(R.id.tvAge).text = currentItem.age.toString()
        val layout = holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout)

        layout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)//current item means what data will you pass
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(user: List<UserEntity>) {
        this.userList = user
        notifyDataSetChanged()
    }
}