package balanjika.smart.sindhu.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import balanjika.smart.sindhu.smartbalanjka.R;
import dbhelper.DBHelper;

public class DoctorList_Fragment extends ListFragment {

    public static BloodList_Fragment newInstance(String string) {
        return null;
    }

    List<String[]> list = new ArrayList<String[]>();
    private View mView;
    ArrayList<HashMap<String, String>> contactList;
    private ContactsListAdapter adapter;
    private ListView lv;
    Cursor c=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv = getListView();
        lv.setTextFilterEnabled(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.contacts, container, false);
        contactList = new ArrayList<HashMap<String, String>>();

        ArrayList<ContactListItems> contactList = new ArrayList<ContactListItems>();
        contactList.clear();
        DBHelper myDbHelper = new DBHelper(getActivity());
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        try {
            myDbHelper.openDataBase();
        } catch (Exception sqle) {
        }
        c = myDbHelper.query(getResources().getString(R.string.table_Profile), null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                if(c.getString(27).equalsIgnoreCase(getResources().getString(R.string.yes))) {
                    ContactListItems contactListItems = new ContactListItems();
                    contactListItems.setName(c.getString(3));
                    contactListItems.setNo(c.getString(0));
                    contactListItems.setPhone(c.getString(10));
                    contactList.add(contactListItems);
                }
            } while (c.moveToNext());
        }
        lv = (ListView) mView.findViewById(android.R.id.list);
        adapter = new ContactsListAdapter(getActivity(), contactList);
        lv.setAdapter(adapter);
        lv.setItemsCanFocus(false);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
//                Toast.makeText(getActivity(), getResources().getString(R.string.samepassword_toast), Toast.LENGTH_LONG).show();
//                Intent nextScreen = new Intent(getActivity(), Each_contact.class);
//                TextView defaultID = (TextView) arg1.findViewById(R.id.defaultID);
//                int id = Integer.parseInt(defaultID.getText().toString());
//                nextScreen.putExtra("new_variable_name", id);
//                startActivity(nextScreen);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long idr) {
                Intent nextScreen = new Intent(getActivity(), Each_contact.class);
                TextView defaultID = (TextView) arg1.findViewById(R.id.defaultID);
                int id = Integer.parseInt(defaultID.getText().toString());
                nextScreen.putExtra("new_variable_name", id);
                startActivity(nextScreen);
                return true;
            }
        });
        return mView;
    }



    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of BloodList");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("DEBUG", "OnPause of BloodList");
        super.onPause();
    }
}
