# DesongDialog-Android
自定义列表弹窗，简化构建弹窗步骤，方便快捷使用！A simple way to use dialog with item list


## 使用步骤
## step1.导入项目依赖
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
```
dependencies {
	        implementation 'com.github.moo611:DesongDialog-Android:-SNAPSHOT'
	}
```
## step2.初始化dialog

#### 基本dialog
```java

String[]datas = new String{"aaa","bbb","ccccc"};

CustomDialog basedialog = new CustomDialog(this);
 basedialog.init(datas, new DialogListener() {
            @Override
            public void onItemClick(int pos) {

                //your logic

            }
        });
```
![基本dialog](https://github.com/moo611/DesongDialog-Android/blob/master/app/1%20(1).jpg "基本dialog")


#### 默认标题dialog
```java
String[]datas = new String{"aaa","bbb","ccccc"};

  CustomDialog titledialog = new CustomDialog(this,R.style.customdialog);
        titledialog.init(datas, "请选择", new DialogListener() {
            @Override
            public void onItemClick(int pos) {

                //your logic

            }
        });
```

![默认标题dialog](https://github.com/moo611/DesongDialog-Android/blob/master/app/2%20(1).jpg "默认标题dialog")
#### 自定义头部dialog
```java
String[]datas = new String{"aaa","bbb","ccccc"};

 CustomDialog customDialog = new CustomDialog(this);
        customDialog.init(datas, R.layout.item_header, new DialogListener() {
            @Override
            public void onItemClick(int pos) {

                //your logic

            }
        });
```
![自定义头部dialog](https://github.com/moo611/DesongDialog-Android/blob/master/app/3%20(1).jpg "自定义头部dialog")

# 补充
####1.基于dialog的封装,因此很多属性直接用dialog的方法就可以，比如设置动画，设置dialog的位置等等。
####2.要想宽度占满屏幕，需要自定义一个style，然后再初始化的构造方法里加入这个style.参考默认标题dialog的做法。
