package Calc_rpn_package;

public interface Matematica_da_calculadora {
public double adicao(double valor1,double valor2);
public double subtracao(double valor1,double valor2);
public double multiplicacao(double valor1,double valor2);
public double divisao(double valor1,double valor2) throws ArithmeticException;
public double resto(double valor1,double valor2);
public double pow(double valor1,double valor2)throws excecao_pow;
double fatorial(double num_fat);

}
