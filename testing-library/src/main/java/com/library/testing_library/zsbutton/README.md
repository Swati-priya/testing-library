# ZsButton

ZsButton, a custom button which helps user to customize the button appearance according to their
need.
It supports background color, corner radius, Text, Icon, Disable/Enable states, Loading state.
To read more about Buttons - https://m3.material.io/components/all-buttons

## How to use:

#### Using view attributes:

```
<com.zopsmart.pagenics.components.zsbutton.ZsButton
    android:id="@+id/btn"
    android:layout_width="match_parent"
    android:layout_height="@dimen/margin_50"
    android:layout_marginBottom="@dimen/margin_16"
    app:zs_fontFamily="@font/open_sans_bold"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:zs_backgroundColor="@color/bg_grey"
    app:zs_borderColor="@color/black"
    app:zs_borderWidth="@dimen/margin_2"
    app:zs_drawableResource="@drawable/ic_backup"
    app:zs_focusColor="@color/bg_grey"
    app:zs_gravity="center"
    app:zs_radius="@dimen/margin_6"
    app:zs_text="Button"
    app:zs_textAllCaps="true"
    app:zs_textSize="@dimen/text_size_12"
    app:zs_textStyle="bold" />
```

#### Using properties:

```
btn.apply {
    setText(data)
    setRadius(25f)
    setBackgroundColorRes(R.color.teal_200)
    setBorderWidth(2)
    setTextSize(16f)
    setAllCaps(true)
    // using fontFamily typeface
    ResourcesCompat.getFont(R.font.open_sans_bold)?.let{
        setFontFamily(it)
    }
    // using font resource
    setFontFamilyRes(R.font.open_sans_bold)
    ContextCompat.getDrawable(context, R.drawable.ic_backup)?.let { setIcon(it) }
    setBorderColor(ContextCompat.getColor(context,R.color.bluish_green))
}
```

![This is ZsButton](https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zsbuttons.png)

## Properties:

| S.No. | XML Attribute                                 | Property                            | Parameter                       | Description                                                                     | Default value |
|-------|-----------------------------------------------|-------------------------------------|---------------------------------|---------------------------------------------------------------------------------|---------------|
| 1.    | app:zs_text="Button"                          | setText/setTextRes                  | String /String resource         | Helps to set button text for ZsButton                                           | -             |
| 2.    | app:zs_textSize="@dimen/text_size_12"         | setTextSize/setTextSizeRes          | float value/ dimen resource     | Helps to set button text size for ZsButton                                      | 12f           |
| 3.    | app:zs_textAllCaps="true"                     | setAllCaps                          | Boolean                         | Helps to set text in caps                                                       | false         |
| 4.    | app:zs_textStyle="bold"                       | setTextStyle                        | Int value                       | Helps to set text style for ZsButton                                            | Normal        |
| 5.    | app:zs_textColor="@color/bg_grey"             | setTextColor/setTextColorRes        | Int color value/ Color resource | Helps to set button text color                                                  | BLACK         |
| 6.    | app:zs_backgroundColor="@color/bg_grey"       | setBackgroundColor                  | Int color value/ Color resource | Helps to set background color of the ZsButton                                   | TRANSPARENT   |
| 7.    | app:zs_borderColor="@color/black"             | setBorderColorRes/setBorderColor    | Color resource/Int color value  | Helps to set border color of the ZsButton                                       | TRANSPARENT   |
| 8.    | app:zs_borderWidth="@dimen/margin_2"          | setBorderWidth                      | Int value                       | Helps to set the ZsButton border width                                          | 0             |
| 9.    | app:zs_drawableResource="@drawable/ic_backup" | setIconRes/ setIcon                 | Drawable Resource/ Drawable     | Helps to set ZsButton icon                                                      | -             |
| 10.   | app:zs_focusColor="@color/bg_grey"            | setFocusedColor/ setFocusedColorRes | Int color value /Color resource | Helps to set ZsButton focused color                                             | LIGHT GRAY    |
| 11.   | app:zs_gravity="center"                       | setTextGravity                      | Int value                       | Helps to set ZsButton gravity(center: 0 , left: 1, right: 2, top: 3, bottom: 4) | Center        |
| 12.   | app:zs_radius="@dimen/margin_6"               | setRadius/setRadiusRes              | Int color value/ dimen resource | Helps to set ZsButton radius                                                    | 0             |
| 13.   | app:zs_iconPadding="@dimen/margin_2"          | setIconPadding                      | Int value                       | Helps to set padding between icon and text.                                     | 16            |
| 14.   | app:zs_iconPosition="left"                    | setIconPosition                     | Int value                       | Helps to set icon position(left: 1,right: 2,top: 3,bottom: 4)                   | Left          |
| 15.   | app:zs_fontFamily="@font/open_sans_bold"      | setFontFamilyRes/ setFontFamily     | Typeface                        | Helps to set action2 typeface                                                   | -             |
| 16.   | app:zs_enabled="true"                         | setViewEnabled                      | Boolean                         | Helps to enable/disable the view                                                | false         |
| 17.   | android:padding="@dimen/margin_2"             | setPadding                          | Int value                       | Helps to set padding in ZsButton                                                | 0             |
| 18.   | -                                             | enableLoadingState                  | Boolean                         | Helps to switch loading state in ZsButton                                       | false         |
