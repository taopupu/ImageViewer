仿微信朋友圈点击大图


添加依赖


Step 1:
   allprojects {
       repositories {
           ...
           maven { url 'https://jitpack.io' }
       }
    }
    
Step 2:

    dependencies {
        compile 'com.github.taopupu:ImageViewer:1.0'
    }
    
    
使用方法

Step 1:


在AndroidManifest.Xml中注册ImagePreviewActivity 例如：

   <activity
   
            android:name="com.lingdle.qx.image_viewer.ImagePreviewActivity"
            
            android:launchMode="singleTask"
            
            android:theme="@android:style/Theme.Translucent.NoTitleBar.Fullscreen" />
            
Step 2:


imageViewer = ImageViewer.newInstance()
                .indexPos(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL)
                .imageData(mImageDatas);
                
                
 for (int j = 0; j < autoGridView.getChildCount(); j++) {
 
     int[] location = new int[2]; // 获取在整个屏幕内的绝对坐标
     
     autoGridView.getChildAt(j).getLocationOnScreen(location);
     
     ViewData viewData = new ViewData();
     
     viewData.x = location[0];
     // 此处注意，如果`ImagePreviewActivity`使用全屏，而当前所在的Activity的状态栏独自占有高度，则还要减去状态栏的高度
     
     viewData.y = location[1];
     
     viewData.width = autoGridView.getChildAt(j).getMeasuredWidth();
     
     viewData.height = autoGridView.getChildAt(j).getMeasuredHeight();
     
     mViewDatas.add(viewData);
 }
 imageViewer.beginIndex(i)
 
    .viewData(mViewDatas)
    
    .show(context);


方法详解:

ImageViewer.newInstance()  

             // 点击的图片的序号（必填）
             
             .beginIndex(int index)
             
             // 点击的图片（非必填，一般不建议使用，主要是为了防止显示动画获取不到图像）
             
             .beginView(ImageView view)
             
             // 图片数据
             
             .imageData(ArrayList<Object> imageData)
             
             // ImageView在当前Activity中的位置信息和尺寸信息
             
             .viewData(ArrayList<ViewData> viewDatas)
             
             // 图片加载时的效果（采用的是glide4.1）   
             .options(RequestOptions options)
             // 图片加载时是否显示进度条（默认显示）
             .showProgress(boolean isShow)
             // 设置进度条的样式
             .progressDrawableDrawable drawable()
             // 设置索引的显示位置
             .indexPos(int pos)
             // 实现图片
             .show(Context context);
