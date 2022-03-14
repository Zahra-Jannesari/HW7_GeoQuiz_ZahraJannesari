package com.zarisa.geoquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.zarisa.geoquiz.databinding.FragmentCheatBinding
import kotlin.properties.Delegates


class CheatFragment : Fragment() {
    lateinit var binding: FragmentCheatBinding
    private val args:CheatFragmentArgs by navArgs()
    private val viewModel: ViewModel by viewModels()
    var numberOfPages=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentCheatBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberOfPage=args.numberOfQuestion
        binding.buttonShowInfo.setOnClickListener {
            binding.textViewCheat.text=viewModel.getCorrectAnswerText(numberOfPage)
            viewModel.setCheating(numberOfPage)
        }
    }
}