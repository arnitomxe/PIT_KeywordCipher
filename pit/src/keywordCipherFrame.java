import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class keywordCipherFrame extends JFrame {

	private JLayeredPane contentPane;
	private JTextField textField;
	private JTextArea textField_1;
	private JTextArea textField_2;

	/**
	 * Launch the application.
	 */
	
	//funkcijas
	String kodetiSimboli (char[] atsl) {	//izveido alfabetu no atslegvarda
		String kodets = "";
		
		for (int i = 0; i < atsl.length; i++)
		{
			
			if((atsl[i] >= 'a' && atsl[i] <= 'z') || 
					(atsl[i] >= 'A' && atsl[i] <= 'Z'))
			if(!kodets.contains(Character.toString(atsl[i])))
				kodets+= atsl[i];
		}
		
		for (int i = 0; i < 26; i++)
		{
			if(!kodets.contains(Character.toString((char) (i + 97))))
				kodets+= (char) (i + 97);
			if(!kodets.contains(Character.toString((char) (i + 65))))
				kodets+= (char) (i + 65);
		}
		
		return kodets;
	}
	
	String sifret (String tekstsSifret, String kodets) {	//Sifre ievadito tekstu
		String rezultats = "";
		
		for (int i = 0; i < tekstsSifret.length(); i++)
		{
			if(tekstsSifret.charAt(i) >= 'a' && tekstsSifret.charAt(i) <= 'z') {
				rezultats += kodets.charAt(((tekstsSifret.charAt(i)-97)*2));
				//int test = tekstsSifret.charAt(i)-97;
				//System.out.println("test1 " + test);
				//System.out.println("test2 " + kodets);
				//rezultats += kodets.charAt(test);
				//rezultats += tekstsSifret.charAt(i);
			}
			else
			if(tekstsSifret.charAt(i) >= 'A' && tekstsSifret.charAt(i) <= 'Z') {
				rezultats += kodets.charAt((tekstsSifret.charAt(i)-65)*2+1);
				//rezultats += tekstsSifret.charAt(i);
			}
			else
				rezultats += tekstsSifret.charAt(i);
		}
		
		return rezultats;
	}
	
	String atsifret (String tekstsAtsifret, String kodets) {	//atsifre ievadito tekstu
		String rezultats = "";
		String alfabets = "";
		
		for (int i = 0; i < 26; i++)	//genere alfabetu poziciju salidzinasanai
		{
				alfabets+= (char) (i + 97);
				alfabets+= (char) (i + 65);
		}
		
		for (int i = 0; i < tekstsAtsifret.length(); i++)
		{
			if(tekstsAtsifret.charAt(i) >= 'a' && tekstsAtsifret.charAt(i) <= 'z') {
				int vieta = kodets.indexOf(tekstsAtsifret.charAt(i));
				rezultats += alfabets.charAt(vieta);
				//rezultats += kodets.charAt(((tekstsAtsifret.charAt(i)-97)*2));
				//int test = tekstsSifret.charAt(i)-97;
				//System.out.println("test1 " + test);
				//System.out.println("test2 " + kodets);
				//rezultats += kodets.charAt(test);
				//rezultats += tekstsSifret.charAt(i);
			}
			else
			if(tekstsAtsifret.charAt(i) >= 'A' && tekstsAtsifret.charAt(i) <= 'Z') {
				int vieta = kodets.indexOf(tekstsAtsifret.charAt(i));
				rezultats += alfabets.charAt(vieta);
				//rezultats += kodets.charAt((tekstsAtsifret.charAt(i)-65)*2+1);
				//rezultats += tekstsSifret.charAt(i);
			}
			else
				rezultats += tekstsAtsifret.charAt(i);
		}
		
		return rezultats;
	}
	//funkcijas
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					keywordCipherFrame frame = new keywordCipherFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public keywordCipherFrame() {
		setTitle("Atsl\u0113gv\u0101rda \u0161ifr\u0113t\u0101js");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 360);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		
		JLabel lblKeyword = new JLabel("Atsl\u0113gv\u0101rds");
		
		JLabel lblNewLabel = new JLabel("Ne\u0161ifr\u0113ts Teksts");
		
		textField_1 = new JTextArea();
		textField_1.setLineWrap(true);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		
		JLabel lblifrtsTeksts = new JLabel("\u0160ifr\u0113ts teksts");
		
		textField_2 = new JTextArea();
		textField_2.setLineWrap(true);
		textField_2.setColumns(10);
		
		//poga ðifrçt
		JButton btnifrt = new JButton("\u0160ifr\u0113t");
		btnifrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String atsl;
				//atsl = textField.getText();
				String kodets = textField.getText();
				String sifretTekstu = textField_1.getText();
				//textField_2.setText(kodetiSimboli(kodets.toCharArray()));
				textField_2.setText(sifret(sifretTekstu, kodetiSimboli(kodets.toCharArray())));
				
			}
		});
		
		//poga atðifrçt
		JButton btnAtifrt = new JButton("At\u0161ifr\u0113t");
		btnAtifrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String kodets = textField.getText();
				String atsifretTekstu = textField_2.getText();
				textField_1.setText(atsifret(atsifretTekstu, kodetiSimboli(kodets.toCharArray())));
				
			}
		});
		
		JLabel lblAlfabtsAz = new JLabel("Alfab\u0113ts aA bB ... zZ");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblifrtsTeksts, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addComponent(textField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addGap(160))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnifrt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAtifrt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
							.addGap(15))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblKeyword)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblAlfabtsAz))
								.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
							.addGap(20))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKeyword)
						.addComponent(lblAlfabtsAz))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblNewLabel)
					.addGap(11)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblifrtsTeksts)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnifrt)
						.addComponent(btnAtifrt))
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
