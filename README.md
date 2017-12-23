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
        compile 'com.github.albert-lii:ImageViewer:1.0.6'
    }
