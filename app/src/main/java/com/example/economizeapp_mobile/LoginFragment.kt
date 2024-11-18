package com.example.economizeapp_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.economizeapp_mobile.databinding.FragmentHomeBinding
import com.example.economizeapp_mobile.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.Loginbutton.setOnClickListener {
            val email = binding.Emailedittext.text.toString()
            val password = binding.senhaedittext.text.toString()

            // validação feita pelo firebase


            //if (email.isEmpty() || password.isEmpty()) {
              //  binding.errorTextView.text = "E-mail e senha são obrigatórios!"
                //binding.errorTextView.visibility = View.VISIBLE
            //} else if (!isValidEmail(email)) {
              //  binding.errorTextView.text = "E-mail inválido!"
                //binding.errorTextView.visibility = View.VISIBLE
            //} else {
                //binding.errorTextView.visibility = View.GONE
                //performLogin(email, password)
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}