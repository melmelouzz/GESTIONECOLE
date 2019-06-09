package Vue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class Graphiquen {

	private JFrame frmBulletins;


	/**
	 * Create the application.
	 */
	public Graphiquen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmBulletins = new JFrame();
		frmBulletins.setTitle("Bulletins");
		frmBulletins.setVisible(true);
		frmBulletins.setBounds(100, 100, 745, 526);
		frmBulletins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBulletins.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
		frmBulletins.getContentPane().add(tabbedPane1, BorderLayout.NORTH);
	}
}
