package uz.it_school.zakovatclubapp.ui.screens.questions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.it_school.zakovatclubapp.R
import uz.it_school.zakovatclubapp.databinding.FragmentQuestionScreenBinding
import uz.it_school.zakovatclubapp.ui.adapter.QuestionsAdapter

class QuestionsScreen : Fragment(R.layout.fragment_question_screen) {


    private var _binding: FragmentQuestionScreenBinding? = null

    private val binding get() = _binding!!

    private val adapter= QuestionsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val viewModel: QuestionsScreenViewModel by viewModels()

    private val args: QuestionsScreenArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       viewModel.init(args.group.id)

        viewModel.questionsLiveData.observe(viewLifecycleOwner){
            adapter.submitItems(it)
        }
        binding.list.adapter=adapter

        adapter.onClick { findNavController().navigate(QuestionsScreenDirections.actionQuestionScreenToQuestionScreen2(it)) }

    }
}