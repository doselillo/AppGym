package com.example.appgym

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.appgym.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

enum class ProviderType{
    BASIC
}

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

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.loginFragment) {
                topAppBar.visibility = View.GONE
            } else {
                topAppBar.visibility = View.VISIBLE
            }
        }


        //toolbar logic
        binding.topAppBar.apply {

            //tome button
            setNavigationOnClickListener {

                //navigates to menu fragment
                navController.navigate(R.id.menuFragment)

            }

            //other buttons
            setOnMenuItemClickListener {
                    menuItem ->

                when (menuItem.itemId) {

                    //when phone button call number
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

    private fun dialPhone(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }




}
