package com.test.userlistmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.userlistmvvm.adapter.UserListResultsAdapter
import com.test.userlistmvvm.model.ListResponse
import com.test.userlistmvvm.viewModel.UserListViewModel


class MainActivity : AppCompatActivity() {
    private var viewModel: UserListViewModel? = null
    private var adapter: UserListResultsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rv_List)
        adapter = UserListResultsAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
        viewModel!!.init()
        viewModel!!.volumesResponseLiveData!!.observe(
            this,
            Observer<ListResponse> { userListResponse ->
                if (userListResponse != null) {
                    adapter!!.setResults(userListResponse.data)
                }
            })

    }
}