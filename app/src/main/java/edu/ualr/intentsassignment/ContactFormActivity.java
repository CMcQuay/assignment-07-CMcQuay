package edu.ualr.intentsassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContactFormActivity extends AppCompatActivity {
    // TODO 01. Create a new layout file to define the GUI elements of the ContactFormActivity.
    // TODO 02. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);
        Button saveContactButton = findViewById(R.id.saveBtn);
        saveContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get contact information from the form
                String contactName = "John Doe"; // Replace with actual data
                String contactEmail = "john.doe@example.com"; // Replace with actual data

                // Start ContactInfoActivity and pass data
                Intent intent = new Intent(ContactFormActivity.this, ContactInfoActivity.class);
                intent.putExtra("contact_name", contactName);
                intent.putExtra("contact_email", contactEmail);
                // Add more data as needed
                startActivity(intent);
            }
        });
    }
    // TODO 06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity
}
