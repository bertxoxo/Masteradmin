package com.masteradmin.app;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText codeInput;
    private Button connectBtn;
    private ListView sleepList;
    private ArrayList<String> logList = new ArrayList<>();
    private SleepLogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codeInput = findViewById(R.id.codeInput);
        connectBtn = findViewById(R.id.connectBtn);
        sleepList = findViewById(R.id.sleepList);

        adapter = new SleepLogAdapter(this, logList);
        sleepList.setAdapter(adapter);

        connectBtn.setOnClickListener(v -> {
            String code = codeInput.getText().toString().trim();
            if (!code.isEmpty()) {
                listenToLogs(code);
            }
        });
    }

    private void listenToLogs(String code) {
        logList.clear();
        DatabaseReference ref = FirebaseDatabase.getInstance()
            .getReference("users")
            .child(code);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                logList.clear();
                for (DataSnapshot log : snapshot.getChildren()) {
                    logList.add(log.getValue(String.class));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {}
        });
    }
    }
