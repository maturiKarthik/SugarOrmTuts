package com.example.iosdev.sugarormtuts;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name,num,job;
    Button save_db,show_db,update_db;
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        num = (EditText)findViewById(R.id.num);
        job = (EditText)findViewById(R.id.job);

        save_db = (Button)findViewById(R.id.save);
        show_db = (Button)findViewById(R.id.show);
        update_db = (Button)findViewById(R.id.update);

        Toast.makeText(getApplicationContext(),"PLEASE_ENTER NAME AND FOLLOWING YOU WANT TO UPDATE ..IF NO CLICK ON SHOW DB AND UPDATE WHICH EXIT ALREADY",Toast.LENGTH_LONG).show();


        save_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TO CLOSE THE INPUT TEXT
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }


                 client = new Client(name.getText().toString(),num.getText().toString(),job.getText().toString());
                client.save();

                Toast.makeText(getApplicationContext(),name.getText()+"//"+num.getText()+"//"+job.getText(),Toast.LENGTH_LONG).show();
            }
        });

        show_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




               // Client client1 = Client.findById(Client.class,new Long(2));
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,new DisplayData());
                fragmentTransaction.commit();

                List<Client> clients = Client.listAll(Client.class);
                for (Client client : clients){
                    Log.d("DATA",client.getId()+"=="+client.name+"=="+client.num+"=="+client.job);
                }

            }

        });

        // UPDATE DB ..
        update_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TO CLOSE THE INPUT TEXT ..
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                Toast.makeText(getApplicationContext(),name.getText().toString()+","+num.getText().toString()+","+job.getText().toString(),Toast.LENGTH_LONG).show();
               // Update the content ..
                List<Client> notes = Client.find(Client.class, "name = ?",name.getText().toString());
                if (notes.size() > 0) {

                    Client cl_up = notes.get(0);
                    cl_up.num = num.getText().toString();
                    cl_up.job = job.getText().toString();
                    cl_up.save();
                }


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflating the Menu ..
        getMenuInflater().inflate(R.menu.menu_list,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.update:
                 Toast.makeText(this,"YOu have clicked on update",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
