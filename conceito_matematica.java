package calc_rpn_package;

public class conceito_matematica implements Matematica_da_calculadora {

	@Override
	public double adicao(double valor1, double valor2) {
		double resultado;
		return resultado=valor1+valor2;
	}

	@Override
	public double subtracao(double valor1, double valor2) {
		double resultado;
		return resultado=valor1-valor2;
	}

	@Override
	public double multiplicacao(double valor1, double valor2) {
		double resultado;
		return resultado=valor1*valor2;
	}

	@Override
	public double divisao(double valor1, double valor2)  {
		double resultado;
		return resultado=valor1/valor2;
	}






	@Override
	public double pow(double valor1, double valor2) throws excecao_pow {
		double contador=valor2;
		double conta_pow=1;

		if(valor2==0){
			return 1;
		}

		for ( ;contador>=1; contador--)
		{
			conta_pow=conta_pow*valor1;
		}
		for (;contador<0; contador++)
		{
			conta_pow=(conta_pow*valor1);
			if(contador==-1){
				conta_pow=1/conta_pow;
			}
		}
		return conta_pow;
	}

	@Override
	public double fatorial(double num_fat) {
		double contador=num_fat;
		double fatorial=1;
		if(num_fat<0) {
			throw new ArithmeticException();
		}
		for(int i=1;contador>=i;contador--) {
			fatorial=fatorial*contador;
		}

		return fatorial;
	}

	@Override
	public double resto(double valor1, double valor2) {
		double resultado;
		return resultado=valor1%valor2;
	}

	@Override
	public double negativo(double valor_negativo) {
		// TODO Auto-generated method stub
		return -valor_negativo;
	}






	
	


	

	

}