package com.uet.mysong2018.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.uet.mysong2018.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.refactor.lib.colordialog.PromptDialog;

public class MeFragment extends BaseFragment {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_me, container, false);
        ButterKnife.bind(this,root);
        setClickListener();
        return root;
    }

    private void setClickListener() {
        btnLogin.setOnClickListener(view -> {
            new PromptDialog(getActivity())
                    .setDialogType(PromptDialog.DIALOG_TYPE_WARNING)
                    .setAnimationEnable(true)
                    .setTitleText("Thông Báo")
                    .setContentText("Chức năng đang được phát triển")
                    .setPositiveListener("OK", PromptDialog::dismiss).show();
        });
    }
}
