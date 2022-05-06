package com.example.appgym

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.appgym.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    //val args: MenuFragmentArgs by navArgs()
    private val args: MenuFragmentArgs by navArgs()
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    lateinit var email: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            menuFragment = this@MenuFragment
            email = args.email.toString()
        }


    }

    fun goToNextScreen(num: Int, email: String){
        when(num){
            1 -> {val action = MenuFragmentDirections.actionMenuFragmentToClassFragment(email)
                findNavController().navigate(action)}

                //findNavController().navigate(R.id.action_menuFragment_to_classFragment)
            2 -> {val action = MenuFragmentDirections.actionMenuFragmentToCompetitionsFragment(email)
                findNavController().navigate(action)}

                //findNavController().navigate(R.id.action_menuFragment_to_competitionsFragment)
            3 -> { val action = MenuFragmentDirections.actionMenuFragmentToProfileFragment(email)
                findNavController().navigate(action) }
        }
    }

}