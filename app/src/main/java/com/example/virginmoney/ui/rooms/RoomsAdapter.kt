package com.example.virginmoney.ui.rooms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.data.model.rooms.RoomsModelItemModel
import com.example.virginmoney.databinding.ItemRoomsBinding

class RoomsAdapter(val rooms: ArrayList<RoomsModelItemModel>) :
    RecyclerView.Adapter<RoomsAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRoomsBinding.bind(view)
        fun handleData(item: RoomsModelItemModel?) {
            binding.room1.text = item?.id
            binding.room2.text = item?.isOccupied.toString()
            binding.room3.text = item?.maxOccupancy.toString()
            binding.room4.text = item?.createdAt

//            if (adapterPosition%2==0){
//
//                binding.llRooms.setBackgroundColor(
//                    ContextCompat.getColor(
//                        view.context,
//                        R.color.purple_200
//                    )
//                )
//
//            }else{
//                binding.llRooms.setBackgroundColor(
//                    ContextCompat.getColor(
//                        view.context,
//                        R.color.purple_500
//                    )
//                )
            //       }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rooms, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = rooms?.size ?: 0


    override fun onBindViewHolder(holder: RoomsAdapter.ViewHolder, position: Int) {
        holder.handleData(rooms?.get(position))

    }

}
