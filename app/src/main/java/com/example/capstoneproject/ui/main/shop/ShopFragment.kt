package com.example.capstoneproject.ui.main.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstoneproject.databinding.FragmentShopBinding

class ShopFragment : Fragment() {

    private lateinit var binding: FragmentShopBinding
    private lateinit var shopAdapter: ShopAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShopBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        shopAdapter = ShopAdapter()
        binding.apply {
            shopRecyclerView.adapter = shopAdapter
            //grid layout manager 2 tane

            shopRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        }

    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(ShopFragmentViewModel::class.java)
        viewModel.getRecyclerLiveDataObserver()
            .observe(viewLifecycleOwner, Observer { productList ->

                if (productList != null) {
                    shopAdapter.differ.submitList(productList)
                } else {
                    Toast.makeText(context, "couldn't get list", Toast.LENGTH_LONG).show()
                }
            })
    }

}