package com.example.listviewcrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class ListAdapter  extends BaseAdapter {
    private List<Entity> list;
    private Context context;
    private LayoutInflater inflater;

    public ListAdapter(List<Entity> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Entity entity=list.get(position);
        //判断是否有缓存
        if (convertView == null) {
            //通过LayoutInflate实例化布局
            convertView = inflater.inflate(R.layout.item_edit_layout, parent, false);
            holder = new ViewHolder(convertView);


            convertView.setTag(holder);
        } else {
            //通过tag找到缓存的布局
           holder= (ViewHolder) convertView.getTag();
        }
        holder.et_name.setText(entity.getName());
        holder.et_account.setText(entity.getAccount());;
        return convertView;
    }
    class ViewHolder{


        EditText et_name;
        EditText et_account;
        View view;
        Button btn_modify;
        public ViewHolder(View view) {
            this.et_name = view.findViewById(R.id.et_name);
            this.et_account = view.findViewById(R.id.et_account);
            this.btn_modify=view.findViewById(R.id.btn_modify);
            this.view=view;
        }
    }
}
