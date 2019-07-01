package pillminder.example.com.firebase_connectivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText em,ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        em=findViewById(R.id.email);
        ps=findViewById(R.id.pass);
    }

    public void signUser(View view) {
        String e=em.getText().toString();
        String p=ps.getText().toString();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(e,p)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            //go to login activity or // home activity
                            Toast.makeText(MainActivity.this,"Successfully Registered",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Log.d("error",task.getException().getMessage());
                        }
                    }
                });
    }
    }

