package br.senac.es.calculadora;

public class Calculadora {

    //Declarando as variaveis
    private double operando;
    private double operandoAnterior;
    //Essa ficou em String pois é a ela que guardará o operador
    private String operadorAnterior;
    private double memoria;

    //Método construtor
    public Calculadora() {
        //Instanciando os métodos como 0 e vazio.
        operando = 0;
        operandoAnterior = 0;
        operadorAnterior = "";
        memoria = 0;

    }
//Pelo fato de operando ser um private eu preciso criar os métodos get e set caso necessario, e aqui eu faço o getOperando
    public double getOperando() {
        return operando;
    }


    public void setOperando(double operando) {
        this.operando = operando;
    }

    private void realizarOperacaoAnterior() {
        if (!operadorAnterior.equals("")) {
            if (operadorAnterior.equals("+")) {
                operando = operandoAnterior + operando;
            } else if (operadorAnterior.equals("-")) {
                operando = operandoAnterior - operando;
            } else if (operadorAnterior.equals("X")) {
                operando = operandoAnterior * operando;
            } else if (operadorAnterior.equals("/")) {
                if (operando != 0) {
                    operando = operandoAnterior / operando;
                }
            }
        }
    }

    public void realizarOperacao(String op) {
        if (op.equals("%")) {
            operando = (operandoAnterior * operando) / 100;
        } else if (op.equals("+/-")) {
            operando = -operando;
        } else if (op.equals("C")) {
            operando = 0;
            memoria = 0;
            operadorAnterior = "";
        } else {
            realizarOperacaoAnterior();
            operadorAnterior = op;
            operandoAnterior = operando;
        }
    }

    public void realizarOperacaoDeMemoria(String opm) {
        if (opm.equals("mc")) {
            memoria = 0;
        } else if (opm.equals("m+")) {
            memoria += operando;
        } else if (opm.equals("m-")) {
            memoria -= operando;
        } else if (opm.equals("mr")) {
            operando = memoria;
        }

    }
}
