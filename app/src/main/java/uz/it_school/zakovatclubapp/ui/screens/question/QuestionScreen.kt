package uz.it_school.zakovatclubapp.ui.screens.question



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.it_school.zakovatclubapp.R
import uz.it_school.zakovatclubapp.databinding.FragmentQuestionScreen2Binding

class QuestionScreen : Fragment(R.layout.fragment_question_screen2) {


    private var _binding: FragmentQuestionScreen2Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionScreen2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val viewModel: QuestionScreenViewModel by viewModels()

    private val args: QuestionScreenArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.questionText.text = args.question.question
        binding.answer.text = args.question.answer

        viewModel.init(args.question)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        if (args.question.isFavorite) binding.likeButton.setImageResource(R.drawable.baseline_favorite_24)
        else binding.likeButton.setImageResource(R.drawable.unlike)
        binding.likeButton.setOnClickListener {
            viewModel.update()
        }

        viewModel.getUiChange.observe(viewLifecycleOwner){

            binding.questionText.text = it.question
            binding.answer.text = it.answer
            if (it.isFavorite) binding.likeButton.setImageResource(R.drawable.baseline_favorite_24)
            else binding.likeButton.setImageResource(R.drawable.unlike)

        }

    }


}