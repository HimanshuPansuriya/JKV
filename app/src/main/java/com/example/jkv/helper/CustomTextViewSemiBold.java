package com.example.jkv.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * Created by shubham on 2/8/17.
 */
@SuppressLint("AppCompatCustomView")
public class CustomTextViewSemiBold extends TextView {


    public CustomTextViewSemiBold(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CustomTextViewSemiBold(Context context,@Nullable AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomTextViewSemiBold(Context context,@Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomTextViewSemiBold(Context context,@Nullable  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont =  FontCache.getTypeface("ParryHotter.ttf", context);
        setTypeface(customFont);
    }
}
