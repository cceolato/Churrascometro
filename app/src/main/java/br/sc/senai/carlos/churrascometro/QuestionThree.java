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

public class QuestionThree extends AppCompatActivity {

    Integer quantidadeDeCarne;
    Integer quantidadeDeLinguica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);
        Button questionThree = (Button) findViewById(R.id.button_question_three);
        questionThree.setOnClickListener(readQuestion());
        Bundle args = getIntent().getExtras();
        quantidadeDeCarne = args.getInt("quantidadeDeCarne");
        quantidadeDeLinguica = args.getInt("quantidadeDeLinguica");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_three, menu);
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
                EditText editQuestionThree = (EditText) findViewById(R.id.edit_question_three);
                String txQuantidadeDeRefri = editQuestionThree.getText().toString();
                if(txQuantidadeDeRefri.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.informe_refri, Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    Integer quantidadeDeRefri = Integer.parseInt(txQuantidadeDeRefri);
                    Intent intent = new Intent(getApplicationContext(), QuestionFour.class);
                    Bundle params = new Bundle();
                    params.putInt("quantidadeDeCarne", quantidadeDeCarne);
                    params.putInt("quantidadeDeLinguica", quantidadeDeLinguica);
                    params.putInt("quantidadeDeRefri", quantidadeDeRefri);
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
