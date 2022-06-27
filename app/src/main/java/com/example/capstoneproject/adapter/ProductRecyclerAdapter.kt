package com.example.capstoneproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.common.downloadImage
import com.example.capstoneproject.data.model.Products
import com.example.capstoneproject.databinding.ProductListRowBinding

class ProductRecyclerAdapter:
    RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>() {

    private var productList = ArrayList<Products>()

    fun setDataList(data : ArrayList<Products>){
        this.productList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductListRowBinding.inflate(inflater,parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.binding.apply{
            productName.text = product.title
            productPrice.text = product.price
            productDescription.text = product.description
            productImage.downloadImage(product.image)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
    class ProductViewHolder(val binding: ProductListRowBinding):
            RecyclerView.ViewHolder(binding.root)


}