package com.example.virginmoney.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.databinding.ItemPeopleBinding
import kotlinx.coroutines.withContext

class PeopleAdapter(val people: ArrayList<PeopleModelItemModel>?) :
    RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {


    var onItemClick: ((PeopleModelItemModel) -> Unit)? = null

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemPeopleBinding.bind(view)
        fun handleData(item: PeopleModelItemModel?) {
            binding.people1.text = item?.firstName
            binding.people5.text = item?.lastName
            binding.people2.text = item?.email
          Glide.with(view)
              .load(item?.avatar)
              .into(binding.imageView)
            binding.people4.text = item?.favouriteColor


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = people?.size ?: 0


    override fun onBindViewHolder(holder: PeopleAdapter.ViewHolder, position: Int) {
        holder.handleData(people?.get(position))

        holder.itemView.setOnClickListener {
            people?.get(position)?.let {
                onItemClick?.invoke(it)
            }


        }


    }


    }















