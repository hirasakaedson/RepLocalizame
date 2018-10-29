package com.masami.localizame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BuscarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }
    public void voltarinicio (View view){
        Intent intent = new Intent(getApplicationContext(),PrincipalActivity.class);
        startActivity(intent);

    }
    public void finalizar(View v){
        this.finishAffinity();
    }
}
