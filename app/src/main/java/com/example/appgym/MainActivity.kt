package com.example.appgym

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.appgym.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        //setupActionBarWithNavController(navController)
        //setupActionBarWithNavController(findNavController(R.id.fragment))



        binding.topAppBar.apply {

            setNavigationOnClickListener {
                dialPhone("123456789")
                ///////////////////////////////////////////////////////////
                //no conseguimos que viaje al home fragment


            }

            setOnMenuItemClickListener {
                    menuItem ->

                when (menuItem.itemId) {
                    R.id.contactIcon -> {
                        dialPhone("123456789")
                        true
                    }
                    else -> false
                }
            }

        }

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun dialPhone(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }




}
