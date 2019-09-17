package br.senac.es.calculadora;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;


public class MainActivity extends Activity {
    private Calculadora calc;
    char separadorChar;
private String separador;
String visor = "";




    private boolean usuarioEstaDigitandoUmNumero;
    private boolean separadorDecimalFoiDigitado;
    private TextView textVisor;


//Deleter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button deleter = (Button)findViewById(R.id.buttonDel);


        deleter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if(textVisor.getText() != null && textVisor.getText().toString().length() > 0){
                    textVisor.setText(textVisor.getText().toString().substring(0, textVisor.getText().toString().length() - 1));
                }


            }
        });


        calc = new Calculadora();
        usuarioEstaDigitandoUmNumero = false;
        separadorDecimalFoiDigitado = false;

        textVisor = (TextView) findViewById(R.id.textVisor);
        textVisor.setText("0");

        Locale localizacao = getResources().getConfiguration().locale;

        NumberFormat formatador = NumberFormat.getInstance(localizacao);

        if(formatador instanceof DecimalFormat){
            DecimalFormatSymbols sombolo = ((DecimalFormat)formatador).getDecimalFormatSymbols();
            separadorChar = sombolo.getDecimalSeparator();
        }
        separador = String.valueOf(separadorChar);
        Button btnSeparador = (Button)findViewById(R.id.button19);
        btnSeparador.setText(separador);
        final Typeface fonteDigital = Typeface.createFromAsset(this.getAssets(), "digital.ttf");
        textVisor.setTypeface(fonteDigital);
        textVisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textVisor.getTypeface().equals(fonteDigital)){
                    textVisor.setTypeface(Typeface.DEFAULT);
                }else {
                    textVisor.setTypeface(fonteDigital);
                }
            }
        });
        Toast.makeText(this, "Toque no visor para trocar a sua fonte",
                Toast.LENGTH_LONG).show();
    }



    public void onClickNumeros(View v) {
        Button botaoTocado = (Button) v;
        String digito = botaoTocado.getText().toString();
        String textoNoVisor = textVisor.getText().toString();

        if (!usuarioEstaDigitandoUmNumero || textoNoVisor.equals("0")) {
            textVisor.setText(digito);
            if (!digito.equals("0")) {
                usuarioEstaDigitandoUmNumero = true;
            }
        } else {
            textVisor.setText(textoNoVisor + digito);
        }
    }

    public void onClickOperacoes(View v) {
        Button botaoTocado = (Button) v;
        String operacoes = botaoTocado.getText().toString();

        if (operacoes.equals(separador) && !separadorDecimalFoiDigitado) {
            separadorDecimalFoiDigitado = true;
            if (!usuarioEstaDigitandoUmNumero)
                textVisor.setText("0" + separador);
            else
                textVisor.setText(textVisor.getText().toString() + separador);
            usuarioEstaDigitandoUmNumero = true;

        } else if (!operacoes.equals(separador)) {
            String valorSemVirgula = textVisor.getText().toString().replace(separadorChar,'.');
            calc.setOperando(Double.parseDouble(valorSemVirgula));
            calc.realizarOperacao(operacoes);
            String textoResultado = String.valueOf(calc.getOperando());

            if (textoResultado.endsWith(".0")) {
                textoResultado = textoResultado.substring(0, textoResultado.length() - 2);
            }
            textVisor.setText(textoResultado.replace('.', separadorChar));
            usuarioEstaDigitandoUmNumero = false;
            separadorDecimalFoiDigitado = false;
        }
    }

    public void onClickMemoria(View v) {
        Button botaoTocado = (Button) v;
        String operaca0Memoria = botaoTocado.getText().toString();
        String valorSemVirgula = textVisor.getText().toString().replace(separadorChar,'.');
        calc.setOperando(Double.parseDouble(valorSemVirgula));
        calc.realizarOperacaoDeMemoria(operaca0Memoria);
        usuarioEstaDigitandoUmNumero = false;
    }
}

