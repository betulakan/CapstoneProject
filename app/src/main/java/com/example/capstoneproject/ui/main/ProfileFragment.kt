package com.example.capstoneproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstoneproject.BR
import com.example.capstoneproject.DenemeAdapter
import com.example.capstoneproject.R
import com.example.capstoneproject.data.model.Products
import com.example.capstoneproject.databinding.DenemeProductRowBinding
import com.example.capstoneproject.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var dataBinding: FragmentProfileBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        firebaseAuth = FirebaseAuth.getInstance()
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        dataBinding.logOut.setOnClickListener{
            firebaseAuth.signOut();
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }

        return dataBinding.root
    }


}