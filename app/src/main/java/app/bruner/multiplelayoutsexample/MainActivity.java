package app.bruner.multiplelayoutsexample;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import app.bruner.multiplelayoutsexample.models.UserDetails;

public class MainActivity extends AppCompatActivity {

    // Edit text to ask the user name
    EditText txtName;

    //Button to submit
    Button btnActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Set the widgets
        txtName = findViewById(R.id.txtName);
        btnActivity = findViewById(R.id.btnActivity);

        //Create a listener to be executed when this button is pressed
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get the name(string) written in textName
                String name = txtName.getText().toString();

                //Check if name is empty
                if (TextUtils.isEmpty(name)) {
                    //If empty show a error message
                    Toast.makeText(MainActivity.this, getString(R.string.errorNameMandatory), Toast.LENGTH_LONG).show();
                    return; //Abort on click event
                }

                //Creates the object to make the transition between activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class );

                //Create new user details with the name
                UserDetails objUser = new UserDetails(name);

                //Adds the user details to the transition object so that it can be picked up in the next activity
                intent.putExtra("USER_DETAILS", objUser);

                //Executes the transition between activites
                startActivity(intent);
            }
        });

    }
}