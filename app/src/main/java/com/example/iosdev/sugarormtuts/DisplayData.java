package com.example.iosdev.sugarormtuts;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iosdev on 05/04/2018.
 */

public class DisplayData extends Fragment {

    ListView listView;
    View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


         view = inflater.inflate(R.layout.display,container,false);

        listView = (ListView) view.findViewById(R.id.show_data);
        List<Client> data = Client.listAll(Client.class);
        final ArrayList<String> data_retrived = new ArrayList<>();

        for (Client client : data){
            data_retrived.add(client.getId()+"=="+client.name+"=="+client.num+"=="+client.job);
            Log.d("DATA",client.getId()+"=="+client.name+"=="+client.num+"=="+client.job);
        }


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_expandable_list_item_1,data_retrived);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view1, int i, long l) {
                Button button = new Button(view.getContext());
                button.setText("Del");

               // adapterView.addView(button);


                Toast.makeText(view.getContext(),"Positon:-"+data_retrived.get(i),Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
