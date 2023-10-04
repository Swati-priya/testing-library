# ZsSnackbar

This component can be used to show users of action that has been performed or needs to be performed.
It can be purely informational, like a success notification or demand user action like a retry
button. To read more about default snackbar - https://m2.material.io/components/snackbars#anatomy

## How to use:

#### Default ZsSnackbar-

```
ZsSnackBar(context).apply {
  message("This is SnackBar!!")
  show()
}
```

![This is SnackBar](https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/default_zssnackbar.png)

#### ZsSnackbar with action-

```
ZsSnackBar(context).apply {
    message("This is SnackBar!!") 
    withAction(DEFAULT_ACTION_TEXT) { showToast() }
    show()
}
```

![This is SnackBar with action](https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zssnackbar_with_action.png)

#### ZsSnackbar without gradiantDrawable-

```
ZsSnackBar(context).apply{
  actionTextColor(Color.BLUE)
  withAction()DEFAULT_ACTION_TEXT)
  cornerRadius(10f)
  message(DEFAULT_MESSAGE_TEXT)
  backgroundColor(Color.LTGRAY)
  textColor(Color.BLACK)
  padding(30)
  animationAllowed(true)
  show()
}
```                

![This is SnackBar with action](https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zssnackbar_without_gradiant.png)

#### ZsSnackbar with gradiantDrawable-

```
 ZsSnackBar(context).apply { 
     actionTextColor(Color.BLUE)
     withAction(DEFAULT_ACTION_TEXT) { showToast() }
     cornerRadius(10f)
     message(DEFAULT_MESSAGE_TEXT)
     backgroundColor(Color.CYAN)
     textColor(Color.BLACK)
     padding(30)
     animationAllowed(true)
     gradiantDrawable(
       GradientDrawable(
         GradientDrawable.Orientation.LEFT_RIGHT,
         intArrayOf(
            ContextCompat.getColor(this@MainActivity, R.color.soft_red),
            ContextCompat.getColor(this@MainActivity, R.color.teal_200),
            ContextCompat.getColor(this@MainActivity, R.color.lemon_yellow),
            ContextCompat.getColor(this@MainActivity, R.color.bluish_green)
         )
       ).apply{
           cornerRadius = 10f
       })
     show()
 }
```

![This is SnackBar with action](https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zssnackbar_with_gradiant_drawable.png)

## Properties:

| S.No. | Property            | Parameter                                        | Description                                                                         | Default value                             |
|-------|---------------------|--------------------------------------------------|-------------------------------------------------------------------------------------|-------------------------------------------|
| 1.    | message             | String                                           | Helps to set message for ZsSnackbar by passing parameter  in String format.         | "This is SnackBar!!"                      |
| 2.    | messageRes          | String resource                                  | Helps to set message for ZsSnackbar by passing parameter  in String res format.     | -                                         |
| 3.    | textColor           | Int color value                                  | Helps to set message color for ZsSnackbar by passing parameter in ColorInts format. | White                                     |
| 4.    | textColorRes        | Color resource                                   | Helps to set message color for ZsSnackbar by passing parameter in ColorRes format.  | White                                     |
| 5.    | textTypeface        | Typeface                                         | Helps to set message typeface .                                                     | -                                         |        
| 6.    | duration            | Integer value                                    | Helps to set  duration of ZsSnackbar to visible in the screen                       | default as snackbar (LENGTH_INDEFINITE)   |
| 7.    | padding             | Integer value                                    | Helps to set space between ZsSnackbar & screen                                      | -                                         |
| 8.    | paddingRes          | Dimension Resource                               | Helps to set space between ZsSnackbar & screen                                      | -                                         |
| 9.    | cornerRadius        | Float value                                      | Helps to set rounder corner to the ZsSnackbar                                       | No radius                                 |
| 10.   | cornerRadiusRes     | Dimension Resource                               | Helps to set rounder corner to the ZsSnackbar                                       | No radius                                 |
| 11.   | backgroundColor     | Int color value                                  | Helps to set background color of the ZsSnackbar                                     | Transparent                               |
| 12.   | backgroundColorRes  | Color resource                                   | Helps to set background color of the ZsSnackbar                                     | Transparent                               |
| 13.   | border              | width and color in integer value                 | Helps to set ZsSnackbar border width and it's color                                 | borderWidth- 0 & borderColor- Transparent |
| 14.   | animationAllowed    | Boolean                                          | Helps to enable ZsSnackbar animation                                                | -                                         |
| 15.   | withAction          | String Resource/ String and Snackbar as function | Helps to set action text and it's click-action                                      | -                                         |
| 16.   | actionTextColor     | Int color value                                  | Helps to set ZsSnackbar action text color                                           | Blue                                      |
| 17.   | gradiantDrawable    | GradientDrawable                                 | Helps to set background gradiantDrawable.                                           | -                                         |
| 18.   | gradiantDrawableRes | GradiantDrawable Resource                        | Helps to set background gradiantDrawable.                                           | -                                         |
| 19.   | actionTypeface      | Typeface                                         | Helps to set action text typeface, can be bold, italic, normal and so on            | -                                         |
| 20.   | customView          | View                                             | Helps user to set it's own custom view for ZsSnackbar                               | -                                         |

