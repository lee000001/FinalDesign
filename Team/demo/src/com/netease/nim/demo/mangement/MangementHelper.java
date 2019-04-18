package com.netease.nim.demo.mangement;

import com.netease.nim.demo.Constant;

import com.netease.nim.demo.mangement.api.RxMangementService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MangementHelper {
    public static RxMangementService getRxService() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.APP_SERVICE_URL)//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
                .build();
        final RxMangementService rxjavaService = retrofit.create(RxMangementService.class);
        return rxjavaService;
//        .addmenber(tid,addUids)
//                .subscribeOn(Schedulers.io())//IO线程加载数据
//                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
//                .subscribe();
    }



}
