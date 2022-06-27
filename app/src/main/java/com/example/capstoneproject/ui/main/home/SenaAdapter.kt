package com.example.capstoneproject.ui.main.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.common.downloadImage
import com.example.capstoneproject.data.model.Products
import com.example.capstoneproject.databinding.ProductListRowBinding

class SenaAdapter() :
    RecyclerView.Adapter<SenaAdapter.ItemVH>() {

    class ItemVH(val binding: ProductListRowBinding) : RecyclerView.ViewHolder(binding.root)
    //differ, fragmentta set etmeyi kolaylaştırıyor, rv da değişen itemı değiştiriyor
    private val differCallBack = object : DiffUtil.ItemCallback<Products>() {
        override fun areItemsTheSame(
            oldItem: Products,
            newItem: Products
        ): Boolean {
            return true
        }

        override fun areContentsTheSame(
            oldItem: Products,
            newItem: Products
        ): Boolean {
            return true
        }
    }
    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val binding =
            ProductListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemVH(binding)
    }
    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val product = differ.currentList[position]
        holder.binding.apply {
            product.image.let { image ->
                productImage.downloadImage(image)
            }
            productName.text = product.title
            productPrice.text = product.price
            productDescription.text = product.description
        }
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
            // nav args custom serializable
            //go to product description
        }
        holder.binding.addToCart.setOnClickListener {
            Log.v("cart","added to cart")
        }
        holder.binding.favoritesCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
               Log.v("fav","added to favorites")
            }else{
                Log.v("fav","removed from favorites")
            }
        }
    }

    override fun getItemCount(): Int {
        if (differ.currentList.size>10){
            return 10
        }
        return differ.currentList.size
    }
}