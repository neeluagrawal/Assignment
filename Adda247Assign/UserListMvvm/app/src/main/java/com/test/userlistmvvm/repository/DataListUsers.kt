package com.test.userlistmvvm.repository

import com.test.userlistmvvm.model.ListResponse
import retrofit2.Call
import retrofit2.http.GET

/*
* interface to fetch the list of data
* */
interface DataListUsers {
    @GET("/public-api/users")
    fun getUserList(): Call<ListResponse?>?
}