package com.zopsmart.pagenics.zsbuttonsample

import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants
import com.zopsmart.pagenics.databinding.BannerRvListBinding

class BannerSampleRVAdaptor :
    RecyclerView.Adapter<BannerSampleRVAdaptor.BannerSampleViewHolder>() {
    private var bannerList = mutableListOf<String>()

    inner class BannerSampleViewHolder(private val binding: BannerRvListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private fun callToast() {
            Toast.makeText(
                itemView.context,
                PagenicsConstants.DEFAULT_ZSMESSAGE,
                Toast.LENGTH_LONG
            ).show()
        }

        fun setData() {
            binding.apply {
                when (adapterPosition) {
                    0 -> {
                        zsBanner.apply {
                            setTitle("Banner with background")
                            setTitleAllCaps(true)
                            setTitleColor(Color.WHITE)
                            setOnBackgroundImageClickListener { callToast() }
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setSubtitleColor(Color.WHITE)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.WHITE)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.START)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                    1 -> {
                        zsBanner.apply {
                            setTitle("Banner with background")
                            setTitleAllCaps(true)
                            setTitleColor(Color.WHITE)
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setOnBackgroundImageClickListener { callToast() }
                            setSubtitleColor(Color.WHITE)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            isBannerWithButton(true)
                            setSingleButtonText("Button")
                            setSingleButtonStyle(com.zopsmart.pagenics.components.R.style.button_compact_1)
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.WHITE)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.START)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                    2 -> {
                        zsBanner.apply {
                            setTitle("Banner with background")
                            setTitleAllCaps(true)
                            setTitleColor(Color.WHITE)
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setSubtitleColor(Color.WHITE)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            isBannerWithButton(true)
                            setSingleButtonText("Button")
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.WHITE)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.CENTER)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                    3 -> {
                        zsBanner.apply {
                            setTitle("Banner with background")
                            setTitleAllCaps(true)
                            setTitleColor(Color.WHITE)
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setSubtitleColor(Color.WHITE)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            isBannerWithTwoButton(true)
                            setPrimaryButtonText("Button1")
                            setSecondaryButtonText("Button2")
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.WHITE)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.CENTER)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                    4 -> {
                        zsBanner.apply {
                            setTitle("Banner with Left Image")
                            setTitleAllCaps(true)
                            setTitleColor(Color.BLACK)
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setSubtitleColor(Color.BLACK)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            isBannerImageLeftAlign(true)
                            setOnLeftImageClickListener { callToast() }
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.BLACK)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.CENTER)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                    5 -> {
                        zsBanner.apply {
                            setTitle("Banner with Left Image")
                            setTitleAllCaps(true)
                            setTitleColor(Color.BLACK)
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setSubtitleColor(Color.BLACK)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            isBannerWithButton(true)
                            setSingleButtonText("Button")
                            setSingleButtonStyle(com.zopsmart.pagenics.components.R.style.button_compact_1)
                            setOnLeftImageClickListener { callToast() }
                            isBannerImageLeftAlign(true)
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.BLACK)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.CENTER)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                    6 -> {
                        zsBanner.apply {
                            setTitle("Banner with Left Image")
                            setTitleAllCaps(true)
                            setTitleColor(Color.BLACK)
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setSubtitleColor(Color.BLACK)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            isBannerWithTwoButton(true)
                            setPrimaryButtonText("Button1")
                            setSecondaryButtonText("Button2")
                            isBannerImageLeftAlign(true)
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.BLACK)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.CENTER)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                    7 -> {
                        zsBanner.apply {
                            setTitle("Banner with Right Image")
                            setTitleAllCaps(true)
                            setTitleColor(Color.BLACK)
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setSubtitleColor(Color.BLACK)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            isBannerImageRightAlign(true)
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.BLACK)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.CENTER)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                    8 -> {
                        zsBanner.apply {
                            setTitle("Banner with Right Image")
                            setTitleAllCaps(true)
                            setTitleColor(Color.BLACK)
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setSubtitleColor(Color.BLACK)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            isBannerWithButton(true)
                            setSingleButtonText("Button")
                            isBannerImageRightAlign(true)
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.BLACK)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.CENTER)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                    9 -> {
                        zsBanner.apply {
                            setTitle("Banner with Right Image")
                            setTitleAllCaps(true)
                            setTitleColor(Color.BLACK)
                            setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
                            setSubTitle("This is subtitle")
                            setSubTitleAllCaps(false)
                            setSubtitleColor(Color.BLACK)
                            setSubtitleTextStyle(Typeface.NORMAL)
                            isBannerWithTwoButton(true)
                            setPrimaryButtonText("Button1")
                            setSecondaryButtonText("Button2")
                            setBackgroundTintButtonPrimary("#FB586C")
                            setBackgroundTintButtonSecondary("#6AB2AD")
                            setPrimaryButtonStyle(com.zopsmart.pagenics.components.R.style.button_compact_1)
                            setOnRightImageClickListener { callToast() }
                            setOnPrimaryButtonClickListener { callToast() }
                            setOnSecondaryButtonClickListener { callToast() }
                            isBannerImageRightAlign(true)
                            setDescription("This is a banner description ")
                            setDescriptionColor(Color.BLACK)
                            setDescriptionTextStyle(Typeface.ITALIC)
                            setBannerGravity(Gravity.CENTER)
                            setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerSampleViewHolder =
        BannerSampleViewHolder(
            BannerRvListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BannerSampleViewHolder, position: Int) {
        bannerList.getOrNull(position)?.let { holder.setData() }
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int) = position

    override fun getItemCount() = bannerList.size

    fun populateRVBanner(dataList: MutableList<String>) {
        bannerList = dataList
        notifyDataSetChanged()
    }
}
