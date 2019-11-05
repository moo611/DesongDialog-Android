package com.desongdialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 自定义弹窗
 * created by desong
 * 2019 11.5
 */

public class CustomDialog extends Dialog {

    private Context c;

    public CustomDialog(@NonNull Context context) {
        super(context);

        c = context;
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);

        c = context;


    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);

        c = context;

    }

    /**
     * 基本列表弹窗
     * @param datas   内容
     * @param dialogListener  位置回调
     */

    public void init(String[]datas, final DialogListener dialogListener){

        View v = LayoutInflater.from(c).inflate(R.layout.dialog_style1,null);
        this.setContentView(v);
        this.setCancelable(true);

        RecyclerView rv = v.findViewById(R.id.rv);
        DialogAdapter adapter = new DialogAdapter(c, datas, new DialogRvListener() {
            @Override
            public void onItemClick(int pos) {

                if (dialogListener!=null){

                    dialogListener.onItemClick(pos);
                    dismiss();

                }

            }
        });

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(c));

        //窗口位置
        Window w = getWindow();
        if (w==null){
            return;
        }
        WindowManager.LayoutParams params = w.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        w.setAttributes(params);
        w.setGravity(Gravity.BOTTOM);

    }

    /***
     * 带标题弹窗
     * @param datas   内容
     * @param title    标题
     * @param dialogListener  位置回调
     */

    public void init(String[]datas,String title,final DialogListener dialogListener){

        View v = LayoutInflater.from(c).inflate(R.layout.dialog_style2,null);
        this.setContentView(v);
        this.setCancelable(true);

        //列表
        RecyclerView rv = v.findViewById(R.id.rv);
        DialogAdapter adapter = new DialogAdapter(c, datas, new DialogRvListener() {
            @Override
            public void onItemClick(int pos) {

                if (dialogListener!=null){

                    dialogListener.onItemClick(pos);
                    dismiss();

                }

            }
        });

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(c));

        //标题
        TextView tv = v.findViewById(R.id.tv_title);
        tv.setText(title);


        //窗口位置
        Window w = getWindow();
        if (w==null){
            return;
        }
        WindowManager.LayoutParams params = w.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        w.setAttributes(params);
        w.setGravity(Gravity.BOTTOM);

    }

    /***
     * 自定义标题
     * @param datas
     * @param viewId
     * @param dialogListener
     */

    public void init(String[]datas,int viewId,final DialogListener dialogListener){

        LinearLayout v = new LinearLayout(c);
        v.setOrientation(LinearLayout.VERTICAL);

        //自定义标题
        View titleView = LayoutInflater.from(c).inflate(viewId,null);
        LinearLayout.LayoutParams header_params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        v.addView(titleView,header_params);

        //列表
        RecyclerView rv = new RecyclerView(c);
        DialogAdapter adapter = new DialogAdapter(c, datas, new DialogRvListener() {
            @Override
            public void onItemClick(int pos) {

                if (dialogListener!=null){

                    dialogListener.onItemClick(pos);
                    dismiss();

                }

            }
        });


        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(c));
        rv.setId(R.id.rv);
        LinearLayout.LayoutParams rv_params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        v.addView(rv,rv_params);


        this.setContentView(v);
        this.setCancelable(true);

        //窗口位置
        Window w = getWindow();
        if (w==null){
            return;
        }
        WindowManager.LayoutParams params = w.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        w.setAttributes(params);
        w.setGravity(Gravity.BOTTOM);

    }


}
