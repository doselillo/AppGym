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
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var userViewModel: UserViewModel
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root = binding.root
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loginFragment = this@LoginFragment
        }

        // Buttons
        /*binding.apply {
            signUpButton.setOnClickListener {
                signUp()

            }
            logInButton.setOnClickListener {
                login()
            }

        }*/


    }


    fun signUp(){

        val email = emailLoginEdit.text.toString()
        if (emailLoginEdit.text.isNotEmpty() && passwordLoginEdit.text.isNotEmpty()){
            auth.createUserWithEmailAndPassword(
                emailLoginEdit.text.toString(), passwordLoginEdit.text.toString())
                .addOnCompleteListener { it ->

                if (it.isSuccessful){
                    showHome(email)



                }else{
                    Toast.makeText(requireContext(), "Email or password incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(requireContext(), "Fill all texts", Toast.LENGTH_SHORT).show()
        }
    }


    fun login() {
        val email = emailLoginEdit.text.toString()
        if (emailLoginEdit.text.isNotEmpty() && passwordLoginEdit.text.isNotEmpty()){
            auth.signInWithEmailAndPassword(
                email, passwordLoginEdit.text.toString()
            ).addOnCompleteListener { it ->

                if (it.isSuccessful){
                    showHome(email)


                }else{
                    Toast.makeText(requireContext(), "Email or password incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(requireContext(), "Fill all texts", Toast.LENGTH_SHORT).show()
        }
    }



    private fun showHome(email: String) {
        /*val bundle = bundleOf("email" to emailProfileEdit.toString())
        view.findNavController().navigate(R.id.action_loginFragment_to_menuFragment, bundle)*/

        /*val action = LoginFragmentDirections.actionLoginFragmentToMenuFragment(emailProfileEdit.toString())
        Navigation.findNavController(view).navigate(action)*/

        db.collection("users").document(email).set(hashMapOf("email" to email))


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