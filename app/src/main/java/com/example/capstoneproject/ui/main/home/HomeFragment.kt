package com.example.capstoneproject.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //lateinit var recyclerAdapter: ProductListAdapter
    //private lateinit var adapter: ProductRecyclerAdapter

    private lateinit var binding: FragmentHomeBinding
    private lateinit var senaAdapter: SenaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        binding.homeTextView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_shopFragment)
        }
        return binding.root

        //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        senaAdapter = SenaAdapter()
        binding.apply {
            productsRecyclerView.adapter = senaAdapter
            productsRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            //productsRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        }

      /*  binding.productsRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        //newRecyclerBinding = ProductListAdapter()
        adapter = ProductRecyclerAdapter()
        binding.productsRecyclerView.adapter =adapter*/

    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        viewModel.getRecyclerLiveDataObserver().observe(viewLifecycleOwner, Observer { productList ->

        if(productList != null){
            senaAdapter.differ.submitList(productList)
                /*newRecyclerBinding.setProductList(it)
                newRecyclerBinding.notifyDataSetChanged()*/
                //binding.productsRecyclerView
                //viewModel.setAdapterData(it)
            }else{
                Toast.makeText(context, "couldn't get list", Toast.LENGTH_LONG).show()
            }
        })
    }

}