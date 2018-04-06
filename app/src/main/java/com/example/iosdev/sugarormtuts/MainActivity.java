package com.example.iosdev.sugarormtuts;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name,num,job;
    Button save_db,show_db;
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

        save_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //View view = this.getCurrentFocus();
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




                Client client1 = Client.findById(Client.class,new Long(2));
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
    }


}
