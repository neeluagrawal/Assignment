package com.test.userlistmvvm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.userlistmvvm.R
import com.test.userlistmvvm.model.DataResponse
import java.util.*

class UserListResultsAdapter : RecyclerView.Adapter<UserListResultsAdapter.UserListResultHolder>() {
    private var results: List<DataResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListResultHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_row, parent, false)
        return UserListResultHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserListResultHolder, position: Int) {
        val data = results[position]
        holder.nameTextView.text = "Name: ${data.name}"
        holder.emailTextView.text = "Email: ${data.email}"
        holder.genderTextView.text = "Gender: ${data.gender}"
        holder.statusTextView.text = "Status: ${data.status}"
    }

    override fun getItemCount(): Int {
        return results.size
    }

    fun setResults(results: List<DataResponse>) {
        this.results = results
        notifyDataSetChanged()
    }

    inner class UserListResultHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tv_name)
        val emailTextView: TextView = itemView.findViewById(R.id.tv_email)
        val genderTextView: TextView = itemView.findViewById(R.id.tv_gender)
        val statusTextView: TextView = itemView.findViewById(R.id.tv_status)

    }
}