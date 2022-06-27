package com.example.capstoneproject.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductFavDAOInterface {

    @Insert
    fun addProductToFav(productFavEntity: ProductFavEntity)

    @Query("SELECT * FROM productfavdatabase")
    fun getProductFav(): List<ProductFavEntity>?

    @Query("DELETE FROM productfavdatabase WHERE id =:idInput")
    fun deleteProductWithId(idInput: Int)

    @Query("DELETE FROM productfavdatabase")
    fun clearFav()
}