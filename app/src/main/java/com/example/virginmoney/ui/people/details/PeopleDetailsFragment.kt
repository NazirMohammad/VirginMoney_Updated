package com.example.virginmoney.ui.people.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.databinding.FragmentPeopleDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleDetailsFragment : Fragment() {

    //    companion object {
//        fun newInstance() = PeopleDetailsFragment()
//    }
    private var _binding: FragmentPeopleDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PeopleDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        viewModel =
            ViewModelProvider(this)[PeopleDetailsViewModel::class.java]
        _binding = FragmentPeopleDetailsBinding.inflate(inflater, container, false)


        val people = arguments?.getSerializable("PeopleDetails") as PeopleModelItemModel?

        binding.people1.text = people?.id.toString()
        binding.people2.text = people?.firstName
        binding.people3.text = people?.lastName
        binding.people4.text = people?.jobtitle
        binding.people5.text = people?.email

        return binding.root


    }
}