package com.mapsh.status.ui.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mapsh.widget.status.Default;
import com.mapsh.widget.status.DefaultStatusProvider;
import com.mapsh.widget.status.StatusProvider;
import com.mapsh.widget.status.StatusUIManager;

public class MainActivity extends AppCompatActivity {

    StatusUIManager statusUIManager;
    View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentView = findViewById(R.id.view_content);
        initStatusUI();
        View btn_refresh = findViewById(R.id.btn_refresh);
        View btn_netoff = findViewById(R.id.btn_netoff);
        View btn_server_error = findViewById(R.id.btn_server_error);
        View btn_logic_fail = findViewById(R.id.btn_logic_fail);
        View btn_local_error = findViewById(R.id.btn_local_error);
        View btn_empty = findViewById(R.id.btn_empty);

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "正在加载...", Toast.LENGTH_SHORT).show();
                statusUIManager.show(Default.LOADING);
            }
        });

        btn_empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "数据为空", Toast.LENGTH_SHORT).show();
                statusUIManager.show(Default.EMPTY);
            }
        });

        btn_netoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "没网了", Toast.LENGTH_SHORT).show();
                statusUIManager.show(Default.NET_OFF);
            }
        });

        btn_server_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "服务器出问题了", Toast.LENGTH_SHORT).show();
                statusUIManager.show(Default.SERVER_ERROR);
            }
        });

        btn_logic_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "业务逻辑失败", Toast.LENGTH_SHORT).show();
                statusUIManager.show(Default.LOGIC_FAIL);
            }
        });
        btn_local_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "本地逻辑出错", Toast.LENGTH_SHORT).show();
                statusUIManager.show(Default.LOCAL_ERROR);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initStatusUI() {
        statusUIManager = new StatusUIManager();

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultLoadingStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultEmptyStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultServerErrorStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultLogicFailStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultNetOffStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultLocalErrorStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

    }

}
