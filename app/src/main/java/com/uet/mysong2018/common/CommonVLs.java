package com.uet.mysong2018.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.uet.mysong2018.domain.model.ItemSongModel;

import java.util.ArrayList;
import java.util.List;

public class CommonVLs {

    private static ItemSongModel vocung = new ItemSongModel("Vô Cùng","Phan Duy Anh",
            "5:28","vo_cung_phan_duy_anh","vo_cung_phan_duy_anh");
    private static ItemSongModel votinh = new ItemSongModel("Vô Tình","Xesi x Hoaprox",
            "4:34","vo_tinh","vo_tinh");
    private static ItemSongModel yeuanhemnhe = new ItemSongModel("Yêu Anh Em Nhé","HuyR ft Tùng Viu",
            "5:35","yeu_anh_em_nhe","yeu_anh_em_nhe");

    private static List<ItemSongModel> listSong = new ArrayList<>();

    public static void initListSong(){
        listSong.add(vocung);
        listSong.add(votinh);
        listSong.add(yeuanhemnhe);
    }

    public static List<ItemSongModel> getListSong() {
        return listSong;
    }

    public static void hideSoftKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    public static void setupUI(View view, final Activity activity) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener((v, event) -> {
                CommonVLs.hideSoftKeyboard(activity);
                return false;
            });
        }

        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView, activity);
            }
        }
    }
}
