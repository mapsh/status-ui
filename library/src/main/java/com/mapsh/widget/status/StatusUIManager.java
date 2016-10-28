package com.mapsh.widget.status;

import android.util.SparseArray;

/**
 * Created by 马朋深 on 2016/10/28.
 */

public class StatusUIManager {

    private SparseArray<StatusProvider> map = new SparseArray<>();
    private StatusProvider currentStatusProvider;

    public void addStatusProvider(StatusProvider p) {
        map.put(p.getStatus(), p);
    }

    public void show(@Default.Status int status) {
        if (currentStatusProvider != null) {
            currentStatusProvider.hideStatusView();
        }
        StatusProvider p = map.get(status);
        if (p != null) {
            p.showStatusView();
            currentStatusProvider = p;
        }
    }

    public void clearStatus() {
        if (currentStatusProvider != null) {
            currentStatusProvider.hideStatusView();
            currentStatusProvider.showContentView();
        }
    }
}
