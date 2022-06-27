package com.example.capstoneproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Products(
    @SerializedName("category") @Expose val category: String,
    @SerializedName("count") @Expose val count: String,
    @SerializedName("description") @Expose val description: String,
    @SerializedName("id") @Expose val id: String,
    @SerializedName("image") @Expose val image: String,
    @SerializedName("price") @Expose val price: String,
    @SerializedName("rate") @Expose val rate: String,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("user") @Expose val user: String
): Serializable

