package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bnCanal=findViewById(R.id.bnCanal);
        EditText etCanal=findViewById(R.id.etCanal);
        TextView tvCanal=findViewById(R.id.tvLegendCanal);

        Spinner spProgramas=findViewById(R.id.spProgramas);
        ivContinuara = findViewById(R.id.ivCont);

        spProgramas.setOnItemSelectedListener(this);

        bnCanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aqui la logica que hace al dar click
                //Obtendremos el valor del edit text y lo asignaremos al textview inferior
                texto = etCanal.getText().toString();
                Toast.makeText(MainActivity.this, "El valor era "+texto, Toast.LENGTH_LONG).show();
                tvCanal.setText(texto);
            }
        });

        ivContinuara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aqui la logica que hace al dar click
                Intent i =new Intent(MainActivity.this,DatosActivity.class);
                i.putExtra("Canal",texto);
                i.putExtra("Programa",programa);
                startActivity(i);
            }
        });
    }

    private ImageView ivContinuara;
    private String programa;

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {

        Snackbar.make(adapterView,"Programa seleccionado "+programa, Snackbar.LENGTH_LONG).show();
        programa= adapterView.getItemAtPosition(posicion).toString();
        if (posicion==0){
            ivContinuara.setImageResource(R.drawable.tbc);
        }else if(posicion==1){
            ivContinuara.setImageResource(R.drawable.tbc2);
        }else{
            ivContinuara.setImageResource(R.drawable.tbc3);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}