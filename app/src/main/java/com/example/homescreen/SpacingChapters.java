package com.example.homescreen;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpacingChapters extends RecyclerView.ItemDecoration{
    private int verSpaceHeight;

    public SpacingChapters(int verSpaceHeight) {
        this.verSpaceHeight = verSpaceHeight;
    }


    //overide method ctrl O
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.top = verSpaceHeight;
    }
}
