package com.example.capstoneproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        /*val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.shopFragment,
                R.id.cartFragment,
                R.id.favoritesFragment,
                R.id.profileFragment
            )
        )*/
        setupWithNavController(bottomNavigationView, navController)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            if(destination.id == R.id.signupFragment){
                bottomNavigationView.visibility= View.GONE
            } else if(destination.id == R.id.loginFragment){
                bottomNavigationView.visibility = View.GONE
            } else if(destination.id == R.id.forgotPasswordFragment){
                bottomNavigationView.visibility = View.GONE
            } else{
                bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }


}