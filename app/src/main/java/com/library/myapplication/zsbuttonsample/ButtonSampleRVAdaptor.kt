package com.zopsmart.pagenics.zsbuttonsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.zopsmart.pagenics.R
import com.zopsmart.pagenics.databinding.BtnRecyclerListItemBinding

class ButtonSampleRVAdaptor() :
    RecyclerView.Adapter<ButtonSampleRVAdaptor.ButtonSampleViewHolder>() {
    private var buttonList = mutableListOf<String>()

    inner class ButtonSampleViewHolder(val binding: BtnRecyclerListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: String, position: Int) {
            binding.apply {
                when (position) {
                    0 -> {
                        btn.setText(data)
                    }
                    1 -> {
                        btn.apply {
                            setText(data)
                            setBorderWidth(2)
                            setRadius(15f)
                            setTextSize(14f)
                            setBorderColor(
                                ContextCompat.getColor(
                                    context,
                                    R.color.bluish_green
                                )
                            )
                        }
                    }
                    2 -> {
                        btn.apply {
                            setText(data)
                            setRadius(25f)
                            setBackgroundColorRes(R.color.teal_200)
                            setBorderWidth(2)
                            setTextSize(16f)
                            setBorderColor(
                                ContextCompat.getColor(
                                    context,
                                    R.color.bluish_green
                                )
                            )
                        }
                    }
                    3 -> {
                        btn.apply {
                            setText(data)
                            ContextCompat.getDrawable(context, R.drawable.baseline_add_to_photos)
                                ?.let { setIcon(it) }
                        }
                    }
                    4 -> {
                        btn.apply {
                            ContextCompat.getDrawable(context, R.drawable.ic_backup)
                                ?.let { setIcon(it) }
                        }
                    }
                    5 -> {
                        btn.apply {
                            setBorderWidth(2)
                            setPadding(2, 2, 2, 2)
                            setBorderColor(
                                ContextCompat.getColor(
                                    context,
                                    R.color.bluish_green
                                )
                            )
                            enableLoadingState(true)
                            setRadius(10f)
                        }
                    }
                    6 -> {
                        btn.apply {
                            setText(data)
                            setRadius(25f)
                            setBackgroundColorRes(R.color.teal_200)
                            setBorderWidth(2)
                            setTextSize(16f)
                            setAllCaps(true)
                            /* using fontFamily typeface
                            ResourcesCompat.getFont(context, com.zopsmart.pagenics.components.R.font.open_sans_bold)?.let{
                                setFontFamily(it)
                            } */
                            setFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            ContextCompat.getDrawable(context, R.drawable.ic_backup)
                                ?.let { setIcon(it) }
                            setBorderColor(
                                ContextCompat.getColor(
                                    context,
                                    R.color.bluish_green
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonSampleViewHolder =
        ButtonSampleViewHolder(
            BtnRecyclerListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ButtonSampleViewHolder, position: Int) {
        buttonList.getOrNull(position)?.let { holder.setData(it, position) }
    }

    override fun getItemCount() = buttonList.size

    fun populateRV(dataList: MutableList<String>) {
        buttonList = dataList
        notifyDataSetChanged()
    }
}
