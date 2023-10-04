package com.zopsmart.pagenics.components.zsbutton

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.zopsmart.pagenics.components.R

class ZsButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {
    private var paddingLeft: Int = 0
    private var padding = 0
    private var paddingRight: Int = 0
    private var paddingTop: Int = 0
    private var paddingBottom: Int = 0
    private var paddingHorizontal: Int = 0
    private var paddingVertical: Int = 0
    private var gravity: Int = Gravity.CENTER
    private var isBtnEnabled: Boolean = true
    private var isFocused: Boolean = true
    private var radius: Float = 0f
    private var backgroundColor: Int = Color.TRANSPARENT
    private var focusColor: Int = Color.LTGRAY
    private var borderColor: Int = Color.TRANSPARENT
    private var borderWidth: Int = 0
    private var textColor: Int = Color.BLACK
    private var textDisabledColor: Int = Color.GRAY
    private var btnTextSize: Float = 12f
    private var btnTextSizeRes: Int = 0
    private var textAllCaps: Boolean = false
    private var textStyle: Int = TEXT_STYLE_NORMAL
    private var btnText: String? = null
    private var iconDrawable: Drawable? = null
    private var drawableResource = 0
    private var textView: TextView? = null
    private var imageView: ImageView? = null
    private var fontFamily: Int = 0
    private var fontTypeface: Typeface? = null
    private var iconPosition: Int = POSITION_LEFT
    private val fixedIconPadding: Int = 16
    private var iconPadding: Int = 0
    private var isLoadingState: Boolean = false
    private var progressBar: ProgressBar? = null
    private var textGravity: Int = GRAVITY_CENTER

    init {
        val attrsArray = context.obtainStyledAttributes(attrs, R.styleable.ZsButton, 0, 0)
        initAttributes(attrsArray)
        attrsArray.recycle()
        initializeView()
    }

    private fun initAttributes(attrs: TypedArray) {
        radius = attrs.getDimension(R.styleable.ZsButton_zs_radius, radius)
        borderColor = attrs.getColor(R.styleable.ZsButton_zs_borderColor, borderColor)
        borderWidth =
            attrs.getDimension(R.styleable.ZsButton_zs_borderWidth, borderWidth.toFloat()).toInt()
        backgroundColor = attrs.getColor(R.styleable.ZsButton_zs_backgroundColor, backgroundColor)
        focusColor = attrs.getColor(R.styleable.ZsButton_zs_focusColor, focusColor)
        btnText = attrs.getString(R.styleable.ZsButton_zs_text)
        textColor = attrs.getColor(R.styleable.ZsButton_zs_textColor, textColor)
        textDisabledColor =
            attrs.getColor(R.styleable.ZsButton_zs_disabledTextColor, textDisabledColor)
        btnTextSizeRes = attrs.getDimensionPixelSize(R.styleable.ZsButton_zs_textSize, btnTextSizeRes)
        textStyle = attrs.getInt(R.styleable.ZsButton_zs_textStyle, textStyle)
        textAllCaps = attrs.getBoolean(R.styleable.ZsButton_zs_textAllCaps, textAllCaps)
        iconPosition = attrs.getInt(R.styleable.ZsButton_zs_iconPosition, iconPosition)
        drawableResource =
            attrs.getResourceId(R.styleable.ZsButton_zs_drawableResource, drawableResource)
        iconPadding =
            attrs.getDimensionPixelSize(R.styleable.ZsButton_zs_iconPadding, iconPadding)
        paddingBottom =
            attrs.getDimensionPixelSize(R.styleable.ZsButton_zs_paddingBottom, paddingBottom)
        paddingTop =
            attrs.getDimensionPixelSize(R.styleable.ZsButton_zs_paddingTop, paddingTop)
        paddingLeft =
            attrs.getDimensionPixelSize(R.styleable.ZsButton_zs_paddingLeft, paddingLeft)
        paddingRight =
            attrs.getDimensionPixelSize(R.styleable.ZsButton_zs_paddingRight, paddingRight)
        paddingHorizontal =
            attrs.getDimensionPixelSize(
                R.styleable.ZsButton_zs_PaddingHorizontal,
                paddingHorizontal
            )
        paddingVertical =
            attrs.getDimensionPixelSize(R.styleable.ZsButton_zs_PaddingVertical, paddingVertical)
        padding =
            attrs.getDimensionPixelSize(R.styleable.ZsButton_zs_Padding, padding)
        gravity = attrs.getInt(R.styleable.ZsButton_zs_gravity, gravity)
        isBtnEnabled = attrs.getBoolean(R.styleable.ZsButton_zs_enabled, isBtnEnabled)
        fontFamily = attrs.getResourceId(R.styleable.ZsButton_zs_fontFamily, 0)
    }

    private fun initializeView() {
        orientation = if (iconPosition == POSITION_TOP || iconPosition == POSITION_BOTTOM) {
            VERTICAL
        } else {
            HORIZONTAL
        }
        if (layoutParams == null) {
            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        }
        super.setGravity(gravity)
        super.setEnabled(isBtnEnabled)
        isClickable = isBtnEnabled
        isFocusable = isFocused
        setupBackground()
        setupText()
        setupIcon()
        setupLoader()
        if (padding != 0) {
            super.setPadding(padding, padding, padding, padding)
        } else if (paddingHorizontal != 0 && paddingVertical != 0) {
            super.setPadding(paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical)
        } else if (paddingVertical != 0) {
            super.setPadding(paddingLeft, paddingVertical, paddingRight, paddingVertical)
        } else if (paddingHorizontal != 0) {
            super.setPadding(paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical)
        } else {
            super.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
        }
        removeAllViews()
        if (isLoadingState) {
            addView(progressBar)
            isBtnEnabled = false
            super.setEnabled(false)
            isClickable = isBtnEnabled
            isFocusable = isFocused
        } else if (iconPosition == POSITION_RIGHT || iconPosition == POSITION_BOTTOM) {
            if (textView != null) addView(textView)
            if (imageView != null) addView(imageView)
        } else {
            if (imageView != null) addView(imageView)
            if (textView != null) addView(textView)
        }
        updateGravity()
    }

    private fun setupBackground() {
        background = getRippleDrawable(
            GradientDrawable().apply { // for default drawable
                cornerRadius = radius
                setColor(backgroundColor)
                if (borderColor != 0 && borderWidth > 0) {
                    setStroke(borderWidth, borderColor)
                }
            },
            GradientDrawable().apply { // for focused drawable
                cornerRadius = radius
                setColor(focusColor)
            }
        )
        alpha = if (isBtnEnabled) 1.0f else 0.6f
    }

    private fun getRippleDrawable(
        defaultDrawable: Drawable,
        focusDrawable: Drawable
    ) = RippleDrawable(ColorStateList.valueOf(focusColor), defaultDrawable, focusDrawable)

    private fun setupLoader() {
        progressBar = ProgressBar(context).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT).apply {
                    setMargins(0, 8, 0, 8)
                }
        }
    }

    private fun setupText() {
        btnText?.let {
            textView = TextView(context).apply {
                id = R.id.tv_button
                layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                text = it
                setTextColor(if (isBtnEnabled) textColor else textDisabledColor)
                textSize = if (btnTextSizeRes != 0) pxToSp(context, btnTextSizeRes.toFloat()) else btnTextSize
                isAllCaps = textAllCaps
                when (textStyle) {
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
                if (fontFamily > 0) {
                    typeface = ResourcesCompat.getFont(context, fontFamily)
                }
                if (fontTypeface != null) {
                    typeface = fontTypeface
                }
            }
            textView?.gravity = gravity
        }
    }

    private fun setupIcon() {
        if (drawableResource != 0 || iconDrawable != null) {
            imageView = ImageView(context).apply {
                id = R.id.iv_icon
                if (drawableResource != 0) {
                    setImageResource(drawableResource)
                } else {
                    setImageDrawable(iconDrawable)
                }
            }
            val drawablePadding = if (iconPadding != 0) iconPadding else fixedIconPadding
            imageView?.layoutParams =
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
                    btnText?.let {
                        when (iconPosition) {
                            POSITION_TOP -> {
                                setMargins(0, 0, 0, drawablePadding)
                            }
                            POSITION_RIGHT -> {
                                setMargins(drawablePadding, 0, 0, 0)
                            }
                            POSITION_BOTTOM -> {
                                setMargins(0, drawablePadding, 0, 0)
                            }
                            else -> {
                                setMargins(0, 0, drawablePadding, 0)
                            }
                        }
                    }
                }
        }
    }

    private fun updateGravity() {
        when (textGravity) {
            GRAVITY_CENTER -> {
                super.setGravity(Gravity.CENTER)
            }
            GRAVITY_LEFT -> {
                super.setGravity(Gravity.START or Gravity.CENTER_VERTICAL)
            }
            GRAVITY_RIGHT -> {
                super.setGravity(Gravity.END or Gravity.CENTER_VERTICAL)
            }
            GRAVITY_TOP -> {
                super.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)
            }
            GRAVITY_BOTTOM -> {
                super.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL)
            }
        }
    }

    fun setViewEnabled(enabled: Boolean) {
        isBtnEnabled = enabled
        initializeView()
    }

    fun isButtonEnabled() = isBtnEnabled

    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        super.setPadding(left, top, right, bottom)
        paddingLeft = left
        paddingRight = right
        paddingBottom = bottom
        paddingTop = top
        initializeView()
    }

    fun setHorizontalPadding(horizontalPadding: Int) {
        paddingHorizontal = horizontalPadding
        initializeView()
    }

    fun setVerticalPadding(verticalPadding: Int) {
        paddingVertical = verticalPadding
        initializeView()
    }

    fun setLeftPadding(leftPadding: Int) {
        paddingLeft = leftPadding
        initializeView()
    }

    fun setRightPadding(rightPadding: Int) {
        paddingRight = rightPadding
        initializeView()
    }

    fun setTopPadding(TopPadding: Int) {
        paddingTop = TopPadding
        initializeView()
    }

    fun setBottomPadding(bottomPadding: Int) {
        paddingBottom = bottomPadding
        initializeView()
    }

    fun setBorderWidth(width: Int) {
        borderWidth = width
        setupBackground()
    }

    fun getBorderWidth() = borderWidth

    fun setBorderColorRes(@ColorRes colorId: Int) {
        setBorderColor(ContextCompat.getColor(context, colorId))
    }

    fun setBorderColor(@ColorInt color: Int) {
        borderColor = color
        setupBackground()
    }

    fun getBorderColor() = borderColor

    fun setBackgroundColorRes(@ColorRes colorId: Int) {
        setBackgroundColor(ContextCompat.getColor(context, colorId))
    }

    override fun setBackgroundColor(@ColorInt color: Int) {
        backgroundColor = color
        setupBackground()
    }

    fun getBackgroundColor() = backgroundColor

    fun setFocusedColorRes(@ColorRes colorId: Int) {
        setFocusedColor(ContextCompat.getColor(context, colorId))
    }

    fun setFocusedColor(@ColorInt color: Int) {
        focusColor = color
        setupBackground()
    }

    fun getFocusedColor() = focusColor

    fun setAllCaps(allCaps: Boolean) {
        textAllCaps = allCaps
        initializeView()
    }

    fun getWhetherTextAllCaps() = textAllCaps

    fun enableLoadingState(isLoadingState: Boolean) {
        this.isLoadingState = isLoadingState
        initializeView()
    }

    fun setFontFamilyRes(@FontRes fontFamilyId: Int) {
        fontFamily = fontFamilyId
        initializeView()
    }

    fun setFontFamily(fontTypeface: Typeface) {
        this.fontTypeface = fontTypeface
        initializeView()
    }

    fun getFontFamily() = fontTypeface

    fun setRadiusRes(@DimenRes dimenId: Int) {
        setRadius(context.resources.getDimension(dimenId))
    }

    fun setRadius(radius: Float) {
        this.radius = radius
        setupBackground()
    }

    fun getRadius() = radius

    fun setTextRes(@StringRes msg: Int) {
        setText(context.getString(msg))
    }

    fun setText(msg: String) {
        btnText = msg
        if (textView != null) textView?.text = msg else setupText()
    }

    fun getBtnText() = btnText

    fun setTextSizeRes(@DimenRes dimenId: Int) {
        setTextSize(pxToSp(context, context.resources.getDimensionPixelSize(dimenId).toFloat()))
    }

    fun setTextSize(btnTextSize: Float) {
        this.btnTextSize = btnTextSize
        initializeView()
    }

    fun getMsgTextSize() = btnTextSize

    fun setTextColorRes(@ColorRes colorId: Int) {
        setTextColor(ContextCompat.getColor(context, colorId))
    }

    fun setTextColor(@ColorInt color: Int) {
        textColor = color
        initializeView()
    }

    fun getTextColor() = textColor

    fun setDisabledTextColorRes(@ColorRes colorId: Int) {
        setDisabledTextColor(ContextCompat.getColor(context, colorId))
    }

    fun setDisabledTextColor(@ColorInt color: Int) {
        textDisabledColor = color
        initializeView()
    }

    fun getDisabledTextColor() = textDisabledColor

    fun setIconRes(@DrawableRes icon: Int) {
        drawableResource = icon
        initializeView()
    }

    fun setIcon(drawable: Drawable) {
        this.iconDrawable = drawable
        initializeView()
    }

    fun setIconPadding(iconPadding: Int) {
        this.iconPadding = iconPadding
        initializeView()
    }

    fun getIconPadding() = iconPadding

    fun setTextGravity(textGravity: Int) {
        this.textGravity = textGravity
        updateGravity()
    }

    fun setTextStyle(style: Int) {
        textStyle = style
        initializeView()
    }

    fun getTextStyle() = textStyle

    fun setIconPosition(position: Int) {
        iconPosition = position
        initializeView()
    }

    fun getIconPosition() = iconPosition

    companion object {
        const val POSITION_LEFT = 1
        const val POSITION_RIGHT = 2
        const val POSITION_TOP = 3
        const val POSITION_BOTTOM = 4
        const val GRAVITY_CENTER = 0
        const val GRAVITY_LEFT = 1
        const val GRAVITY_RIGHT = 2
        const val GRAVITY_TOP = 3
        const val GRAVITY_BOTTOM = 4
        const val TEXT_STYLE_NORMAL = 0
        const val TEXT_STYLE_BOLD = 1
        const val TEXT_STYLE_ITALIC = 2
        const val TEXT_STYLE_BOLD_ITALIC = 3
        private fun pxToSp(context: Context, px: Float) = (px / context.resources.displayMetrics.scaledDensity)
    }
}
