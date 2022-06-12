package com.example.closet_project.fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.closet_project.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link weekcodyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class weekcodyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public weekcodyFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment weekcodyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static weekcodyFragment newInstance(String param1, String param2) {
        weekcodyFragment fragment = new weekcodyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.fragment_weekcody, container, false);
//
//        ImageView img_test = view.findViewById(R.id.first_week_cody_image);
//        FirebaseStorage storage = FirebaseStorage.getInstance("gs://closet-project-92a32.appspot.com");
//        StorageReference storageRef = storage.getReference();
//        storageRef.child("users/zs84LOVuOffZctLX5piQUfEBqLf1profileImage.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                //이미지 로드 성공
//                Glide.with(getApplicationContext())
//                        .load(uri)
//                        .into(img_test);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                //이미지 로드 실패시
//                Toast.makeText(myFragment(),"실패",Toast.LENGTH_SHORT).show();
//            }
//        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weekcody, container, false);
    }
}