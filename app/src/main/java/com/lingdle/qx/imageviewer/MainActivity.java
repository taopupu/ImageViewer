package com.lingdle.qx.imageviewer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lingdle.qx.image_viewer.ImageViewer;
import com.lingdle.qx.image_viewer.data.ViewData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    List<ImageView> list = new ArrayList<>();
    List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //简单的实现
    private void init() {
        ImageView img1 = findViewById(R.id.image1);
        ImageView img2 = findViewById(R.id.img2);
        ImageView img3 = findViewById(R.id.img3);
        list.add(img1);
        list.add(img2);
        list.add(img3);
        String url0 = "http://img5.duitang.com/uploads/item/201404/11/20140411214939_XswXa.jpeg";
        String url1 = "http://att.bbs.duowan.com/forum/201210/20/210446opy9p5pghu015p9u.jpg";
        String url2 = "https://b-ssl.duitang.com/uploads/item/201505/09/20150509221719_kyNrM.jpeg";
        stringList.add(url0);
        stringList.add(url1);
        stringList.add(url2);
        Glide.with(this).load(url0).into(img1);
        Glide.with(this).load(url1).into(img2);
        Glide.with(this).load(url2).into(img3);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startImage(0);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startImage(1);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startImage(2);
            }
        });
    }

    private void startImage(int index) {
        ArrayList<ViewData> viewDataArrayList = new ArrayList<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        for (ImageView imageView : list) {
            int[] location = new int[2];
            imageView.getLocationOnScreen(location);
            ViewData viewData = new ViewData();
            viewData.x = location[0];
            viewData.y = location[1];
            viewData.width = imageView.getMeasuredWidth();
            viewData.height = imageView.getMeasuredHeight();
            viewDataArrayList.add(viewData);
        }
        arrayList.addAll(stringList);
        ImageViewer.newInstance()
                .beginIndex(index)
                .imageData(arrayList)
                .viewData(viewDataArrayList)
                .options(new RequestOptions())
                .indexPos(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL)
                .show(this);
    }

}
