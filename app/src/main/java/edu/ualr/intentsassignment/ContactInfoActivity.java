package edu.ualr.intentsassignment;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.ualr.intentsassignment.model.Contact;

public class ContactInfoActivity extends AppCompatActivity {
    // TODO 03. Create a new layout file to define the GUI elements of the ContactInfoActivity.
    // TODO 04. Define the basic skeleton of the ContactInfoActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        populateContactInfo();

        setChipClickListener(R.id.callChip, "tel:" + getContact().getPhoneNumber());
        setChipClickListener(R.id.textChip, "sms:" + getContact().getPhoneNumber());
        setChipClickListener(R.id.emailChip, "mailto:" + getContact().getEmailAddress());
        setChipClickListener(R.id.mapChip, "geo:0,0?q=" + getContact().getAddress());
        setChipClickListener(R.id.webChip, getContact().getWebsite());
    }
    // TODO 07. Create a new method that reads the contact info coming from ContactFormActivity and use it to populate the several TextView elements in the layout.
    private void populateContactInfo() {
        // Retrieve the Contact object from the intent
        Intent intent = getIntent();
        Contact contact = intent.getParcelableExtra("contact_data");

        // Update the UI with the contact information
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewNumber = findViewById(R.id.textViewNumber);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        TextView textViewAddress = findViewById(R.id.textViewAddress);
        TextView textViewWebsite = findViewById(R.id.textViewWebsite);


        // Display contact information in the UI
        textViewName.setText(contact.getFullName());
        textViewNumber.setText(contact.getPhoneNumber());
        textViewEmail.setText(contact.getEmailAddress());
        textViewAddress.setText(contact.getAddress());
        textViewWebsite.setText(contact.getWebsite());
    }
    // TODO 08. Create a new method that invokes a Phone Dialer app, using as parameter the phone number included in the contact info received from ContactFormActivity in the previous step
    // TODO 09. Create a new method that invokes a Messages app, using as parameter the phone number included in the contact info received from ContactFormActivity in the 7th step
    // TODO 10. Create a new method that invokes a Maps app, using as parameter the address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 11. Create a new method that invokes an Email app, using as parameter the email address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 12. Create a new method that invokes an Web Browser app, using as parameter the web url included in the contact info received from ContactFormActivity in the 7th step
    private void setChipClickListener(int chipId, final String action) {
        Chip chip = findViewById(chipId);
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the appropriate action
                performChipAction(action);
            }
        });
    }

    private void performChipAction(String action) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(action));
        startActivity(intent);
    }

    private Contact getContact() {
        Intent intent = getIntent();
        return intent.getParcelableExtra("contact_data");
    }
}
