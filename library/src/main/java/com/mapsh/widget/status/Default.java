package com.mapsh.widget.status;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 马朋深 on 2016/10/28.
 */

public class Default {

    public static final int LOADING = 0;
    public static final int EMPTY = 1;
    public static final int NET_OFF = 2;
    public static final int SERVER_ERROR = 3;
    public static final int LOGIC_FAIL = 4;
    public static final int LOCAL_ERROR = 5;

    //用 @IntDef "包住" 常量；
    // @Retention 定义策略
    // 声明构造器
    @IntDef({LOADING, EMPTY, NET_OFF, SERVER_ERROR, LOGIC_FAIL, LOCAL_ERROR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }
}
