package com.cmq.bus.otto;

import android.app.Activity;
import android.os.Bundle;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by liqiang on 2015/7/23.
 */
public class OttoBusActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bus bus = new Bus(ThreadEnforcer.ANY);

    }

}
