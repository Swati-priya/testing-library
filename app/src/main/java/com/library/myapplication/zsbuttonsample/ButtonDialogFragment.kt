package com.zopsmart.pagenics.zsbuttonsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.ZS_BUTTON
import com.zopsmart.pagenics.databinding.FragmentButtonBinding

class ButtonDialogFragment : DialogFragment() {
    private var binding: FragmentButtonBinding? = null
    private val buttonSampleRVAdaptor: ButtonSampleRVAdaptor by lazy { ButtonSampleRVAdaptor() }
    private val bannerSampleRVAdaptor: BannerSampleRVAdaptor by lazy { BannerSampleRVAdaptor() }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setBackgroundDrawableResource(android.R.color.transparent)
            setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentButtonBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            tvSampleTitle.text = tag
            if (tag == ZS_BUTTON) {
                rvButtonRecycler.adapter = buttonSampleRVAdaptor
                buttonSampleRVAdaptor.populateRV(
                    mutableListOf<String>().apply {
                        for (i in 0..6) add("Button $i")
                    }
                )
            } else {
                rvButtonRecycler.adapter = bannerSampleRVAdaptor
                bannerSampleRVAdaptor.populateRVBanner(
                    mutableListOf<String>().apply {
                        for (i in 0..9) add("Banner $i")
                    }
                )
            }
            navigationBack.setOnClickListener {
                if (dialog?.isShowing == true) dismiss()
            }
        }
    }

    companion object {
        fun newInstance() = ButtonDialogFragment()
    }
}
