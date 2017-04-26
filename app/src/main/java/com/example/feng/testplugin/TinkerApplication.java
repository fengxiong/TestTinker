package com.example.feng.testplugin;

import android.app.Application;
import android.content.Intent;

import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

/**
 * Created by feng on 2017/4/26.
 */

public class TinkerApplication extends Application {


    TinkerPatchApplicationLike tinkerApplicationLike;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化TinkerPatch SDK, 更多配置可参照API章节中的,初始化 SDK
        tinkerApplicationLike = (TinkerPatchApplicationLike) TinkerPatchApplicationLike.getTinkerPatchApplicationLike();


        TinkerPatch.init(tinkerApplicationLike)
                .reflectPatchLibrary()
                .setPatchRollbackOnScreenOff(true)
                .setPatchRestartOnSrceenOff(true);

        // 每隔3个小时（通过setFetchPatchIntervalByHours设置）去访问后台时候有更新,通过handler实现轮训的效果
        TinkerPatch.with().fetchPatchUpdate(true);
    }
}
