# ZsMessage

ZsMessage component displays a prominent message and related optional actions, can be used to show users of action that has been performed or needs to be performed. 
It remains until dismissed by the user, or if the state that caused the ZsMessage is resolved. 
It is prominent, medium priority as compared with ZsSnackBar & always displayed at the top of the screen, below a top app bar.
To read more about ZsMessage  - https://m2.material.io/components/banners#anatomy

## How to use:

#### Default ZsMessage-

```
ZsMessage(this@MainActivity).apply {
  show()
}
```

![This is ZsMessage]( https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/default_zsmessage.png)

#### ZsMessage with single action-
```
ZsMessage(this@MainActivity).apply {
  withAction2(DEFAULT_SECOND_ACTION) { dismiss() }
  message(DEFAULT_ZSMESSAGE)
  show()
}
```

![This is ZsMessage](https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zsmessage_with_single_action_without_icon.png)

#### ZsMessage with icon & single action-
```
ZsMessage(this@MainActivity).apply {
  action1TextColor(Color.BLUE)
  withAction1(DEFAULT_FIRST_ACTION) { showToast() }
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
```

![This is ZsMessage](https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zsmessage_with_icon_single_action.png)

#### ZsMessage without icon-
```
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
  show()
}
```

![This is ZsMessage](https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zsmessage_without_icon.png)


#### ZsMessage with both actions and icon-

```
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
```
![This is ZsMessage](https://github.com/zopsmart/pagenics-android/blob/dev/app/src/main/assets/zsmessage_with_icon.png)

## Properties:

| S.No. | Property             | Parameter                                         | Description                                                                        | Default value         |
|-------|----------------------|---------------------------------------------------|------------------------------------------------------------------------------------|-----------------------|
| 1.    | message              | String                                            | Helps to set message for ZsMessage by passing parameter  in String format.         | "This is ZsMessage!!" |
| 2.    | messageRes           | String resource                                   | Helps to set message for ZsMessage by passing parameter  in String res format.     | -                     |
| 3.    | textColor            | Int color value                                   | Helps to set message color for ZsMessage by passing parameter in ColorInts format. | Black                 |
| 4.    | textColorRes         | Color resource                                    | Helps to set message color for ZsMessage by passing parameter in ColorRes format.  | Black                 |
| 5.    | textTypeface         | Typeface                                          | Helps to set message typeface .                                                    | -                     |
| 6.    | backgroundColor      | Int color value                                   | Helps to set background color of the ZsMessage                                     | White                 |
| 7.    | backgroundColorRes   | Color resource                                    | Helps to set background color of the ZsMessage                                     | White                 |
| 8.    | animationAllowed     | Boolean                                           | Helps to enable ZsMessage animation                                                | False                 |
| 9.    | withAction1          | String Resource/ String and ZsMessage as function | Helps to set action1 text and it's click-action                                    | -                     |
| 10.   | withAction2          | String Resource/ String and ZsMessage as function | Helps to set action2 text and it's click-action                                    | -                     |
| 11.   | action1TextColor     | Int color value                                   | Helps to set action1 text color                                                    | Blue                  |
| 12.   | action1TextColorRes  | Color resource                                    | Helps to set action1 text color                                                    | Blue                  |
| 13.   | action2TextColor     | Int color value                                   | Helps to set action2 text color                                                    | Blue                  |
| 14.   | action2TextColorRes  | Color resource                                    | Helps to set action2 text color                                                    | Blue                  |
| 15.   | action1Typeface      | Typeface                                          | Helps to set action1 typeface                                                      | -                     |
| 16.   | action2Typeface      | Typeface                                          | Helps to set action2 typeface                                                      | -                     |
| 17.   | setActionTextSize    | Float value                                       | Helps to set action text size in float format                                      | -                     |
| 18.   | setActionTextSizeRes | Dimension Resource                                | Helps to set action text size by passing parameter  in dimen res format            | -                     |
| 19.   | setMsgTextSize       | Float value                                       | Helps to set action text size in float format                                      | -                     |
| 20.   | setMsgTextSizeRes    | Dimension Resource                                | Helps to set action text size by passing parameter  in dimen res format            | -                     |
| 21.   | setIcon              | Drawable                                          | Helps to set icon drawable                                                         | -                     |
| 22.   | setIconRes           | Drawable resource                                 | Helps to set icon drawable                                                         | -                     |

