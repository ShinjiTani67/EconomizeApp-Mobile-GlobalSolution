package com.example.economizeapp_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.economizeapp_mobile.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SignUpFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.confirmarbtn.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
        val name = binding.nomeEditText.text.toString()
        val email = binding.nomeEditText.text.toString()
        val password = binding.senhaEditText.text.toString()

        lifecycleScope.launch {
            try {
                val result = auth.createUserWithEmailAndPassword(email, password).await()
                val currentUser = result.user

                if (currentUser != null) {
                    val profileRequest = userProfileChangeRequest {
                        displayName = name
                    }
                    currentUser.updateProfile(profileRequest).await()
                    findNavController().navigate(R.id.fragment_home)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "Não foi possível criar sua conta",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (ex: Exception) {
                Toast.makeText(
                    requireContext(),
                    ex.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}