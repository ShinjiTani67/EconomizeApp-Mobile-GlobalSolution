package com.example.economizeapp_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.economizeapp_mobile.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.enviarbtn.setOnClickListener {

            val kwhEditText = binding.gastosEditText.text.toString().trim()
            val gastosEditText = binding.pagoEditText.text.toString().trim()

            if (kwhEditText.isEmpty() || gastosEditText.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor, preencha ambos os campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {

                val kwh = kwhEditText.toDouble()
                val gasto = gastosEditText.toDouble()

                val kwhEm10Meses = kwh * 10
                val gastoEm10Meses = gasto * 10

                val resultado = """
                    Consumo em 10 meses: $kwhEm10Meses kWh
                    Gasto em 10 meses: R$ $gastoEm10Meses
                """.trimIndent()

                Toast.makeText(requireContext(), resultado, Toast.LENGTH_LONG).show()

            } catch (e: NumberFormatException) {
                Toast.makeText(requireContext(), "Por favor, insira números válidos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}