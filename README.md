# GridCheckBox

![GridCheckBox screenshot](https://i.imgsafe.org/e260ccfb57.jpg)

Grid Check Box is a GridView that can be used as a check box. Each item of the gridView will be used as a checkBox item.
This library uses [Picasso](http://square.github.io/picasso/) to load images from the internet and [Android Shape Imageview](https://github.com/siyamed/android-shape-imageview) for custom imageViews.

---
Customizations:

So far you will be able to:

- Customize text size using setTextSize(int size)
- Customize text gravity using setTextGravity(int gravity)
- Customize text color using setTextColor(int color)
- Customize tick drawable using setCheckDrawable(int drawable)
- Customize check animation speed using setCheckAnimSpeed(int speed)
- Customize text size using setTextSize(int size)

---
How to use?

1- First, add the following to your app level bundle.gradle:
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile 'com.github.heitorzc:GridCheckBox:master-SNAPSHOT'
}
```

2- Add your GridCheckBox in your layout xml:

```
<com.heitorzanetti.gridcheckbox.GridCheckBox
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:numColumns="5"
android:horizontalSpacing="10dp"
android:verticalSpacing="10dp"
android:scrollbars="none"/>
```
You can use any other attribute from GridView
            
3- In your Activity or Fragment, add items to your GridCheckBox by calling myGridCheckBox.addItem(String, String)

```
myGridCheckBox.addItem("http://image_url_1_here", "Item 1");
myGridCheckBox.addItem("http://image_url_2_here", "Item 2");
myGridCheckBox.addItem("http://image_url_3_here", "Item 3");
```

To retrieve the selected item, implement the listener GridCheckBox.OnItemSelected:

```
@Override
    public void onSelected(int position) {
        Log.i(TAG, "Selected Position: " + position);
    }
```

---
Future Updates:

- Customize image shape
- Add image drawable
- Allow multiple selection
- Set attributes via XML
- Enable/Disable extended height

---
# Enjoy!
