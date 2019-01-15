package com.jeepeng.react.xgpush.receiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.jeepeng.react.xgpush.Constants;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

/**
 * 小米官方推送通道消息接收器
 * Created by stevenxyj on 2018/5/12.
 */

public class XMMessageReceiver extends PushMessageReceiver {
    public static final String MODULE_NAME = "XMMessageReceiver";

    //接收服务器向客户端发送的透传消息
    @Override
    public void onReceivePassThroughMessage(Context context, MiPushMessage message) {
        Log.d(MODULE_NAME,
            "onReceivePassThroughMessage is called. " + message.toString());

        super.onReceivePassThroughMessage(context, message);
    }

    /**
     * 接收服务器向客户端发送的通知消息，
     * 这个回调方法会在用户手动点击通知后触发。
     */
    @Override
    public void onNotificationMessageArrived(Context context, MiPushMessage message) {
        Log.d(MODULE_NAME,
            "onNotificationMessageArrived is called. " + message.toString());

        Intent intent = new Intent(Constants.ACTION_ON_TEXT_MESSAGE);
        intent.putExtra("title", message.getTitle());
        intent.putExtra("content", message.getDescription());
        intent.putExtra("custom_content", message.getExtra().toString());
        context.sendBroadcast(intent);

        super.onNotificationMessageArrived(context, message);
    }

    /**
     * 接收服务器向客户端发送的通知消息，
     * 这个回调方法是在通知消息到达客户端时触发。另外应用在前台时不弹出通知的通知消息到达客户端也会触发这个回调函数。
     */
    @Override
    public void onNotificationMessageClicked(Context context, MiPushMessage message) {
        super.onNotificationMessageClicked(context, message);
    }

    //接收客户端向服务器发送命令后的响应结果
    @Override
    public void onCommandResult(Context context, MiPushCommandMessage message) {
        Log.d(MODULE_NAME,
            "onCommandResult is called. " + message.toString());

        super.onCommandResult(context, message);
    }

    //来接收客户端向服务器发送注册命令后的响应结果
    @Override
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage message) {
        Log.d(MODULE_NAME,
            "onReceiveRegisterResult is called. " + message.toString());

        super.onReceiveRegisterResult(context, message);
    }

}
