package com.example.economizeapp_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.CasonaotenhaloginTitle.setOnClickListener {
            findNavController().navigate(R.id.fragment_sign_up)
        }
        val textView: TextView = view.findViewById(R.id.Esqueceusenha_title)


        textView.setOnClickListener {

            Toast.makeText(requireContext(), "Email para a troca de senha enviado", Toast.LENGTH_SHORT).show()
        }
        binding.Loginbutton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.senhaEditText.text.toString()

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