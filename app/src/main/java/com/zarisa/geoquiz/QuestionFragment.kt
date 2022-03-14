package com.zarisa.geoquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zarisa.geoquiz.databinding.FragmentQuestionBinding
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController


var numberOfPage=0
class QuestionFragment : Fragment() {
    private val viewModel: ViewModel by viewModels()
    lateinit var binding:FragmentQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentQuestionBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        primaryInit()
        setOnClickListeners()
    }
    private fun primaryInit() {
        if(numberOfPage==0){
            binding.buttonPrev.isClickable = false
        }
        if (numberOfPage==viewModel.getTotalNumberOfQuestions()){
            binding.buttonNext.isClickable=false
        }
        binding.textViewQuestion.text=viewModel.getQuestionText(numberOfPage)
        if (viewModel.getIsAnswered(numberOfPage)){
            binding.buttonFalseAnswer.isEnabled = false
            binding.buttonTrueAnswer.isEnabled = false
        }else{
            binding.buttonFalseAnswer.isEnabled = true
            binding.buttonTrueAnswer.isEnabled = true
        }
    }
    private fun setOnClickListeners() {
        binding.buttonTrueAnswer.setOnClickListener { checkAnswer(true) }
        binding.buttonFalseAnswer.setOnClickListener { checkAnswer(false) }
        binding.buttonNext.setOnClickListener {
            numberOfPage++
            restartThePage()
        }
        binding.buttonPrev.setOnClickListener {
            numberOfPage--
            restartThePage()
        }
        binding.buttonCheat.setOnClickListener {
            val directions=QuestionFragmentDirections.actionQuestionFragmentToCheatFragment(numberOfPage)
            findNavController().navigate(directions)
        }
    }


    private fun checkAnswer(userAnswer:Boolean){
        if(viewModel.getCorrectAnswerBoolean(numberOfPage)==userAnswer){
            if(!(viewModel.getIsCheated(numberOfPage)))
                Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context,"Cheating is wrong!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Incorrect!", Toast.LENGTH_SHORT).show()
        }
        binding.buttonFalseAnswer.isClickable = false
        binding.buttonTrueAnswer.isClickable = false
        viewModel.setAnswering(numberOfPage)
    }
    private fun restartThePage(){
//        binding.buttonTrueAnswer.isClickable=true
//        binding.buttonFalseAnswer.isClickable=true
        binding.buttonCheat.isClickable=true
        binding.buttonPrev.isClickable=true
        binding.buttonNext.isClickable=true
        primaryInit()
    }
}
