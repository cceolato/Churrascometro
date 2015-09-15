package br.sc.senai.carlos.churrascometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    Integer quantidadeDeCarne;
    Integer quantidadeDeLinguica;
    Integer quantidadeDeRefri;
    Integer quantidadeDePessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Bundle args = getIntent().getExtras();
        quantidadeDeCarne = args.getInt("quantidadeDeCarne");
        quantidadeDeLinguica = args.getInt("quantidadeDeLinguica");
        quantidadeDeRefri = args.getInt("quantidadeDeRefri");
        quantidadeDePessoas = args.getInt("quantidadeDePessoas");
        this.calcula();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_end, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.about:
                openAbout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void calcula(){
        Calculadora calculadora = new Calculadora();
        TextView textViewCarne = (TextView) findViewById(R.id.carne_calculada);
        TextView textViewLinguica = (TextView) findViewById(R.id.linguica_calculada);
        TextView textViewRefri = (TextView) findViewById(R.id.refri_calculada);
        textViewCarne.setText(calculadora.calculaCarne(quantidadeDeCarne, quantidadeDePessoas));
        textViewLinguica.setText(calculadora.calculaLinguica(quantidadeDeLinguica, quantidadeDePessoas));
        textViewRefri.setText(calculadora.calculaRefri(quantidadeDeRefri, quantidadeDePessoas));
    }

    private void openAbout(){
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }
}
