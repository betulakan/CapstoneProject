package com.example.capstoneproject.ui.main.favorites

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.room.ProductFavDAOInterface
import com.example.capstoneproject.data.room.ProductFavEntity
import com.example.capstoneproject.data.room.ProductRoomDatabase

class FavoritesFragmentViewModel(context: Context): ViewModel() {

    private var _productFav = MutableLiveData<List<ProductFavEntity>>()
    val productFav: LiveData<List<ProductFavEntity>>
    get() = _productFav

    private val productFavDAOInterface: ProductFavDAOInterface? =
        ProductRoomDatabase.productFavDatabase(context)?.productFavDAOInterface()

    init{

    }

    fun getFavorites(){
    }

    fun deleteFromFavorites(productId: Int){
        productFavDAOInterface?.deleteProductWithId(productId)
    }
}