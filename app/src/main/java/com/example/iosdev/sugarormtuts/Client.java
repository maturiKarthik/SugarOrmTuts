package com.example.iosdev.sugarormtuts;

import com.orm.SugarRecord;

/**
 * Created by iosdev on 04/04/2018.
 */

public class Client extends SugarRecord<Client>{


    String name;
    String num;
    String job;

    public Client() {
    }

    public Client(String name, String num, String job) {
        this.name = name;
        this.num = num;
        this.job = job;
    }
}
