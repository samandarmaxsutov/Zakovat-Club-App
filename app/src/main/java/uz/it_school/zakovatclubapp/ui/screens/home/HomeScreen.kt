package uz.it_school.zakovatclubapp.ui.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import uz.it_school.zakovatclubapp.R
import uz.it_school.zakovatclubapp.databinding.FragmentHomeScreenBinding
import uz.it_school.zakovatclubapp.ui.adapter.GroupAdpter

class HomeScreen : Fragment(R.layout.fragment_home_screen) {

    private var _binding: FragmentHomeScreenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val viewModel:HomeScreenViewModel by viewModels()
    private val adapter= GroupAdpter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openQuestionScreen.observe(this){
            findNavController().navigate(HomeScreenDirections.actionHomeScreenToQuestionScreen(it))
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = GridLayoutManager(requireContext(), 1)
        binding.list.layoutManager = layoutManager
        binding.list.adapter=adapter
        viewModel.groupLiveData.observe(viewLifecycleOwner){
            adapter.submitItems(it)
        }
        adapter.onClick{viewModel.open(it)}

        binding.searchBtn.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {

                viewModel.search(query)
                return false
            }


        })

//        binding.likeButton.setOnClickListener {
//            findNavController().navigate(HomeScreenDirections.actionHomeScreenToBookMarksScreen())
//        }
//

    }


}