package com.example.economizeapp_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.economizeapp_mobile.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

    private var _binding : FragmentResultsBinding? = null
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

        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultadoKwh = arguments?.let { ResultsFragmentArgs.fromBundle(it).resultadoKwh }
        val resultadoGastos = arguments?.let {ResultsFragmentArgs.fromBundle(it).resultadoGastos }


        binding.resultadokwhTextView.text = resultadoKwh
        binding.resultadogastosTextView.text = resultadoGastos
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}