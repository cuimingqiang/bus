package com.cmq.bus.eventBus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cmq.bus.MessageEvent;
import com.cmq.bus.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by liqiang on 2015/7/21.
 */
public class EventBusActivity extends Activity {
    private EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        ButterKnife.bind(this);
        eventBus = EventBus.getDefault();
        eventBus.registerSticky(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        eventBus.unregister(this);
    }

    @OnClick(R.id.button)
    public void onClick(View view) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                eventBus.post(new MessageEvent());
//            }
//        }).start();
        startActivity(new Intent(this, EventBus2Activity.class));
    }


    // Called in the same thread (default)
    public void onEvent(MessageEvent event) {
        System.out.println("onEvent---" + Thread.currentThread().getName() + " msg==" + event.msg);
    }

    // Called in Android UI's main thread
    public void onEventMainThread(MessageEvent event) {
        System.out.println("onEventMainThread---" + Thread.currentThread().getName() + " msg==" + event.msg);
    }

    // Called in the background thread
    public void onEventBackgroundThread(MessageEvent event) {
        System.out.println("onEventBackgroundThread---" + Thread.currentThread().getName() + " msg==" + event.msg);
    }

    // Called in a separate thread
    public void onEventAsync(MessageEvent event) {
        System.out.println("onEventAsync---" + Thread.currentThread().getName() + " msg==" + event.msg);
    }
}
