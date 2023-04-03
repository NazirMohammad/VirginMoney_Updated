package com.example.virginmoney.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<PeopleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {


        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        viewModel.people.observe(viewLifecycleOwner) {


            it.let {
                setupUI(it)
            }
        }

        viewModel.getPeople()
        return binding.root
    }


    private fun setupUI(people: ArrayList<PeopleModelItemModel>?) {
        val peopleadapter =  PeopleAdapter(people)
        binding.fragmentpeople.apply {
            layoutManager = LinearLayoutManager(context)

            adapter = peopleadapter
        }


        peopleadapter.onItemClick = {

            val bundle = Bundle().apply {

                putSerializable("PeopleDetails", it)
            }

           findNavController().navigate(R.id.action_fragmentpeople_to_peopleDetailsFragment, bundle)

        }

    }

}