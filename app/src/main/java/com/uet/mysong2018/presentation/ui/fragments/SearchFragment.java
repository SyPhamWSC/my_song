package com.uet.mysong2018.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.uet.mysong2018.R;
import com.uet.mysong2018.common.CommonVLs;
import com.uet.mysong2018.common.Utils;
import com.uet.mysong2018.domain.model.ItemSongModel;
import com.uet.mysong2018.presentation.adapters.ListSongAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFragment extends BaseFragment {

    private static final String TAG = "SearchFragment";

    @BindView(R.id.list_view)
    ListView listSearchResult;

    @BindView(R.id.ll_default)
    LinearLayout llDefault;

    @BindView(R.id.ll_result_search)
    LinearLayout llResult;

    @BindView(R.id.edt_search)
    EditText edtSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_search, container, false);
        ButterKnife.bind(this, root);

        initView();

        return root;
    }

    private void initView() {
        edtSearch.setSingleLine();
        edtSearch.setMaxLines(1);

        llResult.setVisibility(View.GONE);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String query = editable.toString();
                if (query.equals("")) {
                    llDefault.setVisibility(View.VISIBLE);
                    llResult.setVisibility(View.GONE);
                } else {
                    llDefault.setVisibility(View.GONE);
                    llResult.setVisibility(View.VISIBLE);
                    List<ItemSongModel> songModels = Utils.getInstance().searchSong(query);
                    ListSongAdapter adapter = new ListSongAdapter(songModels, getActivity().getApplicationContext());
                    listSearchResult.setAdapter(adapter);
                }
                Log.e(TAG, "afterTextChanged: " + editable);
            }
        });

    }
}
