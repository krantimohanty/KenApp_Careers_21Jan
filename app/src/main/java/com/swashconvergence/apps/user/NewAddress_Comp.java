package com.swashconvergence.apps.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.swashconvergence.apps.user.Fragment_individual.Contact;

public class NewAddress_Comp extends AppCompatActivity {
    private AppCompatEditText title,address1,address2, city, state, country, zip;
    private Spinner addressType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address__comp); title=(AppCompatEditText)findViewById(R.id.title);
        address1=(AppCompatEditText)findViewById(R.id.address1);
        address2=(AppCompatEditText)findViewById(R.id.address2);
        city=(AppCompatEditText)findViewById(R.id.city);
        state=(AppCompatEditText)findViewById(R.id.state);
        country=(AppCompatEditText)findViewById(R.id.country);
        zip=(AppCompatEditText)findViewById(R.id.zip);
        AppCompatButton button_save=(AppCompatButton)findViewById(R.id.btn_save);

//        Spinner
        addressType=(Spinner)findViewById(R.id.address_type) ;
        // Initializing a String Array
        String[] type = new String[]{
                "Shipping Address",
                "Mailing Address",
                "Home Address",
                "Office Address",

        };

        // Initializing an ArrayAdapter
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,type
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        addressType.setAdapter(spinnerArrayAdapter);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(NewAddressActivity.this, Form1Activity.class));
//                Intent intent=new Intent(this, Contact.class);
//                intent.putExtra("title", title.getText().toString());
//                intent.putExtra("address1", address1.getText().toString());
//                intent.putExtra("address2", address2.getText().toString());
//                intent.putExtra("city", city.getText().toString());
//                intent.putExtra("state", state.getText().toString());
//                intent.putExtra("country", country.getText().toString());
//                intent.putExtra("zip", zip.getText().toString());
//                startActivity(intent);
                Contact fragmentS1 = new Contact();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contact, fragmentS1).commit();
            }
        });
    }

    }

