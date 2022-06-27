package com.example.capstoneproject.data.retrofit

import com.example.capstoneproject.data.model.Products
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

public interface RetrofitInterface {

    @GET("get_products.php")
    fun getDataFromAPI(): Call<List<Products>>

    @POST("get_products_by_user.php")
    @FormUrlEncoded
    fun getProductsByUser(
        @Field("user") user: String,
    ): Call<List<Products>>

    @POST("get_bag_products_by_user.php")
    @FormUrlEncoded
    suspend fun getBagProductsByUser(
        @Field("user") user: String,
    ): Call<List<Products>>

    /*@POST("add_to_bag.php")
    @FormUrlEncoded
    fun addToBag(
        @Field("user") user: String,
        @Field("title") title: String,
        @Field("price") price: Double,
        @Field("description") description: String,
        @Field("category") category: String,
        @Field("image") image: String,
        @Field("rate") rate: Double,
        @Field("count") count: Int,
        @Field("sale_state") sale_state: Int,
    ): CRUDResponse*/
}