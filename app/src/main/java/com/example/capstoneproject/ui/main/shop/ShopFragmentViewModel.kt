package com.example.capstoneproject.ui.main.shop

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.model.Products
import com.example.capstoneproject.data.retrofit.RetrofitInstance
import com.example.capstoneproject.data.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopFragmentViewModel: ViewModel() {
    var error = MutableLiveData<String>()
    var liveDataList = MutableLiveData<List<Products>?>()

    init{
        makeAPICall()
    }

    fun getRecyclerLiveDataObserver(): MutableLiveData<List<Products>?> {
        return liveDataList
    }

    fun makeAPICall(){
        val retrofitInstance = RetrofitInstance.getRetrofitInstance()
        val retrofitService = retrofitInstance.create(RetrofitInterface::class.java)
        val callBetul = retrofitService.getProductsByUser("betul")
        callBetul.enqueue(object : Callback<List<Products>> {
            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                error.postValue(t.message)
            }
            override fun onResponse(
                call: Call<List<Products>>,
                response: Response<List<Products>>
            ) {
                liveDataList.postValue(response.body())
            }
        })
    }
}