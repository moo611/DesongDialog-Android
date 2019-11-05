package com.desongdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/***
 * 列表适配器
 */
public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder> {

    private String[]datas;
    private DialogRvListener dialogRvListener;
    private Context c;

    DialogAdapter(Context c, String[] datas, DialogRvListener dialogRvListener){

        this.c = c;
        this.datas = datas;
        this.dialogRvListener = dialogRvListener;

    }


    @NonNull
    @Override
    public DialogViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(c).inflate(R.layout.item_dialog,viewGroup,false);

        return new DialogViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogViewHolder holder, final int i) {

        holder.tv.setText(datas[i]);
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogRvListener.onItemClick(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    class DialogViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        DialogViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv);
        }
    }
}
