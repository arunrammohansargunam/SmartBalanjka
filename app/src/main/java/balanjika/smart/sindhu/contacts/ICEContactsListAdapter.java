package balanjika.smart.sindhu.contacts;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import balanjika.smart.sindhu.smartbalanjka.R;

public class ICEContactsListAdapter extends BaseAdapter {

    Context context;
    ArrayList<ICEContactListItems> contactList;

    public ICEContactsListAdapter(Context context, ArrayList<ICEContactListItems> list) {

        this.context = context;
        contactList = list;
    }

    @Override
    public int getCount() {

        return contactList.size();
    }

    @Override
    public Object getItem(int position) {

        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {
        ICEContactListItems contactListItems = contactList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contacts_adapter, null);

        }
        TextView tvName = (TextView) convertView.findViewById(R.id.idnamevalue);
        tvName.setText(contactListItems.getName());

        TextView tvPhone = (TextView) convertView.findViewById(R.id.phone_detail);
        tvPhone.setText(contactListItems.getPhone());

        return convertView;
    }

}