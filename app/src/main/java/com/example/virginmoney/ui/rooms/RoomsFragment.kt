package com.example.virginmoney.ui.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.data.model.rooms.RoomsModelItemModel
import com.example.virginmoney.databinding.FragmentRoomsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null

    private val binding get() = _binding!!
    private val viewModel by viewModels<RoomsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        viewModel.rooms.observe(viewLifecycleOwner) {
           it?.let {
               setupUI(it)

           }
        }
       viewModel.getRooms()
        return binding.root
    }

    private fun setupUI(rooms: ArrayList<RoomsModelItemModel>) {
        binding.fragmentRooms.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RoomsAdapter(rooms)

        }

    }


}
