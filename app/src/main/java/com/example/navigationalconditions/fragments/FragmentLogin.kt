package com.example.navigationalconditions.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import com.example.navigationalconditions.databinding.FragmentLoginBinding
import com.example.navigationalconditions.models.User
import com.example.navigationalconditions.models.UserSession

class FragmentLogin : Fragment() {

    private var binding: FragmentLoginBinding? = null

    private lateinit var savedStateHandle: SavedStateHandle

    private fun initializations() {
        savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializations()
        handleBackPress()

        binding?.btnLoginLogin?.setOnClickListener { onButtonClick() }
    }

    private fun handleBackPress() {
        savedStateHandle[IS_LOGIN] = false
    }

    private fun onButtonClick() {
        // Updating Value to Session
        UserSession.user = User(
            binding?.etEmailLogin?.text.toString(),
            binding?.etPasswordLogin?.text.toString(),
        )
        savedStateHandle[IS_LOGIN] = true

        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val IS_LOGIN = "isLogin"
    }
}