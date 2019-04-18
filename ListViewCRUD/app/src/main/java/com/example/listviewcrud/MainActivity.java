package com.example.listviewcrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FooterViewHolder footerViewHolder = new FooterViewHolder(R.layout.footer);
        List<Entity> list=new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add(new Entity("姓名"+i,"账号"+i));
        }
        adapter = new ListAdapter(this,list,  new ListAdapter.OnItemClick() {
            @Override
            public void onModify(int index, Entity entity) {
                //更新数据
            }

            @Override
            public void onDelete(int index, Entity entity) {
                //删除
            }


       });

        footerViewHolder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加数据
            }
        });
        listView.setAdapter(adapter);
        listView.addFooterView(footerViewHolder.footer);

    }
    class FooterViewHolder{
        @BindView(R.id.et_name)
        EditText et_name;
        @BindView(R.id.et_account)
        EditText et_account;
        @BindView(R.id.btn_add)
        Button btn_add;
        View footer;

        public FooterViewHolder(int layout) {
            footer= LayoutInflater.from(MainActivity.this).inflate(layout,listView,false);
            ButterKnife.bind(this, footer);
        }
    }

}
