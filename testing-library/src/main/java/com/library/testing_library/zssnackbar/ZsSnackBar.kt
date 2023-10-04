package com.zopsmart.pagenics.components.zssnackbar

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.SnackbarContentLayout
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DEFAULT_ACTION_TEXT
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DEFAULT_MESSAGE_TEXT

class ZsSnackBar(private val context: Context) {
    private var textColor: Int = Color.WHITE
    private var actionTextColor: Int = Color.BLUE
    private var duration: Int = Snackbar.LENGTH_INDEFINITE
    private var drawable = GradientDrawable()
    private var message: String = DEFAULT_MESSAGE_TEXT
    private var padding: Int = 0
    private var customView: View? = null
    private var anchorView: View? = null
    private var action: ((Snackbar) -> Unit)? = null
    private var customViewAction: ((View) -> Unit)? = null
    private var buttonName: String = DEFAULT_ACTION_TEXT
    private var backgroundColor: Int = Color.TRANSPARENT
    private var borderWidth: Int = 0
    private var borderColor: Int = Color.TRANSPARENT
    private var cornerRadius: Float = 0f
    private var tfTextView: Typeface? = null
    private var tfActionBtn: Typeface? = null
    private var customDrawable: GradientDrawable? = null
    private var isAnimation: Boolean = false
    private lateinit var snackbar: Snackbar

    fun gradiantDrawableRes(@DrawableRes drawableId: Int) {
        val drw = ContextCompat.getDrawable(context, drawableId)
        if (drw is GradientDrawable) {
            gradiantDrawable(drw)
        }
    }

    fun gradiantDrawable(drawable: GradientDrawable?) {
        this.customDrawable = drawable
    }

    fun getGradiantDrawable() = customDrawable

    fun textTypeface(textTypeface: Typeface) {
        tfTextView = textTypeface
    }

    fun getTextTypeFace() = tfTextView

    fun animationAllowed(isAnimation: Boolean) {
        this.isAnimation = isAnimation
    }

    fun getWhetherAnimationAllowed() = isAnimation

    fun actionTypeface(actionTypeface: Typeface) {
        tfActionBtn = actionTypeface
    }

    fun withCustomView(customViewAction: ((View) -> Unit)?) {
        this.customViewAction = customViewAction
    }

    fun withAction(@StringRes resId: Int, action: (Snackbar) -> Unit) {
        withAction(context.getString(resId), action)
    }

    fun withAction(actionText: String, action: (Snackbar) -> Unit) {
        this.action = action
        this.buttonName = actionText
    }

    fun paddingRes(@DimenRes dimenId: Int) {
        padding(context.resources.getDimension(dimenId).toInt())
    }

    fun padding(padding: Int) {
        this.padding = padding
    }

    fun getPadding() = padding

    fun duration(duration: Int) {
        this.duration = duration
    }

    fun getDuration() = duration

    fun messageRes(@StringRes message: Int) {
        message(context.getString(message))
    }

    fun message(message: String) {
        this.message = message
    }

    fun getZsSnackBarMessage() = message

    fun customView(@LayoutRes layoutResource: Int) {
        customView(
            LayoutInflater.from(context).inflate(layoutResource, LinearLayout(context), false)
        )
    }

    fun customView(view: View) {
        this.customView = view
    }

    fun borderRes(@DimenRes dimenId: Int, @ColorRes colorId: Int) {
        border(
            context.resources.getDimension(dimenId).toInt(),
            ContextCompat.getColor(context, colorId)
        )
    }

    fun border(width: Int, @ColorInt color: Int) {
        this.borderWidth = width
        this.borderColor = color
    }

    fun cornerRadiusRes(@DimenRes dimenId: Int) {
        cornerRadius(context.resources.getDimension(dimenId))
    }

    fun cornerRadius(cornerRadius: Float) {
        this.cornerRadius = cornerRadius
    }

    fun getCornerRadius() = cornerRadius

    fun backgroundColorRes(@ColorRes colorId: Int) {
        backgroundColor(ContextCompat.getColor(context, colorId))
    }

    fun backgroundColor(@ColorInt color: Int) {
        this.backgroundColor = color
    }

    fun textColorRes(@ColorRes colorId: Int) {
        textColor(ContextCompat.getColor(context, colorId))
    }

    fun textColor(@ColorInt color: Int) {
        this.textColor = color
    }

    fun actionTextColorRes(@ColorRes colorId: Int) {
        actionTextColor(ContextCompat.getColor(context, colorId))
    }

    fun actionTextColor(@ColorInt actionTextColor: Int) {
        this.actionTextColor = actionTextColor
    }

    fun show(): ZsSnackBar {
        (context as Activity).findViewById<View>(android.R.id.content)?.apply {
            makeSnackbar(this)
        }
        snackbar.apply {
            if (isAnimation) animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
            show()
        }
        return this
    }

    private fun makeSnackbar(view: View) {
        snackbar = Snackbar.make(view, message, duration)
        val snackbarLayout = (snackbar.view) as Snackbar.SnackbarLayout // Frame Layout
        val snackContentLayout =
            snackbarLayout.getChildAt(0) as SnackbarContentLayout // Linear Layout
        customDrawable?.let {
            drawable = customDrawable as GradientDrawable
        } ?: run {
            if (backgroundColor != 0) {
                drawable.setColor(backgroundColor)
            } else {
                drawable = snackbarLayout.background as GradientDrawable
            }
            drawable.cornerRadius = cornerRadius
            drawable.setStroke(borderWidth, borderColor)
        }

        snackbarLayout.apply {
            setBackgroundColor(Color.TRANSPARENT)
            setPadding(0, 0, 0, 0)
        }
        snackContentLayout.apply {
            setPadding(snackbarLayout.paddingLeft, 0, snackbarLayout.paddingRight, 0)
            background = drawable
        }
        if (padding > 0) {
            snackbarLayout.setPadding(padding, 0, padding, padding)
        }

        customView?.let {
            snackContentLayout.visibility = View.GONE
            snackbarLayout.addView(it)
            customViewAction?.invoke(it)
        } ?: run {
            (snackContentLayout.getChildAt(0) as AppCompatTextView).apply {
                setTextColor(textColor)
                if (tfTextView != null) {
                    typeface = tfTextView
                }
            }
            (snackContentLayout.getChildAt(1) as AppCompatButton).apply {
                setTextColor(actionTextColor)
                if (tfActionBtn != null) {
                    typeface = tfActionBtn
                }
            }
            action?.let {
                snackbar.setAction(buttonName) {
                    action?.invoke(snackbar)
                }
            }
        }
    }

    fun dismiss() {
        if (::snackbar.isInitialized) {
            snackbar.dismiss()
        }
    }
}
