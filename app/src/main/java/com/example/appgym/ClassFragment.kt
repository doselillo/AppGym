package com.example.appgym

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.appgym.databinding.FragmentClassBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_class.*

class ClasesFragment : Fragment() {

    private val args: ClasesFragmentArgs by navArgs()
    private var _binding: FragmentClassBinding? = null
    private val binding get() = _binding!!
    lateinit var email: String
   // private lateinit var cViewModel: ClassViewModel
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentClassBinding.inflate(inflater, container, false)
       // setReservationsC("classes", "reservationsC", "maxReservationsC")
       // setReservationsCc("classes", "reservationsCc", "maxReservationsCc")
        //cViewModel = ViewModelProvider(this).get(ClassViewModel::class.java)
        /*setReservationsC("BODY PUMP", "reservationsC", reservationsOneClassOneTextView)
        setReservationsC("BODY PUMP", "reservationsCc", reservationsTwoClassOneTextView)
        setReservationsC("BOXING", "reservationsC", reservationsOneClassTwoTextView)
        setReservationsC("BOXING", "reservationsCc", reservationsTwoClassTwoTextView)
        setReservationsC("YOGA", "reservationsC", reservationsOneClassThreeTextView)
        setReservationsC("YOGA", "reservationsCc", reservationsTwoClassThreeTextView)
        setReservationsC("PILATES", "reservationsC", reservationsOneClassFourTextView)
        setReservationsC("PILATES", "reservationsCc", reservationsTwoClassFourTextView)*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            clasesFragment = this@ClasesFragment
        }
        setReservationsC("BODY PUMP", "reservationsC", reservationsOneClassOneTextView)
        setReservationsC("BODY PUMP", "reservationsCc", reservationsTwoClassOneTextView)
        setReservationsC("BOXING", "reservationsC", reservationsOneClassTwoTextView)
        setReservationsC("BOXING", "reservationsCc", reservationsTwoClassTwoTextView)
        setReservationsC("YOGA", "reservationsC", reservationsOneClassThreeTextView)
        setReservationsC("YOGA", "reservationsCc", reservationsTwoClassThreeTextView)
        setReservationsC("PILATES", "reservationsC", reservationsOneClassFourTextView)
        setReservationsC("PILATES", "reservationsCc", reservationsTwoClassFourTextView)

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

    private fun resBO(view: CheckBox, classe: String , reserv: String) {


        when (view.isChecked) {
            true -> {
                db.collection("classes").document(classe)
                    .update(reserv, FieldValue.increment(-1))
            }

            false -> {
                db.collection("classes").document(classe)
                    .update(reserv, FieldValue.increment(1))
            }


        }

        /*when(!checkboxTwoClassOne.isChecked){
            true -> {
                db.collection("classes").document("BODY PUMP")
                    .update("reservationsCc", FieldValue.increment(-1))
            }

            false -> {
                db.collection("classes").document("BODY PUMP")
                    .update("reservationsCc", FieldValue.increment(1))
            }
        }*/


    }



    private fun showReservationsScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.error))
            .setMessage(getString(R.string.full_reservations))
            .setCancelable(true)
            .setNegativeButton(getString(R.string.exit_dialog)) { _, _ ->
            }

            .show()
    }

   /*** fun getReservations(doc: String, reservs: String, maxReservs: String, view: CheckBox, viewT: TextView){

        val classes = db.collection("classes")
        classes.document(doc).get().addOnSuccessListener{ result ->
            var res = (result.get(reservs) as Long?)
            var resMac = (result.get(maxReservs) as Long?)
            if(res!! < resMac!!){
                resBO(view, doc, reservs)

            }else{
                showReservationsScoreDialog()
                view.isChecked = false
            }
            viewT.text = (result.get(reservs) as Long?).toString()
            //reservationsTwoClassOneTextView.text = (result.get(reservs) as Long?).toString()

        }

        setReservationsC(doc, reservs, viewT)

    }***/
    fun getReservations(doc: String, reservs: String, maxReservs: String, view: CheckBox, viewT: TextView){

        val classes = db.collection("classes")
        classes.document(doc).get().addOnSuccessListener{ result ->
            var res = (result?.get(reservs) as Long?)
            var resMac = (result?.get(maxReservs) as Long?)
            if(res!! < resMac!!){
                resBO(view, doc, reservs)


            }else{
                showReservationsScoreDialog()
                view.isChecked = false
            }
            viewT.text = (result?.get(reservs) as Long?).toString()
            //reservationsTwoClassOneTextView.text = (result.get(reservs) as Long?).toString()

        }

        setReservationsC(doc, reservs, viewT)

    }

    fun setReservationsC(doc: String, reservs: String, viewF: TextView){
        val classes = db.collection("classes")
        classes.document(doc).get().addOnSuccessListener{result ->
            viewF.text = (result.get(reservs) as Long?).toString()
        }
    }
    fun setReservationsCc(doc: String, reservs: String, maxReservs: String){
        val classes = db.collection("classes")
        classes.document(doc).get().addOnSuccessListener{result ->
            reservationsTwoClassOneTextView.text = (result.get(reservs) as Long?).toString()
        }
    }
}








