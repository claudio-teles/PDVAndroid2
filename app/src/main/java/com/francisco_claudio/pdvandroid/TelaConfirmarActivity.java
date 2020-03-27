package com.francisco_claudio.pdvandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TelaConfirmarActivity extends AppCompatActivity {

    private TextView textPagamento;
    private TextView textConfirmar;
    private Button buttonConfPag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_confirmar);

        textPagamento = findViewById(R.id.textPagamento);
        textConfirmar = findViewById(R.id.textConfirmar);
        buttonConfPag = findViewById(R.id.buttonConfPag);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/DIN Condensed Bold.ttf");
        textPagamento.setTypeface(typeface);
        textConfirmar.setTypeface(typeface);

        buttonConfPag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle dados = new Bundle();
                        dados = getIntent().getExtras();

                        Float valor = dados.getFloat("valor");
                        String opcaoPagamento = dados.getString("opcao");
                        String dataPagamento = new Date().toGMTString();


                        Toast toast = Toast.makeText(
                                getApplicationContext(),
                                "Confirmado, data: "+dataPagamento,
                                Toast.LENGTH_SHORT
                        );
                        toast.show();

                    }
                }
        );

    }

    public void voltar(View view) {
        finish();
    }


}
