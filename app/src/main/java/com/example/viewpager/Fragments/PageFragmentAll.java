package com.example.viewpager.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpager.Quiz.Home;
import com.example.viewpager.R;

public class PageFragmentAll extends Fragment {
    ImageView first;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview=(ViewGroup) inflater.inflate(R.layout.all_frag,container,false);
       first=(ImageView)rootview.findViewById(R.id.first);
       first.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getActivity(), "WELCOME To Your Quiz Analysis ", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(getActivity(), Home.class);
               startActivity(intent);
           }
       });

        return rootview;

    }

    
}
