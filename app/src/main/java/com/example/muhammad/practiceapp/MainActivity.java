package com.example.muhammad.practiceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import rx.Observable;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mapping();
//        takeWords();
//        ScanData();
//        filteData();
        condtionalOperator();
    }

    public void mapping() {
        rx.Observable.from(Users.userdata())
                .subscribeOn(Schedulers.io())
                .map(model -> {
                            String names = model.getName().toUpperCase();
                            return names;
                        }
                ).subscribe(s -> Log.d("TAG", "names: " + s));


        rx.Observable.from(Users.userdata())
                .subscribeOn(Schedulers.io())
                .flatMap(model -> {
                    String[] names = {model.getName().toLowerCase(), model.getName().toUpperCase()};
                    return Observable.from(names);
                }).subscribe(r ->
        {
            Log.d("TAG", "------------------------------------------" + "\n");
            Log.d("TAG", r.toString());
        });
    }

    public void takeWords() {
        rx.Observable.from(Users.userdata())
                .isEmpty()
                .subscribe(aBoolean -> Log.d("TAG", "List is empty"));

    }

    public void ScanData() {
        rx.Observable.from(Users.userdata())
                .scan(new StringBuilder(), (stringBuilder, model) ->
                        stringBuilder.append(model.getName() + " "))
                .subscribe(stringBuilder -> Log.d("TAG", stringBuilder.toString()));
        System.out.println("------------------------------");
        rx.Observable.from(Users.userdata())
                .scan(new StringBuilder(), (stringBuilder, model) -> stringBuilder.append(model.getName() + " "))
                .last()
                .subscribe(stringBuilder -> Log.d("TAG", stringBuilder.toString()));
    }

    public void filteData() {
        ArrayList<model> admin = new ArrayList<>();
        ArrayList<model> Moderator = new ArrayList<>();
        rx.Observable.from(Users.userdata())
                .groupBy(model -> model.getLevel() == 0 ? "Admin" : "Moderator")
                .subscribe(stringmodelGroupedObservable -> {

                    stringmodelGroupedObservable.subscribe(model -> {

                        if (stringmodelGroupedObservable.getKey() == "Admin") {
                            admin.add(model);

                        } else if (stringmodelGroupedObservable.getKey() == "Moderator") {
                            Moderator.add(model);

                        }
                    });
                });
        //admin

        for (model model1 : admin) {
            Log.d("TAG", "Admin: " + model1.getName());
        }
        //Moderator
        for (model model1 : Moderator) {
            Log.d("TAG", "Moderator: " + model1.getName());
        }
    }

    public void condtionalOperator() {
        rx.Observable.from(Users.userdata())
                .first()
                .subscribe(model -> Log.d("TAG", "first Word: " + model.getName()));

        rx.Observable.from(Users.userdata())
                .takeWhile(model -> model.getLevel() < 2)
                .subscribe(model -> Log.d("TAG", "condition 1: " + model.getName()));

        rx.Observable.from(Users.userdata())
                .skipWhile(model -> model.getLevel() < 2)
                .subscribe(model -> Log.d("TAG", "condition 2: " + model.getName()));

        rx.Observable.from(Users.userdata())
                .takeWhile(model -> model.getLevel() > 1)
                .subscribe(model -> Log.d("TAG", "condition 3: " + model.getName()));

    }


}