package com.example.navigationalconditions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.navigationalconditions.R
import com.example.navigationalconditions.databinding.FragmentProfileBinding
import com.example.navigationalconditions.models.UserSession

class FragmentProfile : Fragment() {

    private var binding: FragmentProfileBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentBackStackEntry = findNavController().currentBackStackEntry
        val savedStateHandle = currentBackStackEntry!!.savedStateHandle
        val liveData = savedStateHandle.getLiveData<Boolean>(FragmentLogin.IS_LOGIN)
        liveData.observe(currentBackStackEntry) {
            if (!it) {

                val startDestinationId = findNavController().graph.startDestinationId

                val navOptions = NavOptions.Builder()
                    .setPopUpTo(startDestinationId, true)
                    .setEnterAnim(R.anim.slide_in_right)
                    .setExitAnim(R.anim.slide_out_left)
                    .setPopEnterAnim(R.anim.slide_in_left)
                    .setPopExitAnim(R.anim.slide_out_right)
                    .build()

                findNavController().navigate(startDestinationId, null, navOptions)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (UserSession.user == null) {
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
            findNavController().navigate(R.id.fragmentLogin, null, navOptions)
        } else {
            binding?.tvTitleProfile?.text =
                getString(R.string.welcome_back_s, UserSession.user!!.username)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}