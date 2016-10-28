package com.mapsh.widget.status;

import android.content.Context;
import android.view.View;

import com.mapsh.widget.R;

/**
 * Created by 马朋深 on 2016/10/28.
 */

public class DefaultStatusProvider {
    public static class DefaultLoadingStatusView extends StatusProvider {

        public DefaultLoadingStatusView(View contentView, OnStatusViewCreateCallback callback) {
            super(Default.LOADING, contentView, callback);
        }

        @Override
        public View getStatusView(Context context) {
            return View.inflate(context, R.layout.status_ui_view_loading, null);
        }
    }

    public static class DefaultEmptyStatusView extends StatusProvider {

        public DefaultEmptyStatusView(View contentView, OnStatusViewCreateCallback callback) {
            super(Default.EMPTY, contentView, callback);
        }

        @Override
        public View getStatusView(Context context) {
            return View.inflate(context, R.layout.status_ui_view_empty, null);
        }
    }

    public static class DefaultServerErrorStatusView extends StatusProvider {

        public DefaultServerErrorStatusView(View contentView, OnStatusViewCreateCallback callback) {
            super(Default.SERVER_ERROR, contentView, callback);
        }

        @Override
        public View getStatusView(Context context) {
            return View.inflate(context, R.layout.status_ui_view_error_server, null);
        }
    }

    public static class DefaultNetOffStatusView extends StatusProvider {

        public DefaultNetOffStatusView(View contentView, OnStatusViewCreateCallback callback) {
            super(Default.NET_OFF, contentView, callback);
        }

        @Override
        public View getStatusView(Context context) {
            return View.inflate(context, R.layout.status_ui_view_error_server, null);
        }
    }

    public static class DefaultLogicFailStatusView extends StatusProvider {

        public DefaultLogicFailStatusView(View contentView, OnStatusViewCreateCallback callback) {
            super(Default.LOGIC_FAIL, contentView, callback);
        }

        @Override
        public View getStatusView(Context context) {
            return View.inflate(context, R.layout.status_ui_view_error_local, null);
        }
    }

    public static class DefaultLocalErrorStatusView extends StatusProvider {

        public DefaultLocalErrorStatusView(View contentView, OnStatusViewCreateCallback callback) {
            super(Default.LOCAL_ERROR, contentView, callback);
        }

        @Override
        public View getStatusView(Context context) {
            return View.inflate(context, R.layout.status_ui_view_error_local, null);
        }
    }
}
