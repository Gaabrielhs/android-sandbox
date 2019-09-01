package com.example.androidsandbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserAdapter: ListAdapter<User, UserAdapter.ViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)

        holder.nomeLabel.text = user.nome
        holder.apelidoLabel.text = user.apelido
        holder.mItemView.tag = user
    }

    class ViewHolder(
        val mItemView: View
    ) : RecyclerView.ViewHolder(mItemView) {
        val apelidoLabel : TextView = mItemView.apelidoLabel
        val nomeLabel : TextView = mItemView.userLabel
    }
}

private class UserDiffCallback :DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}