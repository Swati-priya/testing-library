package com.zopsmart.pagenics

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.library.myapplication.R
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DEFAULT_ACTION_TEXT
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DEFAULT_FIRST_ACTION
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DEFAULT_MESSAGE_TEXT
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DEFAULT_SECOND_ACTION
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.DEFAULT_ZSMESSAGE
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.LISTVIEW
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.ZS_BANNER
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.ZS_BUTTON
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.ZS_MESSAGE
import com.zopsmart.pagenics.components.pagenics_constants.PagenicsConstants.Companion.ZS_SNACKBAR
import com.zopsmart.pagenics.components.zsmessage.ZsMessage
import com.zopsmart.pagenics.components.zssnackbar.ZsSnackBar
import com.library.myapplication.zsbuttonsample.ButtonDialogFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(modifier = Modifier.testTag(LISTVIEW).padding(8.dp)) {
                itemsIndexed(
                    mutableListOf<String>().apply {
                        add(ZS_SNACKBAR)
                        add(ZS_MESSAGE)
                        add(ZS_BUTTON)
                        add(ZS_BANNER)
                    }
                ) { index, data ->
                    OutlinedButton(
                        onClick = {
                            when (index) {
                                0 -> {
                                    ZsSnackBar(this@MainActivity).apply {
                                        actionTextColor(Color.BLUE)
                                        withAction(DEFAULT_ACTION_TEXT) { showToast() }
                                        cornerRadius(15f)
                                        message(DEFAULT_MESSAGE_TEXT)
                                        backgroundColor(Color.LTGRAY)
                                        textColor(Color.BLACK)
                                        padding(30)
                                        animationAllowed(true)
                                        // For adding gradiant
                                        gradiantDrawable(
                                            GradientDrawable(
                                                GradientDrawable.Orientation.LEFT_RIGHT,
                                                intArrayOf(
                                                    setGradiantDrawableColor(R.color.soft_red),
                                                    setGradiantDrawableColor(R.color.teal_200),
                                                    setGradiantDrawableColor(R.color.lemon_yellow),
                                                    setGradiantDrawableColor(R.color.bluish_green)
                                                )
                                            ).apply {
                                                cornerRadius = 10f
                                            }
                                        )
                                        show()
                                    }
                                }
                                1 -> {
                                    ZsMessage(this@MainActivity).apply {
                                        action1TextColor(Color.BLUE)
                                        withAction1(DEFAULT_FIRST_ACTION) { showToast() }
                                        action2TextColor(Color.BLUE)
                                        withAction2(DEFAULT_SECOND_ACTION) { dismiss() }
                                        message(DEFAULT_ZSMESSAGE)
                                        backgroundColor(Color.WHITE)
                                        textColor(Color.BLACK)
                                        setActionTextSize(15f)
                                        setMsgTextSize(18f)
                                        textTypeface(Typeface.MONOSPACE)
                                        action1Typeface(Typeface.DEFAULT_BOLD)
                                        action2Typeface(Typeface.DEFAULT_BOLD)
                                        animationAllowed(false)
                                        setIconRes(R.drawable.marguerite)
                                        show()
                                    }
                                }
                                2 -> {
                                    ButtonDialogFragment.newInstance().show(supportFragmentManager, ZS_BUTTON)
                                }
                                3 -> {
                                    ButtonDialogFragment.newInstance().show(supportFragmentManager, ZS_BANNER)
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = androidx.compose.ui.graphics.Color.LightGray,
                            contentColor = androidx.compose.ui.graphics.Color.Black
                        )
                    ) {
                        Text(
                            text = data,
                            modifier = Modifier,
                            style = MaterialTheme.typography.body2,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

    private fun setGradiantDrawableColor(color: Int) =
        ContextCompat.getColor(this@MainActivity, color)

    private fun showToast() {
        Toast.makeText(
            applicationContext,
            getString(R.string.hurray_toast),
            Toast.LENGTH_LONG
        ).show()
    }
}
