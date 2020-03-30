package com.francisco_claudio.pdvandroid;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class TelaConfirmarActivity extends AppCompatActivity {

    private TextView textPagamento;
    private TextView textConfirmar;
    private Button buttonConfPag;

    private String valorString;
    private String opcaoString;
    private String dataString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getTheme().applyStyle(R.style.ThemeTelaConfirmar, true);
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

                        valorString = String.valueOf(valor);
                        opcaoString = opcaoPagamento;
                        dataString = dataPagamento;

                        String criarTabela = "CREATE TABLE pagamento ("+
						"	id INTEGER NOT NULL,"+
						"	valor REAL NOT NULL,"+
						"	opcao_pagamento TEXT(20) NOT NULL,"+
						"	data_pagamento TEXT(25) NOT NULL,"+
						"	CONSTRAINT pagamento_PK PRIMARY KEY (id)"+
						")";

                        String iserirLinha = "INSERT INTO pagamento ("+
					"valor, opcao_pagamento, data_pagamento"+
					") VALUES("+valor+", "+opcaoPagamento+", "+dataPagamento+")";

                        try {
                            SQLiteDatabase database = openOrCreateDatabase("pagamento", MODE_PRIVATE, null);
                            database.execSQL(criarTabela);
                            database.execSQL(iserirLinha);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        Toast toast = Toast.makeText(
                                getApplicationContext(),
                                "Pagamento confirmado: \n" +
                                        "Valor: "+dados.getString("valor")+", Opção: "+dados.getString("opcao")+"\n"
                                +"Data: "+dataPagamento+".",
                                Toast.LENGTH_LONG
                        );
                        toast.show();

                        textPagamento.setVisibility(View.VISIBLE);

                    }

                }
        );

    }

    public void voltar(View view) {
        finish();
    }

}
