package com.mapsh.widget.status;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

/**
 * Created by 马朋深 on 2016/10/28.
 */

public abstract class StatusProvider {

    protected View statusView;
    protected FrameLayout container;

    protected View contentView;

    @Default.Status
    protected int status;
    protected OnStatusViewCreateCallback callback;

    public interface OnStatusViewCreateCallback {
        void onCreate(int status, View statusView);
    }

    public StatusProvider(@Default.Status int status, View contentView, OnStatusViewCreateCallback callback) {

        this.status = status;
        this.contentView = contentView;
        this.callback = callback;
        if (contentView == null) {
            throw new RuntimeException("contentView不能为null");
        }
        ViewParent p = this.contentView.getParent();
        if (p instanceof FrameLayout) {
            this.container = (FrameLayout) p;
        } else {
            throw new RuntimeException(contentView.getClass().getName() + "必须作为FrameLayout的子元素");
        }
    }

    @Default.Status
    public int getStatus() {
        return status;
    }

    public abstract View getStatusView(Context context);

    public void showStatusView() {
        if (statusView == null) {
            statusView = getStatusView(contentView.getContext());
            if (callback != null) {
                callback.onCreate(status, statusView);
            }
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
            container.addView(statusView, lp);
        }
        statusView.setVisibility(View.VISIBLE);
        statusView.bringToFront();
    }

    public void hideStatusView() {
        if (statusView != null) {
            statusView.setVisibility(View.GONE);
        }
    }

    public void showContentView() {
        contentView.setVisibility(View.VISIBLE);
        contentView.bringToFront();
    }
}
