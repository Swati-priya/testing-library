package com.zopsmart.pagenics.components.zsbanner

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.zopsmart.pagenics.components.R
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DESCRIPTION
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.SUBTITLE
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.TITLE

class ZsBanner @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {
    private var backgroundDrawable: Drawable? = null
    private var imageUrl: String? = null
    private var isImageLeftAlign: Boolean = false
    private var isImageRightAlign: Boolean = false
    private var drawableResource = 0
    private var bannerBackgroundColor: Int = Color.WHITE
    private var isBannerWithTwoButton: Boolean = false
    private var isBannerWithButton: Boolean = false
    private var title: String? = null
    private var titleColor: Int = Color.BLACK
    private var titleSize: Float = 16f
    private var titleSizeRes: Int = 0
    private var titleAllCaps: Boolean = false
    private var titleTextStyle: Int = TEXT_STYLE_NORMAL
    private var titleGravity: Int? = null
    private var titleFontFamily: Int = 0
    private var subtitle: String? = null
    private var subtitleColor: Int = Color.BLACK
    private var subtitleSize: Float = 14f
    private var subtitleSizeRes: Int = 0
    private var subtitleAllCaps: Boolean = false
    private var subtitleTextStyle: Int = TEXT_STYLE_NORMAL
    private var subtitleGravity: Int? = null
    private var subtitleFontFamily: Int = 0
    private var description: String? = null
    private var descriptionColor: Int = Color.BLACK
    private var descriptionSize: Float = 12f
    private var descriptionSizeRes: Int = 0
    private var descriptionAllCaps: Boolean = false
    private var descriptionTextStyle: Int = TEXT_STYLE_NORMAL
    private var descriptionGravity: Int? = null
    private var descriptionFontFamily: Int = 0
    private var bannerFontFamily: Int = 0
    private var bannerGravity: Int = GRAVITY_CENTER
    private var primaryButtonStyle: Int = R.style.button_compact
    private var secondaryButtonStyle: Int = R.style.button_compact
    private var singleButtonStyle: Int = R.style.button_compact
    private var leftImageRatio: Float = 0.4f
    private var rightImageRatio: Float = 0.4f
    private var leftImageClick: (() -> Unit)? = null
    private var rightImageClick: (() -> Unit)? = null
    private var backgroundImageClick: (() -> Unit)? = null
    private var primaryButtonClick: (() -> Unit)? = null
    private var secondaryButtonClick: (() -> Unit)? = null
    private var singleButtonClick: (() -> Unit)? = null
    private var button0: AppCompatButton? = null
    private var button1: AppCompatButton? = null
    private var button2: AppCompatButton? = null
    private var buttonAllCaps: Boolean = false
    private var primaryButtonText: String? = null
    private var secondaryButtonText: String? = null
    private var singleButtonText: String? = null
    private var primaryButtonTint: String? = null
    private var secondaryButtonTint: String? = null
    private var btnTextSize: Float = 12f
    private var btnTextSizeRes: Int = 0

    init {
        View.inflate(context, R.layout.zs_banner_layout, this)
        val attrsArray = context.obtainStyledAttributes(attrs, R.styleable.ZsBanner, 0, 0)
        initAttributes(attrsArray)
        attrsArray.recycle()
        initializeView()
    }

    private fun initAttributes(attrs: TypedArray) {
        drawableResource =
            attrs.getResourceId(R.styleable.ZsBanner_zsBanner_backgroundDrawable, drawableResource)
        bannerGravity = attrs.getInt(R.styleable.ZsBanner_zsBanner_gravity, bannerGravity)
        bannerFontFamily = attrs.getResourceId(R.styleable.ZsBanner_zsBanner_fontFamily, 0)
        bannerBackgroundColor =
            attrs.getColor(R.styleable.ZsBanner_zsBanner_backgroundColor, bannerBackgroundColor)
        imageUrl = attrs.getString(R.styleable.ZsBanner_zsBanner_imageUrl)
        isBannerWithButton =
            attrs.getBoolean(R.styleable.ZsBanner_zsBanner_IsBannerWithButton, isBannerWithButton)
        isBannerWithTwoButton = attrs.getBoolean(
            R.styleable.ZsBanner_zsBanner_IsBannerWithTwoButton,
            isBannerWithTwoButton
        )
        isImageLeftAlign =
            attrs.getBoolean(R.styleable.ZsBanner_zs_banner_image_left_align, isImageLeftAlign)
        isImageRightAlign =
            attrs.getBoolean(R.styleable.ZsBanner_zs_banner_image_right_align, isImageRightAlign)
        // image ratio
        leftImageRatio =
            attrs.getFloat(R.styleable.ZsBanner_zsBanner_left_image_ratio, leftImageRatio)
        rightImageRatio =
            attrs.getFloat(R.styleable.ZsBanner_zsBanner_right_image_ratio, rightImageRatio)
        // button text & it's size
        btnTextSizeRes = attrs.getDimensionPixelSize(
            R.styleable.ZsBanner_zsBanner_button_textSize,
            btnTextSizeRes
        )
        primaryButtonText = attrs.getString(R.styleable.ZsBanner_zsBanner_primary_button_text)
        secondaryButtonText = attrs.getString(R.styleable.ZsBanner_zsBanner_secondary_button_text)
        singleButtonText = attrs.getString(R.styleable.ZsBanner_zsBanner_single_button_text)
        // button Styling
        primaryButtonStyle = attrs.getResourceId(
            R.styleable.ZsBanner_zsBanner_primary_button_style,
            primaryButtonStyle
        )
        secondaryButtonStyle = attrs.getResourceId(
            R.styleable.ZsBanner_zsBanner_secondary_button_style,
            secondaryButtonStyle
        )
        singleButtonStyle = attrs.getResourceId(
            R.styleable.ZsBanner_zsBanner_single_button_style,
            singleButtonStyle
        )
        buttonAllCaps = attrs.getBoolean(R.styleable.ZsBanner_zsBanner_buttonAllCaps, buttonAllCaps)
        // button tint color
        primaryButtonTint =
            attrs.getString(R.styleable.ZsBanner_zsBanner_setBackgroundTintButtonPrimary)
        secondaryButtonTint =
            attrs.getString(R.styleable.ZsBanner_zsBanner_setBackgroundTintButtonSecondary)

        // title
        title = attrs.getString(R.styleable.ZsBanner_zsBanner_title)
        titleColor = attrs.getColor(R.styleable.ZsBanner_zsBanner_titleColor, titleColor)
        titleSizeRes =
            attrs.getDimensionPixelSize(R.styleable.ZsBanner_zsBanner_titleSize, titleSizeRes)
        titleTextStyle = attrs.getInt(R.styleable.ZsBanner_zsBanner_titleStyle, titleTextStyle)
        titleAllCaps = attrs.getBoolean(R.styleable.ZsBanner_zsBanner_titleAllCaps, titleAllCaps)
        titleGravity =
            titleGravity?.let { attrs.getInt(R.styleable.ZsBanner_zsBanner_title_gravity, it) }
        titleFontFamily = attrs.getResourceId(R.styleable.ZsBanner_zsBanner_title_fontFamily, 0)
        // subtitle
        subtitle = attrs.getString(R.styleable.ZsBanner_zsBanner_subtitle)
        subtitleColor = attrs.getColor(R.styleable.ZsBanner_zsBanner_subtitleColor, subtitleColor)
        subtitleSizeRes =
            attrs.getDimensionPixelSize(R.styleable.ZsBanner_zsBanner_subtitleSize, subtitleSizeRes)
        subtitleTextStyle =
            attrs.getInt(R.styleable.ZsBanner_zsBanner_subtitleStyle, subtitleTextStyle)
        subtitleAllCaps =
            attrs.getBoolean(R.styleable.ZsBanner_zsBanner_subtitleAllCaps, subtitleAllCaps)
        subtitleGravity = subtitleGravity?.let {
            attrs.getInt(
                R.styleable.ZsBanner_zsBanner_subtitle_gravity,
                it
            )
        }
        subtitleFontFamily =
            attrs.getResourceId(R.styleable.ZsBanner_zsBanner_subtitle_fontFamily, 0)
        // description
        description = attrs.getString(R.styleable.ZsBanner_zsBanner_subtitle)
        descriptionColor =
            attrs.getColor(R.styleable.ZsBanner_zsBanner_descriptionColor, descriptionColor)
        descriptionSizeRes =
            attrs.getDimensionPixelSize(
                R.styleable.ZsBanner_zsBanner_descriptionSize,
                descriptionSizeRes
            )
        descriptionTextStyle =
            attrs.getInt(R.styleable.ZsBanner_zsBanner_descriptionStyle, descriptionTextStyle)
        descriptionAllCaps =
            attrs.getBoolean(R.styleable.ZsBanner_zsBanner_descriptionAllCaps, descriptionAllCaps)
        descriptionGravity = descriptionGravity?.let {
            attrs.getInt(
                R.styleable.ZsBanner_zsBanner_description_gravity,
                it
            )
        }
        descriptionFontFamily =
            attrs.getResourceId(R.styleable.ZsBanner_zsBanner_description_fontFamily, 0)
    }

    private fun initializeView() {
        if (layoutParams == null) {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }
        if (isImageRightAlign || isImageLeftAlign) {
            removeAllViews()
            View.inflate(context, R.layout.zs_banner_with_image, this)
        }
        setupBackgroundImage()
        setupTextView(
            data = title,
            tvColor = titleColor,
            tvSizeRes = titleSizeRes,
            tvSize = titleSize,
            tvCaps = titleAllCaps,
            tvTextStyle = titleTextStyle,
            tvFontFamily = titleFontFamily,
            tvType = TITLE,
            gravityForText = titleGravity
        )
        setupTextView(
            data = subtitle,
            tvColor = subtitleColor,
            tvSizeRes = subtitleSizeRes,
            tvSize = subtitleSize,
            tvCaps = subtitleAllCaps,
            tvTextStyle = subtitleTextStyle,
            tvFontFamily = subtitleFontFamily,
            tvType = SUBTITLE,
            gravityForText = subtitleGravity
        )
        setupTextView(
            data = description,
            tvColor = descriptionColor,
            tvSizeRes = descriptionSizeRes,
            tvSize = descriptionSize,
            tvCaps = descriptionAllCaps,
            tvTextStyle = descriptionTextStyle,
            tvFontFamily = descriptionFontFamily,
            tvType = DESCRIPTION,
            gravityForText = descriptionGravity
        )
        setupButton()
        updateGravity()
    }

    private fun setupButton() {
        if (!isImageLeftAlign && !isImageRightAlign) {
            if (isBannerWithTwoButton || (!primaryButtonText.isNullOrBlank() && !secondaryButtonText.isNullOrBlank())) {
                if (findViewById<AppCompatButton>(R.id.banner_button1) != null) {
                    findViewById<ConstraintLayout>(R.id.cl_zs_banner).removeView(findViewById(R.id.banner_button1))
                }
                button1 = AppCompatButton(
                    ContextThemeWrapper(context, primaryButtonStyle),
                    null,
                    0
                )
                button1?.apply {
                    id = R.id.banner_button1
                    if (layoutParams == null) {
                        layoutParams = ConstraintLayout.LayoutParams(
                            0,
                            LayoutParams.WRAP_CONTENT
                        )
                    }
                    val params = layoutParams as ConstraintLayout.LayoutParams
                    with(params) {
                        bottomToBottom = R.id.cl_zs_banner
                        startToStart = R.id.guideline1
                        endToStart = R.id.guideline3
                        topToBottom = R.id.tv_desc
                        setMargins(
                            dpToPx(context, 16),
                            dpToPx(context, 4),
                            dpToPx(context, 16),
                            dpToPx(context, 16)
                        )
                    }
                    layoutParams = params
                    ellipsize = TextUtils.TruncateAt.END
                    maxLines = 1
                    text = primaryButtonText
                    if (textSize <= 0) {
                        textSize = if (btnTextSizeRes != 0) {
                            pxToSp(context, btnTextSizeRes.toFloat())
                        } else {
                            btnTextSize
                        }
                    }
                    isAllCaps = buttonAllCaps
                    try {
                        val color = Color.parseColor(primaryButtonTint)
                        backgroundTintList = ColorStateList.valueOf(color)
                    } catch (_: Exception) {
                    }
                    setOnClickListener {
                        primaryButtonClick?.invoke()
                    }
                }
                findViewById<ConstraintLayout>(R.id.cl_zs_banner).addView(button1)

                if (findViewById<AppCompatButton>(R.id.banner_button2) != null) {
                    findViewById<ConstraintLayout>(R.id.cl_zs_banner).removeView(findViewById(R.id.banner_button2))
                }
                button2 = AppCompatButton(
                    ContextThemeWrapper(context, secondaryButtonStyle),
                    null,
                    0
                )
                button2?.apply {
                    id = R.id.banner_button2
                    if (layoutParams == null) {
                        layoutParams = ConstraintLayout.LayoutParams(
                            0,
                            LayoutParams.WRAP_CONTENT
                        )
                    }
                    val params = layoutParams as ConstraintLayout.LayoutParams
                    with(params) {
                        bottomToBottom = R.id.cl_zs_banner
                        startToStart = R.id.guideline3
                        endToStart = R.id.guideline2
                        topToBottom = R.id.tv_desc
                        setMargins(
                            dpToPx(context, 16),
                            dpToPx(context, 4),
                            dpToPx(context, 16),
                            dpToPx(context, 16)
                        )
                    }
                    layoutParams = params
                    ellipsize = TextUtils.TruncateAt.END
                    maxLines = 1
                    text = secondaryButtonText
                    isAllCaps = buttonAllCaps
                    if (textSize <= 0) {
                        textSize = if (btnTextSizeRes != 0) {
                            pxToSp(context, btnTextSizeRes.toFloat())
                        } else {
                            btnTextSize
                        }
                    }
                    try {
                        val color = Color.parseColor(secondaryButtonTint)
                        backgroundTintList = ColorStateList.valueOf(color)
                    } catch (_: Exception) {
                    }
                    setOnClickListener {
                        secondaryButtonClick?.invoke()
                    }
                }
                findViewById<ConstraintLayout>(R.id.cl_zs_banner).addView(button2)
            }
            if (isBannerWithButton || !singleButtonText.isNullOrBlank()) {
                if (findViewById<AppCompatButton>(R.id.banner_button0) != null) {
                    findViewById<ConstraintLayout>(R.id.cl_zs_banner).removeView(findViewById(R.id.banner_button0))
                }
                button0 = AppCompatButton(ContextThemeWrapper(context, singleButtonStyle), null, 0)
                button0?.apply {
                    id = R.id.banner_button0
                    if (layoutParams == null) {
                        layoutParams = ConstraintLayout.LayoutParams(
                            LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT
                        )
                    }
                    val params = layoutParams as ConstraintLayout.LayoutParams
                    with(params) {
                        bottomToBottom = R.id.cl_zs_banner
                        if (bannerGravity != GRAVITY_RIGHT && bannerGravity != GRAVITY_END) {
                            startToEnd = R.id.guideline1
                        }
                        if (bannerGravity != GRAVITY_LEFT && bannerGravity != GRAVITY_START) {
                            endToStart = R.id.guideline2
                        }
                        topToBottom = R.id.tv_desc
                        setMargins(
                            dpToPx(context, 16),
                            dpToPx(context, 16),
                            dpToPx(context, 16),
                            dpToPx(context, 16)
                        )
                    }
                    layoutParams = params
                    ellipsize = TextUtils.TruncateAt.END
                    maxLines = 1
                    text = singleButtonText
                    isAllCaps = buttonAllCaps
                    if (textSize <= 0) {
                        textSize = if (btnTextSizeRes != 0) {
                            pxToSp(context, btnTextSizeRes.toFloat())
                        } else {
                            btnTextSize
                        }
                    }
                    try {
                        val color = Color.parseColor(primaryButtonTint)
                        backgroundTintList = ColorStateList.valueOf(color)
                    } catch (_: Exception) {
                    }
                    setOnClickListener {
                        singleButtonClick?.invoke()
                    }
                }
                findViewById<ConstraintLayout>(R.id.cl_zs_banner).addView(button0)
            }
        } else {
            val btnLayout = findViewById<ConstraintLayout>(R.id.cl_button_layout)
            if (isBannerWithButton || isBannerWithTwoButton || !primaryButtonText.isNullOrBlank() || !singleButtonText.isNullOrBlank()) {
                if (findViewById<AppCompatButton>(R.id.banner_button1) != null) {
                    btnLayout.removeView(findViewById(R.id.banner_button1))
                }
                button1 = AppCompatButton(
                    ContextThemeWrapper(
                        context,
                        if (isBannerWithTwoButton) primaryButtonStyle else singleButtonStyle
                    ),
                    null,
                    0
                )
                button1?.apply {
                    id = R.id.banner_button1
                    if (layoutParams == null) {
                        layoutParams = ConstraintLayout.LayoutParams(
                            0,
                            LayoutParams.WRAP_CONTENT
                        )
                    }
                    val params = layoutParams as ConstraintLayout.LayoutParams
                    with(params) {
                        bottomToBottom = R.id.cl_button_layout
                        startToStart = R.id.cl_button_layout
                    }
                    layoutParams = params
                    ellipsize = TextUtils.TruncateAt.END
                    maxLines = 1
                    isAllCaps = buttonAllCaps
                    text = if (isBannerWithTwoButton) primaryButtonText else singleButtonText
                    if (textSize <= 0) {
                        textSize = if (btnTextSizeRes != 0) {
                            pxToSp(context, btnTextSizeRes.toFloat())
                        } else {
                            btnTextSize
                        }
                    }
                    try {
                        val color = Color.parseColor(primaryButtonTint)
                        backgroundTintList = ColorStateList.valueOf(color)
                    } catch (_: Exception) {
                    }
                    setOnClickListener {
                        if (isBannerWithButton) {
                            singleButtonClick?.invoke()
                        } else {
                            primaryButtonClick?.invoke()
                        }
                    }
                }
                btnLayout.addView(button1)
            }
            if (isBannerWithTwoButton || (!primaryButtonText.isNullOrBlank() && !secondaryButtonText.isNullOrBlank())) {
                if (findViewById<AppCompatButton>(R.id.banner_button2) != null) {
                    btnLayout.removeView(findViewById(R.id.banner_button2))
                }
                button2 = AppCompatButton(
                    ContextThemeWrapper(context, secondaryButtonStyle),
                    null,
                    0
                )
                button2?.apply {
                    id = R.id.banner_button2
                    isVisible = true
                    if (layoutParams == null) {
                        layoutParams = ConstraintLayout.LayoutParams(
                            0,
                            LayoutParams.WRAP_CONTENT
                        )
                    }
                    val params = layoutParams as ConstraintLayout.LayoutParams
                    with(params) {
                        bottomToBottom = R.id.cl_button_layout
                        startToEnd = R.id.banner_button1
                        endToEnd = R.id.cl_button_layout
                        marginStart = dpToPx(context, 16)
                    }
                    layoutParams = params
                    ellipsize = TextUtils.TruncateAt.END
                    maxLines = 1
                    isAllCaps = buttonAllCaps
                    text = secondaryButtonText
                    if (textSize <= 0) {
                        textSize = if (btnTextSizeRes != 0) {
                            pxToSp(context, btnTextSizeRes.toFloat())
                        } else {
                            btnTextSize
                        }
                    }
                    try {
                        val color = Color.parseColor(secondaryButtonTint)
                        backgroundTintList = ColorStateList.valueOf(color)
                    } catch (_: Exception) {
                    }
                    setOnClickListener {
                        secondaryButtonClick?.invoke()
                    }
                }
                btnLayout.addView(button2)
                findViewById<AppCompatButton>(R.id.banner_button1).apply {
                    val params = layoutParams as ConstraintLayout.LayoutParams
                    with(params) {
                        bottomToBottom = R.id.cl_button_layout
                        startToStart = R.id.cl_button_layout
                        endToStart = R.id.banner_button2
                    }
                    layoutParams = params
                }
            }
            if (btnLayout.childCount > 0) btnLayout.isVisible = true
        }
    }

    private fun setupTextView(
        data: String?,
        tvColor: Int,
        tvSizeRes: Int,
        tvSize: Float,
        tvCaps: Boolean,
        tvTextStyle: Int,
        tvFontFamily: Int,
        tvType: String,
        gravityForText: Int?
    ) {
        findViewById<TextView>(
            when (tvType) {
                TITLE -> if (isImageLeftAlign || isImageRightAlign) R.id.tv_banner_title else R.id.tv_title
                SUBTITLE -> if (isImageLeftAlign || isImageRightAlign) R.id.tv_banner_sub_title else R.id.tv_sub_title
                else -> if (isImageLeftAlign || isImageRightAlign) R.id.tv_banner_desc else R.id.tv_desc
            }
        ).apply {
            data?.let {
                isVisible = true
                text = it
                setTextColor(tvColor)
                textSize = if (tvSizeRes != 0) {
                    pxToSp(context, tvSizeRes.toFloat())
                } else {
                    tvSize
                }
                isAllCaps = tvCaps
                when (tvTextStyle) {
                    1 -> {
                        setTypeface(typeface, Typeface.BOLD)
                    }
                    2 -> {
                        setTypeface(typeface, Typeface.ITALIC)
                    }
                    3 -> {
                        setTypeface(typeface, Typeface.BOLD_ITALIC)
                    }
                    else -> {
                        setTypeface(typeface, Typeface.NORMAL)
                    }
                }
                if (tvFontFamily > 0 || bannerFontFamily > 0) {
                    typeface = ResourcesCompat.getFont(
                        context,
                        if (tvFontFamily > 0) tvFontFamily else bannerFontFamily
                    )
                }
                if (!isImageLeftAlign && !isImageRightAlign) {
                    gravity =
                        gravityForText ?: bannerGravity
                }
            } ?: run {
                this.isVisible = false
            }
        }
    }

    private fun setupBackgroundImage() {
        if (!isImageLeftAlign && !isImageRightAlign) {
            findViewById<ImageView>(R.id.iv_background_image).apply {
                if (imageUrl == null && drawableResource == 0 && backgroundDrawable == null) {
                    setBackgroundColor(bannerBackgroundColor)
                } else {
                    setImageUsingGlide(this)
                }
                setOnClickListener {
                    backgroundImageClick?.invoke()
                }
            }
        } else if (isImageLeftAlign) {
            findViewById<Guideline>(R.id.guideline4).setGuidelinePercent(leftImageRatio)
            findViewById<Guideline>(R.id.guideline5).setGuidelinePercent(1.0f)
            findViewById<ImageView>(R.id.iv_left_banner_image).apply {
                isVisible = true
                setImageUsingGlide(this)
                setOnClickListener {
                    leftImageClick?.invoke()
                }
            }
        } else if (isImageRightAlign) {
            findViewById<Guideline>(R.id.guideline4).setGuidelinePercent(0.0f)
            findViewById<Guideline>(R.id.guideline5).setGuidelinePercent(1 - rightImageRatio)
            findViewById<ImageView>(R.id.iv_right_banner_image).apply {
                isVisible = true
                setImageUsingGlide(this)
                setOnClickListener {
                    rightImageClick?.invoke()
                }
            }
        }
    }

    private fun setImageUsingGlide(imageView: ImageView) {
        Glide.with(context)
            .load(if (imageUrl != null) imageUrl else if (drawableResource != 0) drawableResource else if (backgroundDrawable != null) backgroundDrawable else R.drawable.ic_place_holder)
            .error(R.drawable.ic_place_holder)
            .into(imageView)
    }

    private fun updateGravity() {
        when (bannerGravity) {
            GRAVITY_CENTER -> {
                super.setGravity(Gravity.CENTER)
            }
            GRAVITY_LEFT -> {
                super.setGravity(Gravity.LEFT)
            }
            GRAVITY_RIGHT -> {
                super.setGravity(Gravity.RIGHT)
            }
            GRAVITY_TOP -> {
                super.setGravity(Gravity.TOP)
            }
            GRAVITY_BOTTOM -> {
                super.setGravity(Gravity.BOTTOM)
            }
            GRAVITY_START -> {
                super.setGravity(Gravity.START)
            }
            GRAVITY_END -> {
                super.setGravity(Gravity.END)
            }
            GRAVITY_CENTER_HORIZONTAL -> {
                super.setGravity(Gravity.CENTER_HORIZONTAL)
            }
            GRAVITY_CENTER_VERTICAL -> {
                super.setGravity(Gravity.CENTER_VERTICAL)
            }
            NO_GRAVITY -> {
                super.setGravity(Gravity.NO_GRAVITY)
            }
        }
    }

    fun setBackgroundColorRes(@ColorRes colorId: Int) {
        setBannerBackgroundColor(ContextCompat.getColor(context, colorId))
    }

    fun setBannerBackgroundColor(@ColorInt color: Int) {
        bannerBackgroundColor = color
        initializeView()
    }

    fun setTitleAllCaps(allCaps: Boolean) {
        titleAllCaps = allCaps
        initializeView()
    }

    fun setSubTitleAllCaps(allCaps: Boolean) {
        subtitleAllCaps = allCaps
        initializeView()
    }

    fun setDescriptionAllCaps(allCaps: Boolean) {
        descriptionAllCaps = allCaps
        initializeView()
    }

    fun setButtonAllCaps(allCaps: Boolean) {
        buttonAllCaps = allCaps
        initializeView()
    }

    fun setBannerFontFamilyRes(@FontRes fontFamilyId: Int) {
        bannerFontFamily = fontFamilyId
        initializeView()
    }

    fun setTitleFontFamilyRes(@FontRes fontFamilyId: Int) {
        titleFontFamily = fontFamilyId
        initializeView()
    }

    fun setSubtitleFontFamilyRes(@FontRes fontFamilyId: Int) {
        subtitleFontFamily = fontFamilyId
        initializeView()
    }

    fun setDescriptionFontFamilyRes(@FontRes fontFamilyId: Int) {
        descriptionFontFamily = fontFamilyId
        initializeView()
    }

    fun setTitleRes(@StringRes title: Int) {
        setTitle(context.getString(title))
    }

    fun setTitle(msg: String) {
        title = msg
        initializeView()
    }

    fun setSubTitleRes(@StringRes title: Int) {
        setSubTitle(context.getString(title))
    }

    fun setSubTitle(msg: String) {
        subtitle = msg
        initializeView()
    }

    fun setDescriptionRes(@StringRes title: Int) {
        setDescription(context.getString(title))
    }

    fun setDescription(msg: String) {
        description = msg
        initializeView()
    }

    fun setTitleSizeRes(@DimenRes dimenId: Int) {
        setTitleSize(pxToSp(context, context.resources.getDimensionPixelSize(dimenId).toFloat()))
    }

    fun setTitleSize(titleSize: Float) {
        this.titleSize = titleSize
        initializeView()
    }

    fun setSubtitleSizeRes(@DimenRes dimenId: Int) {
        setSubtitleSize(pxToSp(context, context.resources.getDimensionPixelSize(dimenId).toFloat()))
    }

    fun setSubtitleSize(titleSize: Float) {
        this.subtitleSize = titleSize
        initializeView()
    }

    fun setDescriptionSizeRes(@DimenRes dimenId: Int) {
        setDescriptionSize(
            pxToSp(
                context,
                context.resources.getDimensionPixelSize(dimenId).toFloat()
            )
        )
    }

    fun setDescriptionSize(titleSize: Float) {
        this.descriptionSize = titleSize
        initializeView()
    }

    fun setTitleColorRes(@ColorRes colorId: Int) {
        setTitleColor(ContextCompat.getColor(context, colorId))
    }

    fun setTitleColor(@ColorInt color: Int) {
        titleColor = color
        initializeView()
    }

    fun setSubtitleColorRes(@ColorRes colorId: Int) {
        setSubtitleColor(ContextCompat.getColor(context, colorId))
    }

    fun setSubtitleColor(@ColorInt color: Int) {
        subtitleColor = color
        initializeView()
    }

    fun setDescriptionColorRes(@ColorRes colorId: Int) {
        setDescriptionColor(ContextCompat.getColor(context, colorId))
    }

    fun setDescriptionColor(@ColorInt color: Int) {
        descriptionColor = color
        initializeView()
    }

    fun setBackgroundDrawableRes(@DrawableRes icon: Int) {
        drawableResource = icon
        setupBackgroundImage()
    }

    fun setBannerBackgroundDrawable(drawable: Drawable) {
        backgroundDrawable = drawable
        setupBackgroundImage()
    }

    fun setBannerImageUrl(url: String?) {
        imageUrl = url
        initializeView()
    }

    fun isBannerWithButton(isBannerWithButton: Boolean) {
        this.isBannerWithButton = isBannerWithButton
        initializeView()
    }

    fun isBannerWithTwoButton(isBannerWithTwoButton: Boolean) {
        this.isBannerWithTwoButton = isBannerWithTwoButton
        initializeView()
    }

    fun isBannerImageLeftAlign(isLeftAlign: Boolean) {
        isImageLeftAlign = isLeftAlign
        initializeView()
    }

    fun isBannerImageRightAlign(isRightAlign: Boolean) {
        isImageRightAlign = isRightAlign
        initializeView()
    }

    fun setLeftImageRatio(ratio: Float) {
        leftImageRatio = ratio
        initializeView()
    }

    fun setRightImageRatio(ratio: Float) {
        rightImageRatio = ratio
        initializeView()
    }

    fun setBannerGravity(textGravity: Int) {
        bannerGravity = textGravity
        initializeView()
    }

    fun setTitleGravity(textGravity: Int) {
        titleGravity = textGravity
        initializeView()
    }

    fun setSubtitleGravity(textGravity: Int) {
        subtitleGravity = textGravity
        initializeView()
    }

    fun setDescriptionGravity(textGravity: Int) {
        descriptionGravity = textGravity
        initializeView()
    }

    fun setSubtitleTextStyle(typeface: Int) {
        subtitleTextStyle = typeface
        initializeView()
    }

    fun setTitleTextStyle(typeface: Int) {
        titleTextStyle = typeface
        initializeView()
    }

    fun setDescriptionTextStyle(typeface: Int) {
        descriptionTextStyle = typeface
        initializeView()
    }

    fun setOnLeftImageClickListener(onClick: (() -> Unit)) {
        leftImageClick = onClick
        initializeView()
    }

    fun setOnRightImageClickListener(onClick: (() -> Unit)) {
        rightImageClick = onClick
        initializeView()
    }

    fun setOnBackgroundImageClickListener(onClick: (() -> Unit)) {
        backgroundImageClick = onClick
        initializeView()
    }

    fun setOnPrimaryButtonClickListener(onClick: (() -> Unit)) {
        primaryButtonClick = onClick
        initializeView()
    }

    fun setOnSecondaryButtonClickListener(onClick: (() -> Unit)) {
        secondaryButtonClick = onClick
        initializeView()
    }

    fun setOnSingleButtonClickListener(onClick: (() -> Unit)) {
        singleButtonClick = onClick
        initializeView()
    }

    fun setPrimaryButtonTextRes(@StringRes btnText: Int) {
        setPrimaryButtonText(context.getString(btnText))
    }

    fun setPrimaryButtonText(btnText: String) {
        primaryButtonText = btnText
        initializeView()
    }

    fun setPrimaryButtonStyle(@StyleRes btnStyle: Int) {
        primaryButtonStyle = btnStyle
        initializeView()
    }

    fun setSecondaryButtonTextRes(@StringRes btnText: Int) {
        setSecondaryButtonText(context.getString(btnText))
    }

    fun setSecondaryButtonText(btnText: String) {
        secondaryButtonText = btnText
        initializeView()
    }

    fun setSecondaryButtonStyle(@StyleRes btnStyle: Int) {
        secondaryButtonStyle = btnStyle
        initializeView()
    }

    fun setSingleButtonTextRes(@StringRes btnText: Int) {
        setSingleButtonText(context.getString(btnText))
    }

    fun setSingleButtonText(btnText: String) {
        singleButtonText = btnText
        initializeView()
    }

    fun setSingleButtonStyle(@StyleRes btnStyle: Int) {
        singleButtonStyle = btnStyle
        initializeView()
    }

    fun setBackgroundTintButtonPrimary(tintColor: String) {
        primaryButtonTint = tintColor
        initializeView()
    }

    fun setBackgroundTintButtonSecondary(tintColor: String) {
        secondaryButtonTint = tintColor
        initializeView()
    }

    fun setButtonTextSizeRes(@DimenRes dimenId: Int) {
        setButtonTextSize(
            pxToSp(
                context,
                context.resources.getDimensionPixelSize(dimenId).toFloat()
            )
        )
    }

    fun setButtonTextSize(btnTextSize: Float) {
        this.btnTextSize = btnTextSize
        initializeView()
    }

    companion object {
        const val GRAVITY_BOTTOM = 80
        const val GRAVITY_CENTER = 17
        const val GRAVITY_CENTER_HORIZONTAL = 1
        const val GRAVITY_CENTER_VERTICAL = 16
        const val GRAVITY_END = 8388613
        const val GRAVITY_LEFT = 3
        const val NO_GRAVITY = 0
        const val GRAVITY_RIGHT = 5
        const val GRAVITY_START = 8388611
        const val GRAVITY_TOP = 48
        const val POSITION_LEFT = 1
        const val POSITION_RIGHT = 2
        const val POSITION_TOP = 3
        const val POSITION_BOTTOM = 4
        const val TEXT_STYLE_NORMAL = 0
        const val TEXT_STYLE_BOLD = 1
        const val TEXT_STYLE_ITALIC = 2
        const val TEXT_STYLE_BOLD_ITALIC = 3
        private fun pxToSp(context: Context, px: Float) =
            (px / context.resources.displayMetrics.scaledDensity)

        private fun dpToPx(context: Context, dp: Int) =
            (dp * context.resources.displayMetrics.density).toInt()
    }
}
