package calc_rpn_package;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RPN {

	// map for storing the precedence levels of each operator
	private static final Map<String, Integer> precedeMapa;

	static {
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		pMap.put("^", 4);
		pMap.put("%", 3);
		pMap.put("*", 2);
		pMap.put("/", 2);
		pMap.put("+", 1);
		pMap.put("-", 1);

		precedeMapa = Collections.unmodifiableMap(pMap);
	} 



	public static String[] infixo_pra_pos_fixo(String[] Infixo) {


		List<String> pos_fixo = new ArrayList<String>();

		Stack<String> operador_pilha = new Stack<String>();


		if (Infixo.length != 0) {

			for (int i = 0; i < Infixo.length; i++) {


				Integer precede = precedeMapa.get(Infixo[i]);

				if (precede != null) {

					// then the current token is an operator
					while (!operador_pilha.isEmpty()) {
						String OPP = operador_pilha.pop();
						if (precedeMapa.get(OPP) < precede) {
							operador_pilha.push(OPP);
							break;
						} else {
							pos_fixo.add(OPP);
						} 
					} 

					operador_pilha.push(Infixo[i]);

				} else { 

					pos_fixo.add(Infixo[i]);
				} 

			} 

			while (!operador_pilha.isEmpty()) {
				pos_fixo.add(operador_pilha.pop());
			} 

		} 

		return pos_fixo.toArray(new String[pos_fixo.size()]);

	} 

	public static double avaliacao(Matematica_da_calculadora impl, String[] pos_fixo) throws ArithmeticException, excecao_pow, NumberFormatException {


		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < pos_fixo.length; i++) {

			if (pos_fixo[i].length() == 1 && !Character.isDigit(pos_fixo[i].charAt(0))) {



				String operador = pos_fixo[i];


				if (operador.equals("+")) {

					double valor2 = stack.pop();
					double valor1 = stack.pop();
					double resultado = impl.adicao(valor1, valor2);
					stack.add(resultado);
				} else if (operador.equals("-")) {
					double valor2 = stack.pop();
					double valor1 = stack.pop();
					double resultado = impl.subtracao(valor1, valor2);
					stack.add(resultado);
				} else if (operador.equals("*")) {
					double valor2 = stack.pop();
					double valor1 = stack.pop();
					double resultado = impl.multiplicacao(valor1, valor2);
					stack.add(resultado);
				} else if (operador.equals("/")) {
					double valor2 = stack.pop();
					double valor1 = stack.pop();
					double resultado = impl.divisao(valor1, valor2);
					stack.add(resultado);
				}  else if (operador.equals("^")) {
					double valor2 = stack.pop();
					double valor1 = stack.pop();
					double resultado= impl.pow(valor1, valor2);
					stack.add(resultado);
				} else if (operador.equals("!")) {
					double num = stack.pop();
					double resultado = impl.fatorial(num);
					stack.add(resultado);
				}
				else if (operador.equals("%")) {
					double valor2 = stack.pop();
					double valor1 = stack.pop();
					double resultado = impl.resto(valor1, valor2);
					stack.add(resultado);
				} 	

			} else {


				stack.add(Double.parseDouble(pos_fixo[i]));

			} 

		} 


		return stack.pop();

	} 


} 








	

