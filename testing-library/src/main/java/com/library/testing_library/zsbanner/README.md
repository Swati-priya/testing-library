# ZsBanner

ZsBanner, a custom banner view which helps user to capture consumers’ attention by customizing it as per their need.
It can be a banner with image as left/right align or a banner with image as it's background.

## How to use:

#### Using view attributes:

```
<com.zopsmart.pagenics.components.zsbanner.ZsBanner
   android:id="@+id/zs_banner"
   android:layout_width="@dimen/margin_0"
   android:layout_height="wrap_content"
   android:layout_marginBottom="@dimen/margin_16"
   app:layout_constraintStart_toStartOf="parent"
   app:layout_constraintEnd_toEndOf="parent"
   app:layout_constraintBottom_toBottomOf="parent"
   app:layout_constraintTop_toTopOf="parent"
   app:zsBanner_title="It's a banner"
   app:zsBanner_subtitle="It's subtitle section"
   app:zsBanner_description="Its a description sections"
   app:zsBanner_IsBannerWithBackgroundImage="true"
   app:zsBanner_backgroundDrawable="@drawable/button_background"
   app:zsBanner_IsBannerWithButton="true"
   app:zsBanner_gravity="center"
   app:zsBanner_primary_button_style="@style/button_compact"
   app:zsBanner_setBackgroundTintButtonPrimary="@string/primary_color"/>
```

#### Using properties:

```
zsBanner.apply {
   setTitle("Banner with Right Image")
   setTitleAllCaps(true)
   setTitleColor(Color.BLACK)
   setBannerFontFamilyRes(com.zopsmart.pagenics.components.R.font.open_sans_bold)
   setSubTitle("This is subtitle")
   setSubTitleAllCaps(false)
   setSubtitleColor(Color.BLACK)
   setSubtitleStyle(Typeface.NORMAL)
   isBannerWithTwoButton(true)
   setBackgroundTintButtonPrimary("#FB586C")
   setBackgroundTintButtonSecondary("#6AB2AD")
   setPrimaryButtonStyle(com.zopsmart.pagenics.components.R.style.button_compact_1)
   setOnRightImageClickListener { callToast() }
   setOnPrimaryButtonClickListener { callToast() }
   setOnSecondaryButtonClickListener { callToast() }
   isBannerWithImageRightAlign(true)
   setDescription("This is a banner description ")
   setDescriptionColor(Color.BLACK)
   setDescriptionStyle(Typeface.ITALIC)
   setTextGravity(Gravity.CENTER)
   setBannerImageUrl("https://storage.googleapis.com/zopping-staging-uploads/originals%2F20230222%2Fcropped2723316702727382358-20230222-055653.jpg")
}
```

## ZsBanner Previews:

| Banner with Background Image                                                                                                                  | Banner with Left aligned Image                                                                                                           | Banner with Right aligned Image                                                                                                           |
|-----------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| <img src="https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zsbanner_with_background_image.png" width=92% height=50%> | <img src="https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zsBanner_with_left_image.png" width=100% height=50%> | <img src="https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zsBanner_with_right_image.png" width=100% height=50%> |


## Properties:

| S.No. | XML Attribute                                               | Property                                             | Parameter                                 | Description                                                | Default value |
|-------|-------------------------------------------------------------|------------------------------------------------------|-------------------------------------------|------------------------------------------------------------|---------------|
| 1.    | app:zsBanner_backgroundColor="@color/white"                 | setBannerBackgroundColor/setBackgroundColorRes       | Int color value/ Color resource           | Helps to set ZsBanner background color                     | White         |
| 2.    | app:zsBanner_primary_button_style="@style/button_compact"   | setPrimaryButtonStyle                                | Style resource                            | Helps to set ZsBanner primary button style                 | -             |
| 3.    | app:zsBanner_secondary_button_style="@style/button_compact" | setSecondaryButtonStyle                              | Style resource                            | Helps to set ZsBanner secondary button style               | -             |
| 4.    | app:zsBanner_single_button_style="@style/button_compact"    | setSingleButtonStyle                                 | Style resource                            | Helps to set ZsBanner single button style                  | -             |
| 5.    | app:zsBanner_buttonAllCaps="true"                           | setButtonAllCaps                                     | Boolean                                   | Helps to set ZsBanner button text in caps                  | false         |
| 6.    | app:zsBanner_setBackgroundTintButtonPrimary="#000000"       | setBackgroundTintButtonPrimary                       | String color(like: #000000)               | Helps to set ZsBanner button background in primary Color   | -             |
| 7.    | app:zsBanner_setBackgroundTintButtonSecondary="#000000"     | setBackgroundTintButtonSecondary                     | String color(like: #000000)               | Helps to set ZsBanner button background in secondary Color | -             |
| 8.    | app:zsBanner_primary_button_text="Button1"                  | setPrimaryButtonText/setPrimaryButtonTextRes         | String /String resource                   | Helps to set ZsBanner primary button text                  | -             |
| 9.    | app:zsBanner_secondary_button_text="Button"                 | setSecondaryButtonText/setSecondaryButtonTextRes     | String /String resource                   | Helps to set ZsBanner secondary button text                | -             |
| 10.   | app:zsBanner_single_button_text="Button"                    | setSingleButtonText/setSingleButtonTextRes           | String /String resource                   | Helps to set ZsBanner single button text                   | -             |
| 11.   | app:zsBanner_button_textSize="@dimen/margin_10"             | setButtonTextSize/setButtonTextSizeRes               | Int value/ dimen resource                 | Helps to set ZsBanner button text size                     | 12f           |
| 12.   | app:zsBanner_gravity="center"                               | setBannerGravity                                     | Int gravity value                         | Helps to set ZsBanner gravity                              | Center        |
| 13.   | app:zsBanner_left_image_ratio="0.4"                         | setLeftImageRatio                                    | Float (0.0 >=value<=1.0)                  | Helps to set left aligned image area                       | false         |
| 14.   | app:zsBanner_right_image_ratio="0.3"                        | setRightImageRatio                                   | Float (0.0 >=value<=1.0)                  | Helps to set left aligned image area                       | false         |
| 15.   | app:zsBanner_fontFamily="@font/open_sans_bold"              | setBannerFontFamilyRes                               | Font family resource                      | Helps to set ZsBanner font family                          | -             |
| 16.   | app:zsBanner_backgroundDrawable="@drawable/pic"             | setBannerBackgroundDrawable/setBackgroundDrawableRes | Drawable/Drawable Resource                | Helps to set ZsBanner background image using drawable      | -             |
| 17.   | app:zsBanner_imageUrl="<imageUrl>"                          | setBannerImageUrl                                    | String                                    | Helps to set ZsBanner background image using image link.   | -             |
| 18.   | app:zsBanner_IsBannerWithButton="true"                      | isBannerWithButton                                   | Boolean                                   | Helps to enable/disable ZsBanner with single button        | false         |
| 19.   | app:zsBanner_IsBannerWithTwoButton="true"                   | isBannerWithTwoButton                                | Boolean                                   | Helps to enable/disable ZsBanner with two button           | false         |
| 20.   | app:zsBanner_title="@string/title"                          | setTitle/setTitleRes                                 | String /String resource                   | Helps to set ZsBanner title                                | -             |
| 21.   | app:zsBanner_titleSize="@dimen/margin_10"                   | setTitleSize/setTitleSizeRes                         | float value/ dimen resource               | Helps to set ZsBanner title size                           | 16f           |
| 22.   | app:zsBanner_titleColor="@color/white"                      | setTitleColor/setTitleColorRes                       | Int color value/ Color resource           | Helps to set ZsBanner title color                          | Black         |
| 23.   | app:zsBanner_titleAllCaps="true"                            | setTitleAllCaps                                      | Boolean                                   | Helps to set ZsBanner title in caps                        | false         |
| 24.   | app:zsBanner_titleStyle="bold"                              | setTitleTextStyle                                    | Int typeface value(like: Typeface.ITALIC) | Helps to set ZsBanner title text style                     | Normal        |
| 25.   | app:zsBanner_title_gravity="center"                         | setTitleGravity                                      | Int gravity value                         | Helps to set ZsBanner title gravity                        | -             |
| 26.   | app:zsBanner_title_fontFamily="@font/open_sans_bold"        | setTitleFontFamilyRes                                | Font family resource                      | Helps to set ZsBanner title font family                    | -             |
| 27.   | app:zsBanner_subtitle="@string/title"                       | setSubTitle/setSubTitleRes                           | String /String resource                   | Helps to set ZsBanner subtitle                             | -             |
| 28.   | app:zsBanner_subtitleSize="@dimen/margin_10"                | setSubtitleSize/setSubtitleSizeRes                   | float value/ dimen resource               | Helps to set ZsBanner subtitle size                        | 14f           |
| 29.   | app:zsBanner_subtitleColor="@color/white"                   | setSubtitleColor/setSubtitleColorRes                 | Int color value/ Color resource           | Helps to set ZsBanner subtitle color                       | Black         |
| 30.   | app:zsBanner_subtitleAllCaps="true"                         | setSubTitleAllCaps                                   | Boolean                                   | Helps to set ZsBanner subtitle in caps                     | false         |
| 31.   | app:zsBanner_subtitleStyle="bold"                           | setSubtitleTextStyle                                 | Int typeface value(like: Typeface.ITALIC) | Helps to set ZsBanner subtitle text style                  | Normal        |
| 32.   | app:zsBanner_subtitle_gravity="center"                      | setSubtitleGravity                                   | Int gravity value                         | Helps to set ZsBanner subtitle gravity                     | -             |
| 33    | app:zsBanner_subtitle_fontFamily="@font/open_sans_bold"     | setSubtitleFontFamilyRes                             | Font family resource                      | Helps to set ZsBanner subtitle font family                 | -             |
| 34.   | app:zsBanner_description="@string/title"                    | setDescription/ setDescriptionRes                    | String /String resource                   | Helps to set ZsBanner description                          | -             |
| 35.   | app:zsBanner_descriptionSize="@dimen/margin_10"             | setDescriptionSize/ setDescriptionSizeRes            | float value/ dimen resource               | Helps to set ZsBanner description size                     | 12f           |
| 36.   | app:zsBanner_descriptionColor="@color/white"                | setDescriptionColor/setDescriptionColorRes           | Int color value/ Color resource           | Helps to set ZsBanner description color                    | Black         |
| 37.   | app:zsBanner_descriptionAllCaps="true"                      | setDescriptionAllCaps                                | Boolean                                   | Helps to set ZsBanner description in caps                  | false         |
| 38.   | app:zsBanner_descriptionStyle="bold"                        | setDescriptionTextStyle                              | Int typeface value(like: Typeface.ITALIC) | Helps to set ZsBanner description text style               | Normal        |
| 39.   | app:zsBanner_description_gravity="center"                   | setDescriptionGravity                                | Int gravity value                         | Helps to set ZsBanner description gravity                  | -             |
| 40.   | app:zsBanner_description_fontFamily="@font/open_sans_bold"  | setDescriptionFontFamilyRes                          | Font family resource                      | Helps to set ZsBanner description font family              | -             |
| 41.   | app:zs_banner_image_left_align="true"                       | isBannerImageLeftAlign                               | Boolean                                   | Helps to set image to left of the ZsBanner                 | false         |
| 42.   | app:zs_banner_image_right_align="true"                      | isBannerImageRightAlign                              | Boolean                                   | Helps to set image to right of the ZsBanner                | false         |
| 43.   | -                                                           | setOnSingleButtonClickListener                       | function as parameter                     | Helps to set onClick listener on ZsBanner single button    | -             |
| 44.   | -                                                           | setOnSecondaryButtonClickListener                    | function as parameter                     | Helps to set onClick listener on ZsBanner secondary button | -             |
| 45.   | -                                                           | setOnPrimaryButtonClickListener                      | functions as parameters                   | Helps to set onClick listener on ZsBanner primary button   | -             |
| 46.   | -                                                           | setOnBackgroundImageClickListener                    | functions as parameters                   | Helps to set onClick listener on ZsBanner background image | -             |
| 47.   | -                                                           | setOnRightImageClickListener                         | functions as parameters                   | Helps to set onClick listener on ZsBanner right image      | -             |
| 48.   | -                                                           | setOnLeftImageClickListener                          | functions as parameters                   | Helps to set onClick listener on ZsBanner left image       | -             |

