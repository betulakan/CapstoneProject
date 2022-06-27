/*
package com.example.capstoneproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.common.downloadImage
import com.example.capstoneproject.data.model.Products
import kotlinx.android.synthetic.main.product_list_row.view.*

class ProductListAdapter() :
    RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    private var productList: List<Products>? = null

    fun setProductList(productList: List<Products>?) {
        this.productList = productList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_row, parent, false)
        return MyViewHolder(view)
    }

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val layoutInflater = LayoutInflater.from(parent.context)

     }


    override fun onBindViewHolder(holder: ProductListAdapter.MyViewHolder, position: Int) {
        holder.bind(productList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (productList == null) return 0
        else return productList?.size!!
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage = view.productImage
        val productName = view.productName
        val productPrice = view.productPrice
        val productDescription = view.productDescription

        fun bind(data: Products) {
            productName.text = data.title
            productPrice.text = data.price
            productDescription.text = data.description

            productImage.downloadImage(data.image)

            //GlideToVectorYou.justLoadImage(fragment, Uri.parse(data.image), productImage)
        }
    }
}
*/
