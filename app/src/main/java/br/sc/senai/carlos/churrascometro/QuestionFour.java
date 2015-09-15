package br.sc.senai.carlos.churrascometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuestionFour extends AppCompatActivity {

    Integer quantidadeDeCarne;
    Integer quantidadeDeLinguica;
    Integer quantidadeDeRefri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);
        Button questionFour = (Button) findViewById(R.id.button_question_four);
        questionFour.setOnClickListener(readQuestion());
        Bundle args = getIntent().getExtras();
        quantidadeDeCarne = args.getInt("quantidadeDeCarne");
        quantidadeDeLinguica = args.getInt("quantidadeDeLinguica");
        quantidadeDeRefri = args.getInt("quantidadeDeRefri");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_four, menu);
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

    private View.OnClickListener readQuestion(){
        return new View.OnClickListener() {

            @Override
            public void onClick(View v){
                EditText editQuestionFour = (EditText) findViewById(R.id.edit_question_four);
                String txQuantidadeDePessoas = editQuestionFour.getText().toString();
                if(txQuantidadeDePessoas.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.informe_pessoas, Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    Integer quantidadeDePessoas = Integer.parseInt(txQuantidadeDePessoas);
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    Bundle params = new Bundle();
                    params.putInt("quantidadeDeCarne", quantidadeDeCarne);
                    params.putInt("quantidadeDeLinguica", quantidadeDeLinguica);
                    params.putInt("quantidadeDeRefri", quantidadeDeRefri);
                    params.putInt("quantidadeDePessoas", quantidadeDePessoas);
                    intent.putExtras(params);
                    startActivity(intent);
                }
            }
        };

    }

    private void openAbout(){
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }
}
