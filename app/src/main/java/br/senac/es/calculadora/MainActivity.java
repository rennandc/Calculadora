//Imports
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


//Class extendendo de Activity, calculadora feita com orientação a objetos.
public class MainActivity extends Activity {
    //Calculadora vem da classe private Calculadora e herda todas as suas caracteríticas.
    private Calculadora calc;
    //Instanciando o variavel do tipo char.
    char separadorChar;

private String separador;
// Instanciando a variavel visor do tipo String como vazio.
String visor = "";



    //Variaveis do tipo boolean que retornam verdadeiro ou false.
    private boolean usuarioEstaDigitandoUmNumero;
    private boolean separadorDecimalFoiDigitado;

    private TextView textVisor;


//Método de autoria própria.
    //@Override, sobre escrever um método existente, nesse caso o onCreat do botao deleter.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super significar que ele está acesando a classe pai.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instanciando o botao deleter.
        final Button deleter = (Button)findViewById(R.id.buttonDel);

//Quando clicar em deleter fará as instruções abaixo.
        deleter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //If para ver se o visor é diferente de nulo E maior que zero.
                if(textVisor.getText() != null && textVisor.getText().toString().length() > 0){
                    //Caso seja ele Pegar o valor do visor, converte para String, usa o substring apra contalo da posição 0 até o tamanho da String -1
                    textVisor.setText(textVisor.getText().toString().substring(0, textVisor.getText().toString().length() - 1));
                }


            }
        });

        //Iniciando uma nova calculadora.
        calc = new Calculadora();
        //Dizendo que as variaveis abeixo do tipo boolean são falsas.
        usuarioEstaDigitandoUmNumero = false;
        separadorDecimalFoiDigitado = false;
        //Dando o valor de 0 ao textVisor
        textVisor = (TextView) findViewById(R.id.textVisor);
        textVisor.setText("0");

        //Utilizando a biblioteca Locale para definir o local em que o app está sendo utilizado.
        Locale localizacao = getResources().getConfiguration().locale;
        //Utilizadno a biblioteca NumberFormat para receber as informaçoes da localizão
        NumberFormat formatador = NumberFormat.getInstance(localizacao);

        //Verifica se formatador é um "DecimalFormat"
        if(formatador instanceof DecimalFormat){
            //Caso seja realiza os comandos abaixo.
            DecimalFormatSymbols sombolo = ((DecimalFormat)formatador).getDecimalFormatSymbols();
            separadorChar = sombolo.getDecimalSeparator();
        }
        //Atribui os valores a variavel separador.
        separador = String.valueOf(separadorChar);
        //Inicia o botao btnSeparador ligando com o id button19
        Button btnSeparador = (Button)findViewById(R.id.button19);
        //Seta os atributos da variavel separador no botao btnSeparador
        btnSeparador.setText(separador);




        //No livro nao fala mas tá parecendo como instanciar um botao, o tipo do método é final Typeface, como nome que dei de fonteDigital recebendo uma biblioteca Typefacee o atributo createFromAsset.
        final Typeface fonteDigital = Typeface.createFromAsset(this.getAssets(), "digital.ttf");
        //Seto os atributos de fonteDigital no textVisor.
        textVisor.setTypeface(fonteDigital);
        //Evento de click do textVisor
        textVisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If para verificar se a fonte já é digital ou não, caso não seja ele seta a fonte digital
                if(textVisor.getTypeface().equals(fonteDigital)){
                    textVisor.setTypeface(Typeface.DEFAULT);
                }else {
                    textVisor.setTypeface(fonteDigital);
                }
            }
        });

        //Importa da biblioteca Toast a função makeText que é aquele balão na tela.
        Toast.makeText(this, "Toque no visor para trocar a sua fonte",
                //Mostrar na tela
                Toast.LENGTH_LONG).show();
    }


//Evento de click dos botoes.
    public void onClickNumeros(View v) {

        //Nas linhas abaixo ele pega o valor do batao na tela e  digito e  converte para String.
        Button botaoTocado = (Button) v;
        String digito = botaoTocado.getText().toString();
        String textoNoVisor = textVisor.getText().toString();

        //If verificar se usuarioEstaDigitandoUmNumero é nulo ou tem o 0 no textoNoVisor
        if (!usuarioEstaDigitandoUmNumero || textoNoVisor.equals("0")) {
            //Seta digito no textVisor
            textVisor.setText(digito);
            //If valor no visor é diferente de 0
            if (!digito.equals("0")) {
                // fala que a variável usuarioEstaDigitandoUmNumero é verdadeira.
                usuarioEstaDigitandoUmNumero = true;
            }
        } else {
            //Seta textoNoVisor + digito no textVisor
            textVisor.setText(textoNoVisor + digito);
        }
    }


    //Click do botao
    public void onClickOperacoes(View v) {
        //Pegao botao tocando e converte o valor dele para String
        Button botaoTocado = (Button) v;
        String operacoes = botaoTocado.getText().toString();


        //If Verificar se operacoes contém um separador e se separadorDecimalFoiDigitado é dferente de nulo
        if (operacoes.equals(separador) && !separadorDecimalFoiDigitado) {
            //Passando a variavel separadorDecimalFoiDigitado para true
            separadorDecimalFoiDigitado = true;
            //Verifica se usuarioEstaDigitandoUmNumero é diferente de nulo
            if (!usuarioEstaDigitandoUmNumero)
                //Seta no textVisor o valor de 0 + a variavel separador
                textVisor.setText("0" + separador);
            else
                //Setando no textVisor o valor de textVisor em String + separador
                textVisor.setText(textVisor.getText().toString() + separador);
            //Passa a variavel usuarioEstaDigitandoUmNumero para true
            usuarioEstaDigitandoUmNumero = true;

        }//Verifica se o separador é o correto
        else if (!operacoes.equals(separador)) {
            //Instancia uma nova variável Sting recebe textVisor convetendo ele para String e substituindo o separadorChar por .
            String valorSemVirgula = textVisor.getText().toString().replace(separadorChar,'.');
            //Convertendo para double
            calc.setOperando(Double.parseDouble(valorSemVirgula));
            //calc.realizarOperacao recebe como parametro operacoes
            calc.realizarOperacao(operacoes);
            //Instancia uma nova variavel do tipo Sting de nome textoResultado recebendo calc.getOperando() convertidos em String
            String textoResultado = String.valueOf(calc.getOperando());

            //Verifica se termina em .0
            if (textoResultado.endsWith(".0")) {
                //Caso termine ele faz o textoResultado receber ele mesmo porém com 2 casas a menos
                textoResultado = textoResultado.substring(0, textoResultado.length() - 2);
            }
            //Caso as operações não canham em nehum if ele colocará no textVisor o textoResultado substituindo o . por separadorChar
            textVisor.setText(textoResultado.replace('.', separadorChar));

            usuarioEstaDigitandoUmNumero = false;
            separadorDecimalFoiDigitado = false;
        }
    }

    //Método não utilizado.
//    public void onClickMemoria(View v) {
//        Button botaoTocado = (Button) v;
//        String operaca0Memoria = botaoTocado.getText().toString();
//        String valorSemVirgula = textVisor.getText().toString().replace(separadorChar,'.');
//        calc.setOperando(Double.parseDouble(valorSemVirgula));
//        calc.realizarOperacaoDeMemoria(operaca0Memoria);
//        usuarioEstaDigitandoUmNumero = false;
//    }
}

