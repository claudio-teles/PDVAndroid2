package com.francisco_claudio.pdvandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    // Initialize Variable
    private RecyclerView recyclerView;
    private TextView textValor;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;

    private ArrayList<FormaDePagemento> formasDePagemento = new ArrayList<>();
    private FormaPagamentoAdapter adapter;

    private List<String> listaDeNumeros = new ArrayList<>();
    private String valor = "0,00";
    private String opcaoPagamento = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assing Variables
        recyclerView = findViewById(R.id.recycler_view);
        textValor = findViewById(R.id.txtValor);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);

        textValor.setText(valor);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/DIN Condensed Bold.ttf");
        textValor.setTypeface(typeface);

        // Create Integer Array
        Integer[]  langLogo = {
                R.drawable.ic_money, R.drawable.ic_debit, R.drawable.ic_credit, R.drawable.ic_vr,
                R.drawable.ic_cupom
        };

        //  Create String Array
        String[] langName = {
                "DINHERIO", "DÉBITO", "CRÉDITO", "VR", "CUPOM"
        };

        // Initialize ArrayList
        formasDePagemento = new ArrayList<>();
        for (int i = 0; i < langLogo.length; i++) {
            FormaDePagemento formaDePagemento = new FormaDePagemento(langLogo[i], langName[i]);
            formasDePagemento.add(formaDePagemento);
        }

        // Design Horizontal Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, HORIZONTAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        // Initialize FormaPagamentoAdapter
        adapter = new FormaPagamentoAdapter(formasDePagemento, MainActivity.this);
        // Set FormaPagamentoAdapter to RecyclerView
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            switch (position) {
                                case 0:
                                    opcaoPagamento = "DINHEIRO";
                                    irParaPaginaConfirmacao(valor, opcaoPagamento);
                                    Toast toast = Toast.makeText(
                                            getApplicationContext(),
                                            opcaoPagamento,
                                            Toast.LENGTH_SHORT
                                    );
                                    toast.show();
                                    break;
                                case 1:
                                    opcaoPagamento = "DÉBITO";
                                    irParaPaginaConfirmacao(valor, opcaoPagamento);
                                    Toast toast2 = Toast.makeText(
                                            getApplicationContext(),
                                            opcaoPagamento,
                                            Toast.LENGTH_SHORT
                                    );
                                    toast2.show();
                                    break;
                                case 3:
                                    opcaoPagamento = "CRÉDITO";
                                    irParaPaginaConfirmacao(valor, opcaoPagamento);
                                    Toast toast3 = Toast.makeText(
                                            getApplicationContext(),
                                            opcaoPagamento,
                                            Toast.LENGTH_SHORT
                                    );
                                    toast3.show();
                                    break;
                                case 4:
                                    opcaoPagamento = "VR";
                                    irParaPaginaConfirmacao(valor, opcaoPagamento);
                                    Toast toast4 = Toast.makeText(
                                            getApplicationContext(),
                                            opcaoPagamento,
                                            Toast.LENGTH_SHORT
                                    );
                                    toast4.show();
                                    break;
                                case 5:
                                    opcaoPagamento = "CUPOM";
                                    irParaPaginaConfirmacao(valor, opcaoPagamento);
                                    Toast toast5 = Toast.makeText(
                                            getApplicationContext(),
                                            opcaoPagamento,
                                            Toast.LENGTH_SHORT
                                    );
                                    toast5.show();
                                    break;
                            }
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

    }

    public void irParaPaginaConfirmacao(String valorPagamento, String formaPagamento) {
        Intent intent = new Intent(getApplicationContext(), TelaConfirmarActivity.class);
        intent.putExtra("valor", valorPagamento);
        intent.putExtra("opcao", formaPagamento);
        startActivity(intent);
    }

    public void adicionarUmListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("1");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void adicionarDoisListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("2");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void adicionarTresListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("3");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void adicionarQuatroListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("4");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void adicionarCincoListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("5");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void adicionarSeisListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("6");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void adicionarSeteListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("7");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void adicionarOitoListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("8");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void adicionarNoveListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("9");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void adicionarZeroListaNumeros(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        listaDeNumeros.add("0");
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
    }

    public void deletarUltimoNumeroLista(View view) {
        diminuirFonte(listaDeNumeros);
        aumentarFonte(listaDeNumeros);
        String string = "0,00";
        String num = "";
        String novoValor = "";
        if ( (listaDeNumeros.size() - 1) > 0 ) {
            listaDeNumeros.remove(listaDeNumeros.size() - 1);
        }
        for (String numero : listaDeNumeros) {
            num += numero;
            novoValor = string.replace("0,", num+",");
        }
        valor = novoValor;
        textValor.setText(valor);
        if (
                textValor.getText().equals("1,00")
                || textValor.getText().equals("2,00")
                || textValor.getText().equals("3,00")
                || textValor.getText().equals("4,00")
                || textValor.getText().equals("5,00")
                || textValor.getText().equals("6,00")
                || textValor.getText().equals("7,00")
                || textValor.getText().equals("8,00")
                || textValor.getText().equals("9,00")
        ) {
            listaDeNumeros.clear();
            textValor.setText("0,00");
        }
    }

    public  void diminuirFonte(List<String> listaDeNumeros) {
        if (listaDeNumeros.size() > 2) {
            textValor.setTextSize(30);
        }
    }

    public  void aumentarFonte(List<String> listaDeNumeros) {
        if (listaDeNumeros.size() == 0) {
            textValor.setTextSize(70);
        }
    }

}
