package com.example.tiktak.Models;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.internal.ObjectConstructor;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MediaData {

    private static FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    private static CollectionReference mediaObjectsRef = firebaseFirestore.collection("media_objects");
    private  static int numberOfRecords=3;
    public static ArrayList<MediaObject> mediaObjects= new ArrayList<>();

    public static void LoadData() {
        mediaObjectsRef.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        MediaObject object = documentSnapshot.toObject(MediaObject.class);
                        mediaObjects.add(object);
                    }
                })
                .addOnFailureListener(e -> {
                    Log.e("LoadData", "Error getting data: " + e.getMessage());
                });
    }

}
