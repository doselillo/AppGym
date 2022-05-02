package com.example.appgym

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appgym.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    //val args: MenuFragmentArgs by navArgs()
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root = binding.root
        //val email = args.email
        //menuClassText.text = email
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            menuFragment = this@MenuFragment
        }
    }

    fun goToNextScreen(num: Int){
        when(num){
            1 -> findNavController().navigate(R.id.action_menuFragment_to_classFragment)
            2 -> findNavController().navigate(R.id.action_menuFragment_to_competitionsFragment)
            3 -> findNavController().navigate(R.id.action_menuFragment_to_profileFragment)
        }
    }

}