package com.example.a29api
import com.example.a29api.databinding.ItemUserBinding
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
class UsersAdapter(private val list: ArrayList<UserItem>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            tvName.text = item.name
            tvEmail.text = item.email
            tvUserNameText.text = item.username
        }

    }

    override fun getItemCount(): Int = list.size
}