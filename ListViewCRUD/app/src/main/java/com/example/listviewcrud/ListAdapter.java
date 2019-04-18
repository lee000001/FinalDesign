package com.example.listviewcrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class ListAdapter  extends BaseAdapter {
    public List<Entity> list;
    private Context context;
    private LayoutInflater inflater;
    private OnModifyClick onModifyClick;

    public ListAdapter(Context context,List<Entity> list,OnModifyClick onModifyClick ) {
        this.list = list;
        this.context = context;
        this.onModifyClick=onModifyClick;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        Entity entity=list.get(position);
        if (entity.isEdit())
             convertView = edit(position, convertView, parent, entity);
        else
            convertView = Show(position, convertView, parent, entity);

        return convertView;
    }

    private View edit(final int position, View convertView, ViewGroup parent, final Entity entity) {
        final ViewHolder holder;//判断是否有缓存
        if (convertView == null||!ViewHolder.class.isInstance(convertView.getTag())) {
            //通过LayoutInflate实例化布局
            convertView = inflater.inflate(R.layout.item_edit_layout, parent, false);
            holder = new ViewHolder(convertView);


            convertView.setTag(holder);
        } else {
            //通过tag找到缓存的布局
           holder= (ViewHolder) convertView.getTag();
        }
        holder.et_name.setText(entity.getName());
        holder.et_account.setText(entity.getAccount());
        ;
        holder.btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setAccount(holder.et_account.getText().toString());
                list.get(position).setName(holder.et_name.getText().toString());
                list.get(position).setEdit(false);

                refresh();

            }
        });
        holder.ibtn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               list.remove(position);
                list.get(position).setEdit(false);
                refresh();

            }
        });
        return convertView;
    }

    private View Show(final int position, View convertView, ViewGroup parent, Entity entity) {
        final ViewHolder_show holder;//判断是否有缓存
        if (convertView == null||!ViewHolder_show.class.isInstance(convertView.getTag())) {
            //通过LayoutInflate实例化布局
            convertView = inflater.inflate(R.layout.item, parent, false);
            holder = new ViewHolder_show(convertView);


            convertView.setTag(holder);
        } else {
            //通过tag找到缓存的布局
            holder= (ViewHolder_show) convertView.getTag();
        }
        holder.tv_name.setText(entity.getName());
        holder.tv_account.setText(entity.getAccount());
        ;
        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setEdit(true);
//                list.get(position).setName(holder.et_name.getText().toString());
                refresh();
            }
        });

        return convertView;
    }
    private void refresh() {
        this.notifyDataSetChanged();
    }

    class ViewHolder{


        EditText et_name;
        EditText et_account;
        View view;
        Button btn_modify;
        ImageButton ibtn_del;
        public ViewHolder(View view) {
            this.et_name = view.findViewById(R.id.et_name);
            this.et_account = view.findViewById(R.id.et_account);
            this.btn_modify=view.findViewById(R.id.btn_modify);
            this.ibtn_del=view.findViewById(R.id.ibtn_del);
            this.view=view;
        }
    }
    public interface  OnModifyClick{
        void onModify(int index);
    }

    class ViewHolder_show{


        TextView tv_name;
        TextView tv_account;
        View view;
        Button btn_edit;
//        ImageButton ibtn_del;
        public ViewHolder_show(View view) {
            tv_name = view.findViewById(R.id.tv_name);
            tv_account = view.findViewById(R.id.tv_account);
            btn_edit=view.findViewById(R.id.btn_edit);

            this.view=view;
        }
    }

}
