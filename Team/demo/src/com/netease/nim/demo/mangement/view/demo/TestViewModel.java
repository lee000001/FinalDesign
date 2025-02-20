package com.netease.nim.demo.mangement.view.demo;

import android.content.Context;
import android.widget.TextView;


import com.netease.nim.demo.R;
import com.netease.nim.demo.mangement.view.checkListView.CheckViewModel;

/**
 * Created by kylin on 2018/2/28.
 */

public class TestViewModel extends CheckViewModel<TestEntity> {

    private TextView tvTitle;
    private TextView tvContent;

    public TestViewModel(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.vm_test;
    }

    @Override
    protected void initView() {
        tvTitle = contentView.findViewById(R.id.tv_title);
        tvContent = contentView.findViewById(R.id.tv_content);
    }

    @Override
    protected void setDataToView() {
        tvTitle.setText(data.title);
        tvContent.setText(data.content);
    }

}
