package com.test.userlistmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.userlistmvvm.model.ListResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserListRepository {

    private val dataListUsers: DataListUsers
    private val userListResponse: MutableLiveData<ListResponse> = MutableLiveData()

    /*
    * get list of user data from api
    * */
    private fun listUsers() {
        dataListUsers.getUserList()!!.enqueue(object : Callback<ListResponse?> {
                override fun onResponse(call: Call<ListResponse?>?, response: Response<ListResponse?>) {
                    if (response.body() != null) {
                        userListResponse.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ListResponse?>?, t: Throwable?) {
                    userListResponse.postValue(null)
                }
            })
    }

    /*
    * return list of users
    * */
    fun getUserListResponseLiveData(): LiveData<ListResponse> {
        listUsers()
        return userListResponse
    }

    companion object {
        private const val BASE_URL = "https://gorest.co.in/"
    }

    /*
    * init http client object to call api
    * */
    init {
        val interceptor = HttpLoggingInterceptor()
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        dataListUsers = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataListUsers::class.java)
    }
}