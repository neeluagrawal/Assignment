package com.test.userlistmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("gender")
    @Expose
    val gender: String,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("created_at")
    @Expose
    val createdAt: String,
    @SerializedName("updated_at")
    @Expose
    val updatedAt: String
) {}