package com.example.capstoneproject.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup,container,false)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonSignUp.setOnClickListener {
            val name = binding.textInputEditText.text.toString()
            val email = binding.textEmail.text.toString()
            val password = binding.textPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(context,"User registeres",Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
                    }else{
                        Toast.makeText(context, it.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(context, "Empty fields are not allowed!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.textButtonSignup.setOnClickListener{
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.textButtonSignup.setOnClickListener{
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        binding.buttonSignUp.setOnClickListener{
            Toast.makeText(context,"kaydoldu",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }*/
    }

}