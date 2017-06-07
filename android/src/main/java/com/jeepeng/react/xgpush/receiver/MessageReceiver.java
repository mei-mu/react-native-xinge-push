package com.jeepeng.react.xgpush.receiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.jeepeng.react.xgpush.Constants;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;

/**
 * 消息接收器
 * Created by Jeepeng on 16/8/4.
 */
public class MessageReceiver extends XGPushBaseReceiver {

    /**
     * 注册结果
     * @param context
     * @param errorCode
     * @param xgPushRegisterResult
     */
    @Override
    public void onRegisterResult(Context context, int errorCode, XGPushRegisterResult xgPushRegisterResult) {

        if(errorCode == 0) {
            Intent intent = new Intent(Constants.ACTION_ON_REGISTERED);
            intent.putExtra("token", xgPushRegisterResult.getToken());
            context.sendBroadcast(intent);
        }

    }

    /**
     * 反注册结果
     * @param context
     * @param errorCode
     */
    @Override
    public void onUnregisterResult(Context context, int errorCode) {

    }


    /**
     * 设置标签结果
     * @param context
     * @param errorCode
     * @param tagName
     */
    @Override
    public void onSetTagResult(Context context, int errorCode, String tagName) {

    }

    /**
     * 删除标签结果
     * @param context
     * @param errorCode
     * @param tagName
     */
    @Override
    public void onDeleteTagResult(Context context, int errorCode, String tagName) {

    }

    /**
     * 收到消息
     * @param context
     * @param xgPushTextMessage
     */
    @Override
    public void onTextMessage(Context context, XGPushTextMessage xgPushTextMessage) {
        Intent intent = new Intent(Constants.ACTION_ON_TEXT_MESSAGE);
        intent.putExtra("title", xgPushTextMessage.getTitle());
        intent.putExtra("content", xgPushTextMessage.getContent());
        intent.putExtra("customContent", xgPushTextMessage.getCustomContent());
        context.sendBroadcast(intent);
    }

    /**
     * 通知被打开触发的结果
     * @param context
     * @param message
     */
    @Override
    public void onNotifactionClickedResult(Context context, XGPushClickedResult message) {
        if (context == null || message == null) {
            return;
        }
        if (message.getActionType() == XGPushClickedResult.NOTIFACTION_CLICKED_TYPE) {
            // 通知在通知栏被点击啦。。。。。
            Intent intent = new Intent(Constants.ACTION_ON_NOTIFICATION_CLICKED);
            Bundle bundle = new Bundle();
            bundle.putString("content", message.getContent());
            bundle.putString("title", message.getTitle());
            intent.putExtra("notification", bundle);
            context.sendBroadcast(intent);
        } else if (message.getActionType() == XGPushClickedResult.NOTIFACTION_DELETED_TYPE) {
            // 通知被清除啦。。。。
            // APP自己处理通知被清除后的相关动作
        }
    }

    /**
     * 通知被展示触发的结果，可以在此保存APP收到的通知
     * @param context
     * @param xgPushShowedResult
     */
    @Override
    public void onNotifactionShowedResult(Context context, XGPushShowedResult xgPushShowedResult) {
        Intent intent = new Intent(Constants.ACTION_ON_NOTIFICATION_SHOWED);
        Bundle bundle = new Bundle();
        bundle.putString("content", xgPushShowedResult.getContent());
        bundle.putString("title", xgPushShowedResult.getTitle());
        bundle.putString("customContent", xgPushShowedResult.getCustomContent());
        intent.putExtra("notification", bundle);

        intent.putExtra("title", xgPushShowedResult.getTitle());
        intent.putExtra("content", xgPushShowedResult.getContent());
        intent.putExtra("customContent", xgPushShowedResult.getCustomContent());
        intent.putExtra("activity", xgPushShowedResult.getActivity());
        intent.putExtra("msgId", xgPushShowedResult.getMsgId());
        intent.putExtra("notificationId", xgPushShowedResult.getNotifactionId());
        intent.putExtra("notificationActionType", xgPushShowedResult.getNotificationActionType());
        context.sendBroadcast(intent);
    }
}
