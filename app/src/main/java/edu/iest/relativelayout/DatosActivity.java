package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        Button bnRegresar = findViewById(R.id.bnRegresar);
        TextView valorCanal = findViewById(R.id.valorCanal);
        TextView valorPrograma = findViewById(R.id.valorPrograma);
        String canal= getIntent().getStringExtra("Canal");
        String programa= getIntent().getStringExtra("Programa");
        valorCanal.setText(canal);
        valorPrograma.setText(programa);


      bnRegresar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //aqui la logica que hace al dar click
            Intent i =new Intent(DatosActivity.this,MainActivity.class);
            startActivity(i);
        }
    });
}
}