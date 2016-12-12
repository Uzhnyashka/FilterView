package com.example.bobyk.filterview;

import android.graphics.Bitmap;

/**
 * Created by bobyk on 12.12.16.
 */

public class FilterModel {

    private Bitmap bitmap;

    public FilterModel(Bitmap bitmap) {
        setBitmap(bitmap);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
