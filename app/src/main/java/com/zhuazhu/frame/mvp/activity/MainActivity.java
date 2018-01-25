package com.zhuazhu.frame.mvp.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.zhuazhu.frame.R;
import com.zhuazhu.frame.di.module.MainModule;
import com.zhuazhu.frame.mvp.application.FrameApplication;
import com.zhuazhu.frame.mvp.contract.MainContract;
import com.zhuazhu.frame.mvp.presenter.MainPresenterImp;

import java.util.List;

import mejust.frame.annotation.LayoutId;
import mejust.frame.annotation.TextRightFirstEvent;
import mejust.frame.annotation.TitleBar;
import mejust.frame.mvp.view.BasePresenterActivity;
import mejust.frame.net.AjaxResult;

@LayoutId(R.layout.activity_main)
@TitleBar(value = "首页",hiddenBack = true)
public class MainActivity extends BasePresenterActivity<MainPresenterImp>
        implements MainContract.View {
    @Override
    protected void initParam() {
    }

    @Override
    protected void injectComponent() {
        FrameApplication.getAppComponent().mainComponent(new MainModule(this)).inject(this);
    }

    @Override
    protected void initView() {
        AjaxResult<List<String>> result = new AjaxResult<>();
        result.setCode("200");
        result.setMessage("20");
//        FlowableUtils.create(Flowable.just(result)).subscribeWith(new Callback<List<String>>(null) {
//
//            @Override
//            public void success(List<String> strings) {
//
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                super.onError(t);
//            }
//        });
    }

    @TextRightFirstEvent("详情")
    protected void detail(TextView v) {
        loadingDialog();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hidden();
            }
        }, 2000);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.image:
                intent.setClass(this, ImageActivity.class);
                startActivity(intent);
                break;
            case R.id.recycler:
                intent.setClass(this, RecyclerActivity.class);
                startActivity(intent);
                break;
            case R.id.puppet:
                intent.setClass(this, PuppetActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
