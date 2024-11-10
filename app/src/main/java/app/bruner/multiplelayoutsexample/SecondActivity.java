package app.bruner.multiplelayoutsexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import app.bruner.multiplelayoutsexample.models.UserDetails;

//To become an Activity you need to inherit AppCompatActivity
public class SecondActivity extends AppCompatActivity {

    TextView txtDisplay;

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //Set the layout for this activity
        setContentView(R.layout.activity_second);

        //Get the textView widget
        txtDisplay = findViewById(R.id.txtDisplay);

        btnReturn = findViewById(R.id.btnReturn);

        //I created a UserDetails object that receives the data passed by the Intent object for this activity
        UserDetails objUser = (UserDetails) getIntent().getSerializableExtra("USER_DETAILS");

        //Shows the user name
        txtDisplay.setText(objUser.getName());

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////Creates the object to make the transition between activity
                Intent intent = new Intent(SecondActivity.this, MainActivity.class );
                //Executes the transition between activites
                startActivity(intent);
            }
        });

    }

}
