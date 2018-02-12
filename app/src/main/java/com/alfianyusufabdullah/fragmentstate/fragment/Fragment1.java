package com.alfianyusufabdullah.fragmentstate.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alfianyusufabdullah.fragmentstate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    Button btnCounter;
    TextView textCounter;

    String KEY_COUNTER = "COUNTER";
    int Counter = 0;

    public Fragment1() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCounter = view.findViewById(R.id.btnCounter);
        btnCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter++;
                textCounter.setText("Fragment 1 Counter " + Counter);
            }
        });
        textCounter = view.findViewById(R.id.textCounter);

        if (savedInstanceState != null) {
            Counter = savedInstanceState.getInt(KEY_COUNTER);
            textCounter.setText("Fragment 1 Counter " + Counter);
        } else {
            textCounter.setText("Fragment 1 Counter 0");
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY_COUNTER, Counter);
        super.onSaveInstanceState(outState);
    }
}
