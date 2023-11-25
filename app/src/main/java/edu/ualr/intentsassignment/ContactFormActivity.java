package edu.ualr.intentsassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.ualr.intentsassignment.model.Contact;

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
                sendContactData();
            }
        });
    }
    // TODO 06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity
    private void sendContactData() {
        // Retrieve values from EditText elements
        EditText firstNameEditText = findViewById(R.id.textInputFirstName);
        EditText lastNameEditText = findViewById(R.id.textInputLastName);
        EditText phoneNumberEditText = findViewById(R.id.textInputPhone);
        EditText emailEditText = findViewById(R.id.textInputEmail);
        EditText addressEditText = findViewById(R.id.textInputAddress);
        EditText websiteEditText = findViewById(R.id.textInputWebsite);

        // Create a Contact object with the retrieved values
        Contact contact = new Contact();
        contact.setFirstName(firstNameEditText.getText().toString());
        contact.setLastName(lastNameEditText.getText().toString());
        contact.setPhoneNumber(phoneNumberEditText.getText().toString());
        contact.setEmailAddress(emailEditText.getText().toString());
        contact.setAddress(addressEditText.getText().toString());
        contact.setWebsite(websiteEditText.getText().toString());

        // Start ContactInfoActivity and pass the Contact object
        Intent intent = new Intent(ContactFormActivity.this, ContactInfoActivity.class);
        intent.putExtra("contact_data", contact);
        startActivity(intent);
    }
}
