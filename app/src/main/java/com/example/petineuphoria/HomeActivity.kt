package com.example.petineuphoria

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage


class HomeActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    var firestore : FirebaseFirestore? = null
    var storage: FirebaseStorage? = null

    var mRootRef = FirebaseDatabase.getInstance().reference
    var conditionRef = mRootRef.child("Data")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        val name = findViewById<TextView>(R.id.pet_name)
        val age = findViewById<TextView>(R.id.pet_age)
        val breed = findViewById<TextView>(R.id.pet_breed)
        val img = findViewById<ImageView>(R.id.profile_img)
        val imgUri: Uri? = null


        auth = Firebase.auth
        val db = Firebase.firestore

        val currentUser = auth.currentUser
        storage = FirebaseStorage.getInstance()
        firestore = FirebaseFirestore.getInstance()

        

        val docRef = db.collection("animal").document(FirebaseAuth.getInstance().currentUser?.uid.toString())
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    name.text = document.data!!.get("name").toString()
                    age.text = document.data!!.get("age").toString().plus("살")
                    breed.text = document.data!!.get("breed").toString()
                    Log.d("mytag", "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d("mytag", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("mytag", "get failed with ", exception)
            }
        }

//        storage!!.getReference().child("image").child(fileName)
//            .putFile(selectImage!!)//어디에 업로드할지 지정
//            .addOnSuccessListener {
//                    taskSnapshot -> // 업로드 정보를 담는다
//                taskSnapshot.metadata?.reference?.downloadUrl?.addOnSuccessListener {
//                        it->
//                    var imageUrl=it.toString()
//                    var photo = Photo(textEt.text.toString(),imageUrl)
//                    firestore!!.collection("photo")
//                        .document().set(photo)
//                        .addOnSuccessListener {
//                            finish()
//                        }
//                }
//            }
}