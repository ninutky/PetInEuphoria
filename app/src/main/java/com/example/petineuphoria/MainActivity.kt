package com.example.petineuphoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    // 웹 클라이언트 ID
    val WEB_CLIENT_ID = "124344412923-otebslpgabh70qpsomrrch8r8edofbvk.apps.googleusercontent.com"
    val REQUEST_CODE = 1
    lateinit var oneTapClient: SignInClient
    val animal = Animal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        oneTapClient = Identity.getSignInClient(this)
        val signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(WEB_CLIENT_ID)
                    .setFilterByAuthorizedAccounts(false)
                    .build())
            .build()
        findViewById<Button>(R.id.google_login_btn).setOnClickListener {
            // 구글 로그인 작업 시작
            oneTapClient.beginSignIn(signInRequest).addOnSuccessListener {
                // 메소드의 응답 결과로 onActivityResult 메서드가 실행됨
                startIntentSenderForResult(it.pendingIntent.intentSender, REQUEST_CODE, null, 0, 0, 0)
            }.addOnFailureListener {
                Log.d("mytag", "fail ${it.message}")
            }
        }
        // Initialize Firebase Auth 파이어베이스 인스턴스 초기화
        auth = Firebase.auth

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_CODE -> {
                try {
                    // 구글 계정과 관련된 credential 얻어오기
                    val credential = oneTapClient.getSignInCredentialFromIntent(data)
                    val idToken = credential.googleIdToken
                    when {
                        idToken != null -> {
                            // 여기까지는 구글 계정으로 로그인하고 ID 토큰을 가져오는 것이었고, 이제 구글 ID 토큰을 파이어베이스 앱과 연결하는 작업 진행
                            Log.d("mytag", "구글 ID 토큰 확인 ${idToken}")
                            animal.uid = "${idToken}"
                            val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
                            auth.signInWithCredential(firebaseCredential)
                                .addOnCompleteListener(this) { task ->
                                    if (task.isSuccessful) {
                                        // 이메일, 비번 로그인과 마찬가지로 로그인 성공 이후 currentUser 속성값이 활성화
                                        val user = auth.currentUser
                                        Log.d("mytag", "로그인 성공 ${user.toString()}")
                                        finish()
                                    } else {
                                        Log.d("mytag", "로그인 실패 (사유 : ${task.exception})")
                                        Toast.makeText(baseContext, "로그인 실패", Toast.LENGTH_SHORT).show()
                                    }
                                }
                        }
                        else -> {
                            // Shouldn't happen.
                            Log.d("mytag", "구글 ID 토큰이 존재하지 않음")
                        }
                    }
                } catch (e: ApiException) {
                    Log.d("mytag", "${e.message}")
                }
            }
        }
    }

    private lateinit var auth: FirebaseAuth // 파이어베이스인스턴스 선언
    //사용자가 현재 로그인되어 있는지 확인
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload();

        }

    }

    private fun reload() {
        TODO("Not yet implemented")
    }

}