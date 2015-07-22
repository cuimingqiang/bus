package com.cmq.bus.eventBus;

import android.app.Activity;
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
public class EventBus2Activity extends Activity{
    EventBus eventBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus2);
        ButterKnife.bind(this);
        eventBus = EventBus.getDefault();
//        eventBus.register(this);
    }
    @OnClick({R.id.button})
    public void onClick(View view){
        eventBus.post(new MessageEvent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        eventBus.unregister(this);
    }
}
