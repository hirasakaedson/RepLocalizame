package com.masami.localizame;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void selecionagravar(View view){
        Intent intent = new Intent (getApplicationContext(), GravarActivity.class);
        startActivity(intent);
    }
    public void selecionabuscar(View view){
        Intent intent = new Intent (getApplicationContext(), BuscarActivity.class);
        startActivity(intent);
    }
    public void finalizar(View v){
        this.finishAffinity();
    }



}
