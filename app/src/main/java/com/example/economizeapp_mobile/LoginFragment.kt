package com.example.economizeapp_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.economizeapp_mobile.databinding.FragmentHomeBinding
import com.example.economizeapp_mobile.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            findNavController().navigate(R.id.fragment_login)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.CasonaotenhaloginTitle.setOnClickListener {
            findNavController().navigate(R.id.fragment_sign_up)
        }
        val textView: TextView = view.findViewById(R.id.Esqueceusenha_title)

        binding.Loginbutton.setOnClickListener {
            doLogin()
        }
    }

    private fun doLogin() = lifecycleScope.launch {
        val email = binding.emailEditText.text.toString()
        val password = binding.senhaEditText.text.toString()

        try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val currentUser = result.user

            if (currentUser != null) {
                Toast.makeText(
                    requireContext(),
                    "Olá ${currentUser.displayName}!",
                    Toast.LENGTH_LONG
                ).show()
                findNavController().navigate(R.id.fragment_sign_up)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Não foi possível fazer o login",
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}