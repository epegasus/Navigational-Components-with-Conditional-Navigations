package com.example.navigationalconditions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationalconditions.R
import com.example.navigationalconditions.databinding.FragmentIntroBinding

class FragmentIntro : Fragment() {

    private var binding: FragmentIntroBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentIntroBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnContinueIntro?.setOnClickListener { onContinueClick() }
    }

    private fun onContinueClick() {
        findNavController().navigate(R.id.action_fragmentIntro_to_fragmentProfile)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}