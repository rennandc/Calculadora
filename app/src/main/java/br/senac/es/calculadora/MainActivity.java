package br.senac.es.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String visor = "";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button13 = (Button) findViewById(R.id.button13);  // button13 = 1
        final Button button14 = (Button) findViewById(R.id.button14); // button14 = 2
        final Button button15 = (Button) findViewById(R.id.button15); // button15 = 3
        final Button button9 = (Button) findViewById(R.id.button9); // button9 = 4
        final Button button10 = (Button) findViewById(R.id.button10); //button10 = 5
        final Button button11 = (Button) findViewById(R.id.button11); //button11 = 6
        final Button button5 = (Button) findViewById(R.id.button5); // button5 = 7
        final Button button6 = (Button) findViewById(R.id.button6); //button6 = 8
        final Button button7 = (Button) findViewById(R.id.button7); // button7 = 9
        final Button button16 = (Button) findViewById(R.id.button16); // +
        final Button button12 = (Button) findViewById(R.id.button12); //-
        final Button button8 = (Button) findViewById(R.id.button8); //X
        final Button button20 = (Button) findViewById(R.id.button20); //=
        final Button button4 = (Button) findViewById(R.id.button4); //÷
        final Button button18 = (Button) findViewById(R.id.button18); //0
        final Button button2 = (Button) findViewById(R.id.button2); //+/-
        final Button buttonDel = (Button) findViewById(R.id.buttonDel); //buttonDel
        final TextView textVisor = (TextView) findViewById(R.id.textVisor);


        buttonDel.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
//
                                             visor = (visor.substring(0, visor.length() - 1));
                                             textVisor.setText(visor);


                                         }
                                     }
        );


        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "0";
                textVisor.setText(visor);
            }
        });


        // Botao =
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Botao ÷
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "÷";
                textVisor.setText(visor);
            }
        });


        //Botao x
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "x";
                textVisor.setText(visor);
            }
        });


        //Botao -
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (visor.substring(visor.length() - 1).contains("+")) {
                    visor = (visor.substring(0, visor.length() - 1));
                    visor = visor + "-";
                    textVisor.setText(visor);

                    if (visor.substring(visor.length() - 1).contains("-")){
                        textVisor.setText(visor);

                    }

                }

                else {
                    visor = visor + "-";
                    textVisor.setText(visor);
                }


                //Essa parte de baixo deu errado.
//                for(int i=0; i < visor.length(); i++){
//                    if(visor.charAt(i) == '+'){
//                        visor = (visor.substring(i,visor.length()-1));
//                        visor = visor + "-";
//                        textVisor.setText(visor);
//                    }else {
//                        visor = visor + "-";
//                        textVisor.setText(visor);
//                    }
//                }
//
//                visor.charAt(visor.length());
//
//
//                visor = (visor.substring(0,visor.length()-1));
//                textVisor.setText(visor);
//
//
//                    visor.(visor.length()-1);
//                   textVisor.setText(visor);


            }
        });


        // Botao +
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visor.substring(visor.length() - 1).contains("-")) {
                    visor = (visor.substring(0, visor.length() - 1));
                    visor = visor + "+";
                    textVisor.setText(visor);


                } else {
                    visor = visor + "+";
                    textVisor.setText(visor);
                }

            }
        });


        //Botao 9
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "9";
                textVisor.setText(visor);
            }
        });


        //Botao 9
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "8";
                textVisor.setText(visor);
            }
        });


        //Boatao 7
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "7";
                textVisor.setText(visor);
            }
        });


        //botao 6
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "6";
                textVisor.setText(visor);
            }
        });


        //botao 5
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "5";
                textVisor.setText(visor);
            }
        });


        //botao 4
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "4";
                textVisor.setText(visor);
            }
        });


        //botao 3
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "3";
                textVisor.setText(visor);

            }
        });


        //Botao 2
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "2";
                textVisor.setText(visor);


            }
        });


        //Botao numero 1
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = visor + "1";
                textVisor.setText(visor);


            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visor = "";
                textVisor.setText(visor);
            }
        });

    }


}
