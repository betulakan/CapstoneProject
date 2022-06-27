package com.example.capstoneproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.data.model.Products
import com.example.capstoneproject.databinding.DenemeProductRowBinding

class DenemeAdapter(val list: List<Products>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val denemeBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.deneme_product_row, parent, false)
        return ProductsViewHolder(denemeBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductsViewHolder).onBind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ProductsViewHolder(private val denemeBinding: ViewDataBinding)
        :RecyclerView.ViewHolder(denemeBinding.root){

        fun onBind(denemeModel: Products){
            val binding = denemeBinding as DenemeProductRowBinding
            binding.setVariable(BR.denemeModel, denemeModel)
        }
    }

}