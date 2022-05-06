package com.example.appgym

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.appgym.databinding.FragmentClassBinding
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_class.*

class ClasesFragment : Fragment() {

    private val args: ClasesFragmentArgs by navArgs()
    private var _binding: FragmentClassBinding? = null
    private val binding get() = _binding!!
    lateinit var email: String
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentClassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            clasesFragment = this@ClasesFragment
        }


        /*binding.checkboxOneClassOne.setOnClickListener {
            db.collection("classes").document("BODY PUMP")
                .update("reservationsC", FieldValue.increment(1))
        }*/


    }

   /* private fun makeReservation(email: String?, classes: String) {

        binding.checkboxOneClassOne.setOnClickListener {
            db.collection("classes").document("BODY PUMP")
                .update("reservationC", FieldValue.increment(1))
        }
        db.collection("classes").document(classes).get().addOnSuccessListener {
            binding.capacityOneClassOneTextView.setText(it.get("reservationsC") as Int)
        }
    }*/

    fun resBO(){


            /*var control = 1
            if(control == 1){
                db.collection("classes").document("BODY PUMP")
                    .update("reservationsC", FieldValue.increment(1))
                control-=1
                Toast.makeText(requireContext(), "mas 1", Toast.LENGTH_SHORT).show()
            }else if(control == 0){
                db.collection("classes").document("BODY PUMP")
                    .update("reservationsC", FieldValue.increment(-1))
                control+=1
                Toast.makeText(requireContext(), "menos 1", Toast.LENGTH_SHORT).show()
            }*/

        when(!checkboxTwoClassOne.isChecked){
            true -> {db.collection("classes").document("BODY PUMP")
                .update("reservationsC", FieldValue.increment(-1))

                    Toast.makeText(requireContext(), "menos 1", Toast.LENGTH_SHORT).show()}
            false -> {
                db.collection("classes").document("BODY PUMP")
                    .update("reservationsC", FieldValue.increment(1))

                Toast.makeText(requireContext(), "mas 1", Toast.LENGTH_SHORT).show()}
            }
        }
       // Toast.makeText(requireContext(), "$control", Toast.LENGTH_LONG).show()

    }








