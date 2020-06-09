package Genezis;

import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Core extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Scanner scam;
	private static Scanner scem;
		public Core() {
			JLabel lWiadomosc, lKod;
			JTextField tWiadomosc, tKod;
			JButton klocek, klocek2;
			
			setSize(400,200);
			setTitle("Agent Tomek");
			setLayout(null);
			
			lWiadomosc = new JLabel("Wpisz wiadomoœæ");
			lWiadomosc.setBounds(20,20,150,20);
			add(lWiadomosc);
			
			tWiadomosc = new JTextField("");
			tWiadomosc.setBounds(170,20,150,20);
			add(tWiadomosc);
			
			lKod = new JLabel("Szyfr :");
			lKod.setBounds(20,70,150,20);
			add(lKod);
			
			tKod = new JTextField("");
			tKod.setBounds(170,70,150,20);
			add(tKod);
			
			klocek = new JButton("szyfruj");
			klocek.setBounds(20,120,150,20);
			add(klocek);
			klocek.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					scam = new Scanner(tWiadomosc.getText());
					String tex = scam.nextLine();
					
					int tab[] = new int[tex.length()];
					int i = 0;
					int loby;
					for(; i<tex.length();i++) {
						loby = tex.charAt(i);
						tab[i] = (((loby*5)-2)-30)+2137;
					}
					String kod = "";
					for(int dep=tab.length-1; dep>=0;dep--) {
						kod = kod + String.valueOf(tab[dep]);
					}
					tKod.setText(kod);
				}}
			
				);
			
			klocek2 = new JButton("deszyfruj");
			klocek2.setBounds(180,120,150,20);
			add(klocek2);
			klocek2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent f) {
						scem = new Scanner(tKod.getText());
						String texy = scem.nextLine();
						int i= texy.length();
						int o =0;
						int p =4;
						int l = texy.length()/4;
						int gr[] = new int[l];
						for(;i>0;i=i-4) {
						String a = texy.substring(o,p);
						int ab = Integer.parseInt(a);
						int abc = (((ab-2137)+30)+2)/5;
						gr[l-1] = abc;
						l--;
						o=o+4;
						p=p+4;
						
						}
						l = texy.length()/4;
						String kon = "";
						for(int g = 0;g<l;g++) {
							char wyn = (char)gr[g];
							String wynik = String.valueOf(wyn);
							kon = kon + wynik;
				}
						tWiadomosc.setText(kon);
				}});
			}
			

	public static void main(String[] args) {
			Core okno = new Core();
			okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			okno.setVisible(true);
	}
}