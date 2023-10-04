package com.zopsmart.pagenics.components.zsmessage

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.isVisible
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.SnackbarContentLayout
import com.zopsmart.pagenics.components.R
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DEFAULT_ACTION_TEXT
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DEFAULT_MESSAGE_TEXT

class ZsMessage(private val context: Context) {
    private var textColor: Int = Color.BLACK
    private var tfTextView: Typeface? = null
    private var message: String = DEFAULT_MESSAGE_TEXT
    private var msgTextSize: Float? = null
    private var actionTextSize: Float? = null
    private var action1TextColor: Int = Color.BLUE
    private var action2TextColor: Int = Color.BLUE
    private var duration: Int = Snackbar.LENGTH_INDEFINITE
    private var action1: ((Snackbar) -> Unit)? = null
    private var action2: ((Snackbar) -> Unit)? = null
    private var button1Name: String = DEFAULT_ACTION_TEXT
    private var button2Name: String = DEFAULT_ACTION_TEXT
    private var backgroundColor: Int = Color.WHITE
    private var tfActionBtn1: Typeface? = null
    private var tfActionBtn2: Typeface? = null
    private var isAnimation: Boolean = false
    private var iconDrawable: Drawable? = null
    private lateinit var zsMessage: Snackbar

    fun textTypeface(textTypeface: Typeface) {
        tfTextView = textTypeface
    }
    fun getTypeface() = tfTextView

    fun animationAllowed(isAnimation: Boolean) {
        this.isAnimation = isAnimation
    }

    fun setIconRes(@DrawableRes icon: Int) {
        ContextCompat.getDrawable(context, icon)?.let { setIcon(it) }
    }

    fun setIcon(drawable: Drawable) {
        this.iconDrawable = drawable
    }

    fun setMsgTextSizeRes(@DimenRes dimenId: Int) {
        setMsgTextSize(context.resources.getDimension(dimenId))
    }

    fun setMsgTextSize(msgTextSize: Float) {
        this.msgTextSize = msgTextSize
    }
    fun getMsgTextSize() = msgTextSize

    fun setActionTextSizeRes(@DimenRes dimenId: Int) {
        setActionTextSize(context.resources.getDimension(dimenId))
    }

    fun setActionTextSize(actionTextSize: Float) {
        this.actionTextSize = actionTextSize
    }
    fun getActionTextSize() = actionTextSize

    fun action1Typeface(actionTypeface: Typeface) {
        tfActionBtn1 = actionTypeface
    }
    fun getAction1Typeface() = tfActionBtn1

    fun action2Typeface(actionTypeface: Typeface) {
        tfActionBtn2 = actionTypeface
    }

    fun getAction2Typeface() = tfActionBtn2

    fun withAction1(@StringRes resId: Int, action: (Snackbar) -> Unit) {
        withAction1(context.getString(resId), action)
    }

    fun withAction1(actionText: String, action: (Snackbar) -> Unit) {
        this.action1 = action
        this.button1Name = actionText
    }

    fun withAction2(@StringRes resId: Int, action: (Snackbar) -> Unit) {
        withAction2(context.getString(resId), action)
    }

    fun withAction2(actionText: String, action: (Snackbar) -> Unit) {
        this.action2 = action
        this.button2Name = actionText
    }

    fun messageRes(@StringRes message: Int) {
        message(context.getString(message))
    }

    fun message(message: String) {
        this.message = message
    }

    fun getZsMessageMsg() = message

    fun backgroundColorRes(@ColorRes colorId: Int) {
        backgroundColor(ContextCompat.getColor(context, colorId))
    }

    fun backgroundColor(@ColorInt color: Int) {
        this.backgroundColor = color
    }

    fun getBackgroundColor() = backgroundColor

    fun textColorRes(@ColorRes colorId: Int) {
        textColor(ContextCompat.getColor(context, colorId))
    }

    fun textColor(@ColorInt color: Int) {
        this.textColor = color
    }

    fun getTextColor() = textColor

    fun action1TextColorRes(@ColorRes colorId: Int) {
        action1TextColor(ContextCompat.getColor(context, colorId))
    }

    fun action1TextColor(@ColorInt actionTextColor: Int) {
        this.action1TextColor = actionTextColor
    }
    fun getAction1TextColor() = action1TextColor

    fun action2TextColorRes(@ColorRes colorId: Int) {
        action2TextColor(ContextCompat.getColor(context, colorId))
    }

    fun action2TextColor(@ColorInt actionTextColor: Int) {
        this.action2TextColor = actionTextColor
    }

    fun getAction2TextColor() = action2TextColor

    fun show(): ZsMessage {
        (context as Activity).findViewById<View>(android.R.id.content)?.apply {
            makeMessage(this)
        }
        zsMessage.apply {
            val view = this.view
            view.layoutParams = (view.layoutParams as FrameLayout.LayoutParams).apply {
                this.setMargins(0, 0, 0, 0)
                gravity = Gravity.TOP
            }
            ViewCompat.setElevation(view, 60f)
            view.setBackgroundColor(backgroundColor)
            if (isAnimation) animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
            show()
        }
        return this
    }

    private fun makeMessage(view: View) {
        zsMessage = Snackbar.make(view, message, duration)
        val snackBarLayout = (zsMessage.view) as Snackbar.SnackbarLayout
        LayoutInflater.from(context).inflate(R.layout.zs_message_layout, null)?.let {
            (snackBarLayout.getChildAt(0) as SnackbarContentLayout).visibility = View.GONE
            snackBarLayout.addView(it)
            setZsMessage(it)
        }
    }

    private fun setZsMessage(view: View) {
        view.findViewById<ConstraintLayout>(R.id.cl_message).apply {
            setBackgroundColor(backgroundColor)
        }
        view.findViewById<TextView>(R.id.tv_message).apply {
            text = message
            msgTextSize?.let { setTextSize(TypedValue.COMPLEX_UNIT_SP, it) }
            setTextColor(textColor)
            typeface = tfTextView
        }
        if (((action1 == null && action2 != null) || (action1 != null && action2 == null)) && ((message.length < 45 && iconDrawable == null) || message.length < 35)) {
            view.findViewById<TextView>(R.id.btn_action).apply {
                isVisible = true
                action1?.let {
                    setActionData(this, true)
                } ?: run {
                    action2?.let {
                        setActionData(this, false)
                    }
                }
            }
        } else {
            view.findViewById<TextView>(R.id.btn_action1).apply {
                action1?.let {
                    view.findViewById<ConstraintLayout>(R.id.cl_action_layout).isVisible = true
                    isVisible = true
                    setActionData(this, true)
                } ?: run {
                    isVisible = false
                }
            }
            view.findViewById<TextView>(R.id.btn_action2).apply {
                action2?.let {
                    view.findViewById<ConstraintLayout>(R.id.cl_action_layout).isVisible = true
                    isVisible = true
                    setActionData(this, false)
                } ?: run {
                    isVisible = false
                }
            }
        }
        view.findViewById<ShapeableImageView>(R.id.iv_image).apply {
            iconDrawable?.let {
                isVisible = true
                background = iconDrawable
            } ?: run {
                isVisible = false
            }
        }
    }

    private fun setActionData(textView: TextView, isFirstAction: Boolean) {
        textView.apply {
            typeface = if (isFirstAction) tfActionBtn1 else tfActionBtn2
            text = if (isFirstAction) button1Name else button2Name
            setTextColor(if (isFirstAction) action1TextColor else action2TextColor)
            actionTextSize?.let { setTextSize(TypedValue.COMPLEX_UNIT_SP, it) }
            setOnClickListener {
                (if (isFirstAction) action1 else action2)?.invoke(zsMessage)
                dismiss()
            }
        }
    }

    fun dismiss() {
        if (::zsMessage.isInitialized) {
            zsMessage.dismiss()
        }
    }
}
