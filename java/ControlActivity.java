package id.wateria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wateria.R;

import java.util.HashMap;
import java.util.Map;

public class  ControlActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    Switch light, fan, fertilizer, motor;
    String h = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll);

        light = (Switch) findViewById(R.id.switch1);
        fan = (Switch) findViewById(R.id.switch2);
        motor = (Switch) findViewById(R.id.switch3);
        fertilizer = (Switch) findViewById(R.id.switch4);

        data();
    }

    public void data() {
        FirebaseDatabase rootRef = FirebaseDatabase.getInstance();
        DatabaseReference allUsersRef = rootRef.getReference();

        light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    allUsersRef.child("Led1").setValue("1");
                } else {
                    Map<String, Object> taskMap = new HashMap<String, Object>();
                    taskMap.put("Led1", "0");
                    allUsersRef.updateChildren(taskMap);
                }


            }

        });
        fan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    allUsersRef.child("Led2").setValue("1");
                } else {
                    Map<String, Object> taskMap = new HashMap<String, Object>();
                    taskMap.put("Led2", "0");
                    allUsersRef.updateChildren(taskMap);
                }
            }
        });
        fertilizer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    allUsersRef.child("Led4").setValue("1");
                } else {
                    Map<String, Object> taskMap = new HashMap<String, Object>();
                    taskMap.put("Led4", "0");
                    allUsersRef.updateChildren(taskMap);
                }
            }
        });

        motor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    allUsersRef.child("Led3").setValue("1");
                } else {
                    Map<String, Object> taskMap = new HashMap<String, Object>();
                    taskMap.put("Led3", "0");
                    allUsersRef.updateChildren(taskMap);
                }
            }
        });
    }
}