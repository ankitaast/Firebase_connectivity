package pillminder.example.com.firebase_connectivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
 EditText userid,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        userid=findViewById(R.id.uid);
        username=findViewById(R.id.uname);

    }

    public void savedata(View view) {
        String id =userid.getText().toString();
        String name=username.getText().toString();

        //Firebase working Start
        Map<String,String> data=new HashMap<>();
        data.put("userid",id);
        data.put("username",name);
        FirebaseFirestore ref=FirebaseFirestore.getInstance();
        ref.collection("User")
                .document(id)
                .set(data); 
    }
}
