package br.sc.senai.carlos.churrascometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button questionOne = (Button) findViewById(R.id.button_question_one);
        questionOne.setOnClickListener(readQuestion());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
                EditText editQuestionOne = (EditText) findViewById(R.id.edit_question_one);
                String txQuantidadeDeCarne = editQuestionOne.getText().toString();
                if(txQuantidadeDeCarne.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.informe_carne, Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    Integer quantidadeDeCarne = Integer.parseInt(txQuantidadeDeCarne);
                    Intent intent = new Intent(getApplicationContext(), QuestionTwo.class);
                    Bundle params = new Bundle();
                    params.putInt("quantidadeDeCarne", quantidadeDeCarne);
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
