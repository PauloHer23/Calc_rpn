package Calc_rpn_package;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculadora  extends JPanel implements ActionListener {

	JButton adicao, subtracao, multiplicacao, divisao, power,resto,fatorial,espaco;
	JButton n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
	JButton igual, apagar, limpar;
	JButton RPN2;
	JButton ponto;
	ActionEvent e;

	public static int isRPN=0;

	public Calculadora() { 
		this.setLayout(new FlowLayout());
		final JTextArea tArea=new JTextArea(1,52);
		this.setLayout(new FlowLayout());
		this.adicao=new JButton("+");
		this.subtracao=new JButton("-");
		this.multiplicacao=new JButton("*");
		this.divisao=new JButton("/");
		this.resto=new JButton("%");
		this.power=new JButton("^");
		this.fatorial=new JButton("!");
		this.n0=new JButton("0");
		this.n1=new JButton("1");
		this.n2=new JButton("2");
		this.n3=new JButton("3");
		this.n4=new JButton("4");
		this.n5=new JButton("5");
		this.n6=new JButton("6");
		this.n7=new JButton("7");
		this.n8=new JButton("8");
		this.n9=new JButton("9");
		this.igual=new JButton("=");
		this.apagar=new JButton("apagar");
		this.limpar=new JButton("Limpar");
		this.RPN2=new JButton("RPN");
		this.ponto=new JButton(".");

		adicao.setBackground(Color.WHITE);
		subtracao.setBackground(Color.WHITE);
		multiplicacao.setBackground(Color.WHITE);
		divisao.setBackground(Color.WHITE);
		resto.setBackground(Color.WHITE);
		power.setBackground(Color.WHITE);
		fatorial.setBackground(Color.WHITE);
		n0.setBackground(Color.WHITE);
		n1.setBackground(Color.WHITE);
		n2.setBackground(Color.WHITE);
		n3.setBackground(Color.WHITE);
		n4.setBackground(Color.WHITE);
		n5.setBackground(Color.WHITE);
		n6.setBackground(Color.WHITE);
		n7.setBackground(Color.WHITE);
		n8.setBackground(Color.WHITE);
		n9.setBackground(Color.WHITE);

		igual.setBackground(Color.green);
		apagar.setBackground(Color.red);
		limpar.setBackground(Color.WHITE);
		RPN2.setBackground(Color.WHITE);
		ponto.setBackground(Color.WHITE);


		this.adicao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append(" + ");
			}
		});


		this.subtracao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append(" - ");
			}
		});

		this.multiplicacao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append(" * ");
			}
		});

		this.divisao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append(" / ");
			}
		});
		this.resto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append(" % ");
			}
		});


		this.power.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append(" ^ ");
			}
		});

		this.fatorial.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append(" ! ");
			}
		});



		this.n0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("0");
			}
		});

		this.n1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("1");
			}
		});
		this.n2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("2");
			}
		});
		this.n3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("3");
			}
		});
		this.n4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("4");
			}
		});
		this.n5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("5");
			}
		});
		this.n6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("6");
			}
		});
		this.n7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("7");
			}
		});this.n8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("8");
			}
		});
		this.n9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append("9");
			}
		});

		this.ponto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tArea.append(".");
			}

		});
		this.igual.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String temp=tArea.getText();
				//splits the string to an array
				String pre_fixo[]=temp.split(" ");
				Matematica_da_calculadora conceito_matematica=new conceito_matematica();	

				double conta_pow = -999999999;
				if(isRPN==1){

					try {
						conta_pow=RPN.avaliacao(conceito_matematica, pre_fixo);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (ArithmeticException e1) {
						e1.printStackTrace();
					} catch (excecao_pow e1) {
						e1.printStackTrace();
					}

				}
				else{

					String pos_fixo[]=RPN.pre_fixo_pra_pos_fixo(pre_fixo);


					try {
						conta_pow = RPN.avaliacao(conceito_matematica, pos_fixo);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (ArithmeticException e1) {
						e1.printStackTrace();
					} catch (excecao_pow e1) {
						e1.printStackTrace();
					}

				}
				String temp2=Double.toString(conta_pow);
				tArea.replaceRange(temp2,0,temp.length());
				isRPN=0; //resets to infix

			}

		});
		this.RPN2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String temp=tArea.getText();
				String pre_fixo[]=temp.split(" ");
				String pos_fixo[]=RPN.pre_fixo_pra_pos_fixo(pre_fixo);
				String temp2="";
				for(int i=0; i<pos_fixo.length; i++)
				{
					temp2=temp2+pos_fixo[i]+" ";
				}
				tArea.replaceRange(temp2, 0, temp.length());
				isRPN=1;
			}
		});

		this.apagar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String temp=tArea.getText();				
				String temp2=temp.substring(0, temp.length()-1);
				tArea.replaceRange(temp2, 0, temp.length());
			}
		});

		this.limpar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String temp=tArea.getText();

				tArea.replaceRange("", 0, temp.length());
				isRPN=0; 
			}
		});
		retorno(e);
		add(tArea);

		//add cal buttons
		add(this.adicao);
		add(this.subtracao);
		add(this.multiplicacao);
		add(this.divisao);
		add(this.resto);
		add(this.power);
		add(this.fatorial);

		add(this.n0);
		add(this.n1);
		add(this.n2);
		add(this.n3);
		add(this.n4);
		add(this.n5);
		add(this.n6);
		add(this.n7);
		add(this.n8);
		add(this.n9);

		add(this.ponto);

		add(this.igual);
		add(this.apagar);
		add(this.limpar);
		add(this.RPN2);

	}



	public static void criar_gui() {

		JFrame frame = new JFrame("Calculadora");		
		Calculadora calc = new Calculadora();

		frame.add(calc);		
		calc.setBackground(Color.GRAY);
		frame.setSize(600, 280);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		

	}





	public void retorno(ActionEvent e) {
		actionPerformed(e);
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		JOptionPane.showMessageDialog(null,"Calculadora RPN. Desenvolvido por PH Alves Silva");
	}


}




