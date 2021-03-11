package com.test.userlistmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.test.userlistmvvm.model.DataResponse

data class ListResponse(@SerializedName("code")
                        @Expose
                        val code:String,
                        @SerializedName("data")
                        @Expose
                        val data :List<DataResponse>) {
}