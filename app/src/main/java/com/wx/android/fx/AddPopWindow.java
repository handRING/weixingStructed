package com.wx.android.fx;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.wx.android.R;

/**
 * Created by Administrator on 2017/6/26.
 */

public class AddPopWindow extends PopupWindow {
    private View conentView;


    @SuppressLint("InflateParams")
    public AddPopWindow(final Activity context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.popupwindow_add, null);

        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);

        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreview);

        RelativeLayout re_saoyisao =(RelativeLayout) conentView.findViewById(R.id.re_saoyisao);
        re_saoyisao.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,DecoderActivity.class));
                AddPopWindow.this.dismiss();

            }

        } );

/**
 * 后期功能添加
 * */
        /*RelativeLayout re_addfriends =(RelativeLayout) conentView.findViewById(R.id.re_addfriends);
        RelativeLayout   re_chatroom =(RelativeLayout) conentView.findViewById(R.id.re_chatroom);
        re_addfriends.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,AddFriendsOneActivity.class));
                AddPopWindow.this.dismiss();

            }

        } );
        re_chatroom.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,CreatChatRoomActivity.class));
                AddPopWindow.this.dismiss();

            }

        } );*/


    }

    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, 0, 0);
        } else {
            this.dismiss();
        }
    }

}
