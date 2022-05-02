package com.example.appgym

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appgym.data.User
import com.example.appgym.data.UserViewModel
import com.example.appgym.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var userViewModel: UserViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root = binding.root
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        binding.apply {
            signUpButton.setOnClickListener {
                signUp()

            }
            logInButton.setOnClickListener {
                login()
            }

        }

        return root
    }

    private fun login() {
        if (emailLoginEdit.text.isNotEmpty() && passwordLoginEdit.text.isNotEmpty()){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                emailLoginEdit.text.toString(), passwordLoginEdit.text.toString()
            ).addOnCompleteListener {

                if (it.isSuccessful){
                    showHome(it.result?.user?.email?: "", ProviderType.BASIC)
                    findNavController().navigate(R.id.action_loginFragment_to_menuFragment)


                }else{
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }



    private fun signUp(){
        if (emailLoginEdit.text.isNotEmpty() && passwordLoginEdit.text.isNotEmpty()){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                emailLoginEdit.text.toString(), passwordLoginEdit.text.toString()
            ).addOnCompleteListener {

                if (it.isSuccessful){
                    showHome(it.result?.user?.email?: "", ProviderType.BASIC)
                    findNavController().navigate(R.id.action_loginFragment_to_menuFragment)


                }else{
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun showHome(email: String, provider: ProviderType) {
        findNavController().navigate(R.id.action_loginFragment_to_menuFragment)

        }


    private fun insertDataToDatabase() {
        val email = emailLoginEdit.text.toString()
        val password = passwordLoginEdit.text.toString()


            //Create User Object
            val user = User(0, "", "", "", "", "", "", email, password)
            //Add Data to Database
            userViewModel.addUser(user)



    }


}