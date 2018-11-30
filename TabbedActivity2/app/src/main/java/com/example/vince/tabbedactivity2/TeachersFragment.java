package com.example.vince.tabbedactivity2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.

 */
public class TeachersFragment extends Fragment {
    ImageView twit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_teachers, container, false);
        twit = root.findViewById(R.id.imgkimkim);
        twit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Niaje Budah", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }


}
