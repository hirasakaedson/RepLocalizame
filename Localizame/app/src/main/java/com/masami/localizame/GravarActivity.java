package com.masami.localizame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.view.View;

public class GravarActivity extends Activity  {
    private android.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravar);
        fragmentManager= getSupportFragmentManager();
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, new MapsActivity(),"MapsFragment");
        transaction.commitAllowingStateLoss();
    }
    public void voltarinicio (View view){
        Intent intent = new Intent(getApplicationContext(),PrincipalActivity.class);
        startActivity(intent);

    }
    public void finalizar(View v){
        this.finishAffinity();
    }
}
