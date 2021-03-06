package balanjika.smart.sindhu.Detailed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import balanjika.smart.sindhu.Calendar.Events;
import balanjika.smart.sindhu.contacts.BloodList;
import balanjika.smart.sindhu.contacts.Contacts;
import balanjika.smart.sindhu.contacts.MatrimonyList;
import balanjika.smart.sindhu.contacts.healthtipList;
import balanjika.smart.sindhu.contacts.kdList;
import balanjika.smart.sindhu.smartbalanjka.R;


public class History extends ActionBarActivity {

    private TextView history_contentmore;
    private TextView history_contactsmore;
    private TextView history_kdmore;
    private TextView Donar_contentmore;
    private TextView history_matrimonymore;
    private TextView history_eventsmore;
    private TextView history_bookmore;
    private TextView history_healthmore;
    private TextView history_helpmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        history_contentmore = (TextView) findViewById(R.id.history_contentmore);
        history_contactsmore = (TextView) findViewById(R.id.history_contactsmore);
        Donar_contentmore = (TextView) findViewById(R.id.Donar_contentmore);
        history_kdmore = (TextView) findViewById(R.id.history_kdmore);
        history_eventsmore = (TextView) findViewById(R.id.history_eventsmore);
        history_matrimonymore = (TextView) findViewById(R.id.history_matrimonymore);
        history_bookmore = (TextView) findViewById(R.id.history_bookmore);
        history_healthmore = (TextView) findViewById(R.id.history_healthmore);
        history_helpmore = (TextView) findViewById(R.id.history_helpmore);

        history_helpmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), Contactus.class);
                startActivity(nextScreen);
            }
        });

        history_bookmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), book.class);
                startActivity(nextScreen);
            }
        });

        history_contentmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse( getResources().getString(R.string.website)));
                startActivity(myWebLink);
            }
        });


        history_contactsmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), Contacts.class);
                startActivity(nextScreen);
                }
        });
        history_matrimonymore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), MatrimonyList.class);
                startActivity(nextScreen);
            }
        });

        Donar_contentmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), BloodList.class);
                startActivity(nextScreen);
            }
        });

        history_kdmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), kdList.class);
                startActivity(nextScreen);
            }
        });

        history_healthmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), healthtipList.class);
                startActivity(nextScreen);
            }
        });

        history_eventsmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), Events.class);
                startActivity(nextScreen);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
