package Vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphique extends JFrame{

	private JPanel pan ;
	private JPanel p1 ;
	private JPanel p2 ;

	
	public Graphique ()
	{      
		this.setTitle ("Gestion_Ecole");
		this.setSize (900,800);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		pan = new JPanel(); // instancier le panneau  
		p1 = new JPanel(); // instancier le panneau 
		p2 = new JPanel(); // instancier le panneau 

		
		this.getContentPane().add(p1, BorderLayout.NORTH);
		this.getContentPane().add(p2, BorderLayout.SOUTH);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
}
