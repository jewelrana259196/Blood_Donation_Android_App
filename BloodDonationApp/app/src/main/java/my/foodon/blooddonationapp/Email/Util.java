package my.foodon.blooddonationapp.Email;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import my.foodon.blooddonationapp.Model.User;
import my.foodon.blooddonationapp.R;

public class Util extends AppCompatActivity {
    private Button phone;
    private TextView phoneNumber;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dislayed_layout);

        phone = findViewById(R.id.emailNow);
        phoneNumber = findViewById(R.id.phoneNumber);
        phone.setOnClickListener(view -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("te:".concat(user.getPhoneNumber().toString())));
            startActivity(i);
        });
    }


}

