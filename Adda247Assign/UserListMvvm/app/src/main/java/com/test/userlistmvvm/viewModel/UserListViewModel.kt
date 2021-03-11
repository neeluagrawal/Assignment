package com.test.userlistmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.test.userlistmvvm.model.ListResponse
import com.test.userlistmvvm.repository.UserListRepository

class UserListViewModel(application: Application) : AndroidViewModel(application) {
    private var bookRepository: UserListRepository? = null
    var volumesResponseLiveData: LiveData<ListResponse>? = null
        private set

    /*
    * init view model object
    * */
    fun init() {
        bookRepository = UserListRepository()
        volumesResponseLiveData = bookRepository!!.getUserListResponseLiveData()
    }

}