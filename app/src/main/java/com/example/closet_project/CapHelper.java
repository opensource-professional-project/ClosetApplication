package com.example.closet_project;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.closet_project.listener.OnPostListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import static com.example.closet_project.Util.isStorageUrl;
import static com.example.closet_project.Util.showToast;
import static com.example.closet_project.Util.storageUrlToName;

public class CapHelper {
    private Activity activity;
    private OnPostListener onPostListener;
    private int successCount;

    public CapHelper(Activity activity) {
        this.activity = activity;
    }

    public void setOnPostListener(OnPostListener onPostListener){
        this.onPostListener = onPostListener;
    }

    public void storageDelete(final PostInfo postInfo){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        final String id = postInfo.getId();
        ArrayList<String> contentsList = postInfo.getContents();
        for (int i = 0; i < contentsList.size(); i++) {
            String contents = contentsList.get(i);
            if (isStorageUrl(contents)) {
                successCount++;
                StorageReference desertRef = storageRef.child("posts/" + id + "/" + storageUrlToName(contents));

                Log.d("Log : ","Success");
                desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        successCount--;
                        storeDelete(id, postInfo);
                        Log.d("Log : ","Success");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        showToast(activity, "Error");
                    }
                });
            }
        }
        storeDelete(id, postInfo);
    }

    private void storeDelete(final String id, final PostInfo postInfo) {
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        if (successCount == 0) {
            firebaseFirestore.collection("MyCloset_Cap_posts").document(id)
                    .delete()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            showToast(activity, "게시글을 삭제하였습니다.");
                            onPostListener.onDelete(postInfo);
                            //postsUpdate();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            showToast(activity, "게시글을 삭제하지 못하였습니다.");
                        }
                    });
        }
    }
}
