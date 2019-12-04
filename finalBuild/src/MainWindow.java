import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigInteger;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = -3880026026104218593L;
	private Primes m_Primes;
	private JTextField tfPrimeFileName;
	private JTextField tfCrossFileName;
	private JLabel lblPrimeCount;
	private JLabel lblCrossCount;
	private JLabel lblLargestPrime;
	private JLabel lblLargestCross;
	private JLabel lblStatus;
	
	MainWindow(String name, Primes p)
	{
	  popupGenerateHex();
	  // popupGeneratePrimes();
	  
	}
	
	protected void popupGenerateHex()
	{
	  JFrame nameHexWindow = new JFrame("Hexagon Cross for Less");
	  GridBagLayout gridLayout = new GridBagLayout();
	  nameHexWindow.getContentPane().setBackground(new Color(80,0,0));
	  nameHexWindow.getContentPane().setLayout(gridLayout);
	  
	  GridBagConstraints gbcVals = new GridBagConstraints();
	  gbcVals.fill = GridBagConstraints.HORIZONTAL;
	  gbcVals.anchor = GridBagConstraints.WEST;
	  gbcVals.ipady = 10;
	  gbcVals.weightx = .5;
	  // gbcVals.weighty = 1.0;
	  gbcVals.insets = new Insets(1,0,2,0);
	  gbcVals.gridx = 0;
	  gbcVals.gridy = 0;
	  
	  GridBagConstraints gbcVals2 = new GridBagConstraints();
	  gbcVals2.anchor = GridBagConstraints.WEST;
      gbcVals2.weightx = .5;
      // gbcVals2.weighty = 1.0;
      // gbcVals2.ipadx = 10;
      gbcVals2.insets = new Insets(1,0,2,0);
      gbcVals2.gridx = 0;
      gbcVals2.gridy = 0;
      
      JPanel pnlGenerate = new JPanel();
      pnlGenerate.setLayout(new GridBagLayout());
	  
      JTextField tfPrimeFile = new JTextField("primes.txt");
      tfPrimeFile.setColumns(40);
      tfPrimeFile.setFont(new Font("Tahoma", Font.PLAIN, 12));
      gbcVals2.gridx = 0;
      gbcVals2.gridy = 0;
      pnlGenerate.add(tfPrimeFile,gbcVals2);
      
      JLabel amountPrimes = new JLabel("0");
      amountPrimes.setFont(new Font("Dialog", Font.BOLD, 12));
      gbcVals2.gridx = 1;
      gbcVals2.anchor = GridBagConstraints.CENTER;
      pnlGenerate.add(amountPrimes,gbcVals2);
      
      gbcVals2.anchor = GridBagConstraints.WEST;
      
      JLabel primeLabel = new JLabel("Primes File");
      primeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
      gbcVals2.gridx = 0;
      gbcVals2.gridy = 1;
      pnlGenerate.add(primeLabel,gbcVals2);
      
      JButton primeLoad = new JButton("Load");
      gbcVals2.gridx = 0;
      gbcVals2.gridy = 1;
      gbcVals2.anchor = GridBagConstraints.EAST;
      pnlGenerate.add(primeLoad,gbcVals2);
      
      gbcVals2.anchor = GridBagConstraints.WEST;
      
      JButton primeSave = new JButton("Save");
      System.out.println(primeSave.getFont());
      gbcVals2.gridx = 1;
      gbcVals2.gridy = 1;
      pnlGenerate.add(primeSave,gbcVals2);
      
      nameHexWindow.add(pnlGenerate,gbcVals);
      
      JPanel pnlGenerate2 = new JPanel();
      pnlGenerate2.setLayout(new GridBagLayout());
      
      JTextField tfHexFile = new JTextField("crosses.txt");
      tfHexFile.setColumns(40);
      tfHexFile.setFont(new Font("Tahoma", Font.PLAIN, 12));
      gbcVals2.gridx = 0;
      gbcVals2.gridy = 0;
      pnlGenerate2.add(tfHexFile,gbcVals2);
      
      JLabel amountHex = new JLabel("0");
      amountHex.setFont(new Font("Dialog", Font.BOLD, 12));
      gbcVals2.gridx = 1;
      gbcVals2.anchor = GridBagConstraints.CENTER;
      pnlGenerate2.add(amountHex,gbcVals2);
      
      gbcVals2.anchor = GridBagConstraints.WEST;
      
      JLabel HexLabel = new JLabel("Hexagon Cross File");
      HexLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
      gbcVals2.gridx = 0;
      gbcVals2.gridy = 1;
      pnlGenerate2.add(HexLabel,gbcVals2);
      
      JButton hexLoad = new JButton("Load");
      gbcVals2.gridx = 0;
      gbcVals2.gridy = 1;
      gbcVals2.anchor = GridBagConstraints.EAST;
      pnlGenerate2.add(hexLoad,gbcVals2);
      
      gbcVals2.anchor = GridBagConstraints.WEST;
      
      JButton hexSave = new JButton("Save");
      gbcVals2.gridx = 1;
      gbcVals2.gridy = 1;
      pnlGenerate2.add(hexSave,gbcVals2);
      
      gbcVals.gridy = 1;
      
      nameHexWindow.add(pnlGenerate2,gbcVals);
      
      JPanel pnlGenerate3 = new JPanel();
      pnlGenerate3.setLayout(new GridBagLayout());
      
      JButton genPrime = new JButton("Generate Primes");
      gbcVals2.gridx = 0;
      gbcVals2.gridy = 0;
      pnlGenerate3.add(genPrime,gbcVals2);
      
      JLabel largePrime = new JLabel("<html><div style = 'text-align: center;'> The largest prime has 0 digits. <br/> The larges cross has 0 and 0 digits. </html>");
      largePrime.setFont(new Font("Tahoma", Font.BOLD, 12));
      gbcVals2.gridx = 1;
      gbcVals2.gridy = 0;
      pnlGenerate3.add(largePrime,gbcVals2);
      
      JButton genCross = new JButton("Generate Crosses");
      gbcVals2.gridx = 2;
      gbcVals2.gridy = 0;
      pnlGenerate3.add(genCross,gbcVals2);
   
      gbcVals.gridy = 2;
      
      nameHexWindow.add(pnlGenerate3,gbcVals);
      
      JPanel pnlGenerate4 = new JPanel();
      pnlGenerate4.setLayout(new GridBagLayout());
      
      JLabel statusBar = new JLabel("Status");
      statusBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
      gbcVals2.gridx = 0;
      gbcVals2.gridy = 0;
      pnlGenerate4.add(statusBar,gbcVals2);
      
      gbcVals.gridy = 3;
      
      nameHexWindow.add(pnlGenerate4,gbcVals);
      
	  nameHexWindow.setSize(1000,400);
	  nameHexWindow.pack();
	  nameHexWindow.setVisible(true);
	}

	protected void popupGeneratePrimes()
	{
		JDialog dPrimes = new JDialog(this, "Prime Number Generation");
		GridBagLayout gridLayout = new GridBagLayout();
		dPrimes.getContentPane().setBackground(new Color(52, 0, 0));
		dPrimes.getContentPane().setLayout(gridLayout);
		
		GridBagConstraints gbcDialog = new GridBagConstraints();
		gbcDialog.fill = GridBagConstraints.HORIZONTAL;
		gbcDialog.anchor = GridBagConstraints.WEST;
		gbcDialog.ipady = 10;
		gbcDialog.weightx = .5;
		gbcDialog.insets = new Insets(1,2,0,0);
		gbcDialog.gridx = 0;
		gbcDialog.gridy = 0;
		
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		
		JPanel pnlGenerate = new JPanel();
		pnlGenerate.setLayout(new GridBagLayout());
		
		JLabel lblCount = new JLabel("Number of Primes to Generate");
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlGenerate.add(lblCount, gbcPanel);
		
		JTextField tfCount = new JTextField();
		lblCount.setLabelFor(tfCount);
		tfCount.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfCount, gbcPanel);
		
		JLabel lblStart = new JLabel("Starting Number (does not have to be prime)");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		pnlGenerate.add(lblStart, gbcPanel);
		
		JTextField tfStart = new JTextField();
		lblStart.setLabelFor(tfStart);
		tfStart.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfStart, gbcPanel);
		
		dPrimes.add(pnlGenerate, gbcDialog);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridBagLayout());
		
		JButton btnGeneratePrimes = new JButton("Generate Primes");
		btnGeneratePrimes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	try
      	{
      		BigInteger start = new BigInteger(tfStart.getText());
      		int count = Integer.parseInt(tfCount.getText());
       		m_Primes.generatePrimes(start, count);
       		lblStatus.setText("Status: Excited. Primes have been generated.");
       		updateStats();
      		dPrimes.dispose();
      	}
      	catch(NumberFormatException ex)
      	{
      		lblStatus.setText("You failed to type in an integer successfully. You are terrible at math. Shame.");
      		dPrimes.dispose();
      	}
      	
      }
    });
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		pnlButtons.add(btnGeneratePrimes, gbcPanel);
		
		JButton btnCancel = new JButton("Cancel Generation");
		btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	dPrimes.dispose();
      }
    });
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 1;
		pnlButtons.add(btnCancel, gbcPanel);		
		
		gbcDialog.gridy = 1;
		dPrimes.add(pnlButtons, gbcDialog);
		
		JPanel pnlStatus = new JPanel();
		pnlStatus.setLayout(new GridBagLayout());

		gbcPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;

		JLabel lblNotice = new JLabel("Warning: This application is single threaded, and will freeze while generating primes.");
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlStatus.add(lblNotice, gbcPanel);
		
		gbcDialog.gridy = 2;
		dPrimes.add(pnlStatus, gbcDialog);
		
		dPrimes.setSize(200,200);
		dPrimes.pack(); // Knowing what this is and why it is needed is important. You should read the documentation on this function!
		dPrimes.setVisible(true);		
	}

	// This function updates all the GUI statistics. (# of primes, # of crosses, etc)
	private void updateStats()
	{
 	}

}
