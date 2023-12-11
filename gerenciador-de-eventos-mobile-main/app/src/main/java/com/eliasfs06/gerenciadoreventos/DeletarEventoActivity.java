package com.eliasfs06.gerenciadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eliasfs06.gerenciadoreventos.db.DBHelper;

public class DeletarEventoActivity extends AppCompatActivity {

    private EditText nomeText;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleta_evento);

        dbHelper = new DBHelper(this);
        nomeText = findViewById(R.id.nomeText);

        Button btnDeletar = findViewById(R.id.deletarBtn);
        Button btnLimpar = findViewById(R.id.limparBtn);
        Button voltarBtn = findViewById(R.id.voltarBtnCadastro);

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletarEvento();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparInput();
            }
        });

        voltarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaMenuActivity();
            }
        });
    }

    private void deletarEvento(){
        String nome = nomeText.getText().toString();

        Boolean chickinsertdata = dbHelper.deletedata(nome);

        if(chickinsertdata == true) {
            Toast.makeText(DeletarEventoActivity.this, "Deletou", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(DeletarEventoActivity.this, "Não Deletou", Toast.LENGTH_SHORT).show();
        }
//        finish();

    }

    private void limparInput(){
        nomeText.setText("");
    }

    private void irParaMenuActivity() {
        Intent intent = new Intent(DeletarEventoActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void showToast(String mensagem){
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

}