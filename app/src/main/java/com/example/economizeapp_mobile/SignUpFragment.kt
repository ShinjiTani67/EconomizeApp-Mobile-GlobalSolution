package com.example.economizeapp_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.economizeapp_mobile.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.confirmarbtn.setOnClickListener {
            val nome = binding.nomeEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val confirmaemail = binding.confrimaemailedittext.text.toString()
            val senha = binding.senhaEditText.text.toString()
            val confirmasenha = binding.confirmaSenhaEditText.text.toString()


            //when {
              //  nome.isEmpty() -> showMessage("O nome é obrigatório!", true)
                //email.isEmpty() -> showMessage("O e-mail é obrigatório!", true)
                //!isValidEmail(email) -> showMessage("Por favor, insira um e-mail válido!", true)
                //senha.isEmpty() -> showMessage("A senha é obrigatória!", true)
                //senha.length < 6 -> showMessage("A senha deve ter no mínimo 6 caracteres!", true)
                //senha != confirmPassword -> showMessage("As senhas não coincidem!", true)
                //else -> {


                    //showMessage("Cadastro realizado com sucesso!", false)
                }
            }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}