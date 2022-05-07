package com.example.appgym

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.appgym.data.UserViewModel
import com.example.appgym.databinding.FragmentProfileBinding
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_profile.*


class PerfilFragment : Fragment() {


    private val args: PerfilFragmentArgs by navArgs()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var userViewModel: UserViewModel
    private val db = FirebaseFirestore.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_profile, container, false)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root = binding.root

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.saveProfilebutton.setOnClickListener {
            insertDataToDatabase()
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            perfilFragment = this@PerfilFragment
            emailProfileText.text = args.email
            loadData(args.email.toString())

        }

    }

   private fun insertDataToDatabase() {

       val users = db.collection("users")

       val updateU = hashMapOf(
           "name" to nameProfileEdit.text.toString(),
           "surname" to surnameProfileEdit.text.toString(),
           "dob" to dobProfileEdit.text.toString(),
           "sex" to checkRadioButton(),
           "height" to heightProfileEdit.text.toString(),
           "weight" to weightProfileEdit.text.toString(),
           "phone" to phoneProfileEdit.text.toString()
       )
       users.document(args.email.toString()).set(updateU)

        /*val name = nameProfileEdit.text.toString()
        val surname = surnameProfileEdit.text.toString()
        val dob = dobProfileEdit.text.toString()
        val sex = checkRadioButton()
        val height = heightProfileEdit.text.toString()
        val weight = weightProfileEdit.text.toString()
        val phone = phoneProfileEdit.text.toString()

        if(inputCheck(name, surname, dob, sex, height, weight, phone)){
            //Create User Object
            val user = User(0, name, surname, dob, sex, height, weight, args.email , phone)
            //Add Data to Database
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Succesfully saved!", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }*/



    }

    private fun loadData(email: String){
        if (email != null) {
            db.collection("users").document(email).get().addOnSuccessListener {
                nameProfileEdit.setText(it.get("name") as String?)
                surnameProfileEdit.setText(it.get("surname") as String?)
                dobProfileEdit.setText(it.get("dob") as String?)
                setRadioGroup(it)
                heightProfileEdit.setText(it.get("height") as String?)
                weightProfileEdit.setText(it.get("weight") as String?)
                phoneProfileEdit.setText(it.get("phone") as String?)

            }

        }
    }

    private fun inputCheck(name: String, surname: String, dob: String, sex: String, height: String, weight: String, phone: String): Boolean {
            return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(surname) && TextUtils.isEmpty(dob) && TextUtils.isEmpty(sex) && TextUtils.isEmpty(height) && TextUtils.isEmpty(weight)  && TextUtils.isEmpty(phone))
    }

    private fun setRadioGroup(it: DocumentSnapshot){
        val radiobutton = (it.get("sex") as String?)
        if (radiobutton == "female"){
            femaleRadioButton.isChecked = true
        } else if(radiobutton == "male"){
            maleRadioButton.isChecked = true
        }
    }

    private fun checkRadioButton(): String{
        return when {
            maleRadioButton.isChecked -> {
                "male"
            }
            femaleRadioButton.isChecked -> {
                "female"
            }
            else -> {
                ""
            }
        }
    }
}