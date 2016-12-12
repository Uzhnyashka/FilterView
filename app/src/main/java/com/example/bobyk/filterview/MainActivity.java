package com.example.bobyk.filterview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MainActivity extends AppCompatActivity implements ChooseFilterView.CoverFlowItemListener {

    List<FilterModel> bitmapList;
    private ChooseFilterView chooseFilterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rect rectangle = new Rect();
        Window window = getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        final int statusBarHeight = rectangle.top;
        int contentViewTop =
                window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
        final int titleBarHeight= contentViewTop - statusBarHeight;

        chooseFilterView = (ChooseFilterView) findViewById(R.id.choose_filter_view);
        initTestData();
        ChooseFilterAdapter adapter = new ChooseFilterAdapter(bitmapList);
        chooseFilterView.setAdapter(adapter);
        chooseFilterView.setCoverFlowItemListener(this);
        chooseFilterView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                chooseFilterView.scrollToCenter(position, statusBarHeight);
            }
        }));

        OverScrollDecoratorHelper.setUpOverScroll(chooseFilterView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(chooseFilterView);

//        chooseFilterView.getLayoutManager().scrollToPosition(5);
//        onItemSelected(2);
        adapter.notifyDataSetChanged();
    }

    private void initTestData() {
        bitmapList = new ArrayList<>();
        bitmapList.add(null);
        bitmapList.add(null);
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image1)));
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image5)));
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image5)));
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image5)));
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image1)));
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image1)));
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image5)));
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image5)));
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image5)));
        bitmapList.add(new FilterModel(BitmapFactory.decodeResource(getResources(), R.drawable.image1)));
        bitmapList.add(null);
        bitmapList.add(null);
    }

    @Override
    public void onItemChanged(int position) {

    }

    @Override
    public void onItemSelected(int position) {

    }
}

