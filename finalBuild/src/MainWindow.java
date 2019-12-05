import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;


public class MainWindow extends JFrame {
  private static final long serialVersionUID = -3880026026104218593L;
  private Primes m_Primes = new Primes();
  private JTextField tfPrimeFileName = new JTextField(Config.PRIMEFILE);
  private JTextField tfCrossFileName = new JTextField(Config.CROSSFILE);
  private JLabel lblPrimeCount = new JLabel("0");
  private JLabel lblCrossCount = new JLabel("0");
  private JLabel lblLargestPrime = new JLabel("0");
  private JLabel lblLargestCrossOne = new JLabel("0");
  private JLabel lblLargestCrossTwo = new JLabel("0");
  private JLabel lblStatus = new JLabel("Status: Bored");
  private JFrame nameHexWindow;


  MainWindow(String name, Primes p) {
    // popupGeneratePrimes();
    popupGenerateHex();

  }

  protected void popupGenerateHex() {

    // Starts the Frame of GUI
    nameHexWindow = new JFrame(Config.APPLICATIONNAME);
    GridBagLayout gridLayout = new GridBagLayout();
    nameHexWindow.getContentPane().setBackground(new Color(80, 0, 0));
    nameHexWindow.getContentPane().setLayout(gridLayout);

    // GUI FRAME SETTINGS
    GridBagConstraints gbcVals = new GridBagConstraints();
    gbcVals.fill = GridBagConstraints.HORIZONTAL;
    gbcVals.anchor = GridBagConstraints.WEST;
    gbcVals.ipady = 10;
    gbcVals.weightx = .5;
    gbcVals.insets = new Insets(1, 0, 2, 0);
    gbcVals.gridx = 0;
    gbcVals.gridy = 0;

    // GUI PANEL SETTINGS
    GridBagConstraints gbcVals2 = new GridBagConstraints();
    gbcVals2.anchor = GridBagConstraints.WEST;
    gbcVals2.weightx = .5;
    gbcVals2.insets = new Insets(0, 2, 0, 0);
    gbcVals2.gridx = 0;
    gbcVals2.gridy = 0;

    // FIRST PANEL FOR PRIMES
    JPanel pnlGenerate = new JPanel();
    pnlGenerate.setLayout(new GridBagLayout());

    // PRIME FILE TEXT FIELD
    JTextField tfPrimeFile = new JTextField(tfPrimeFileName.getText());
    tfPrimeFile.setColumns(55);
    tfPrimeFile.setFont(new Font("Tahoma", Font.PLAIN, 12));
    gbcVals2.gridx = 0;
    gbcVals2.gridy = 0;
    pnlGenerate.add(tfPrimeFile, gbcVals2);

    // PRIME COUNTER
    JLabel amountPrimes = new JLabel(lblPrimeCount.getText());
    amountPrimes.setFont(new Font("Dialog", Font.BOLD, 12));
    gbcVals2.gridx = 1;
    gbcVals2.anchor = GridBagConstraints.CENTER;
    pnlGenerate.add(amountPrimes, gbcVals2);

    gbcVals2.anchor = GridBagConstraints.WEST;

    // PRIME LABEL
    JLabel primeLabel = new JLabel("Primes File");
    primeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
    gbcVals2.gridx = 0;
    gbcVals2.gridy = 1;
    pnlGenerate.add(primeLabel, gbcVals2);

    // PRIME FILE LOAD BUTTON
    JButton primeLoad = new JButton("Load");
    primeLoad.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boolean flag;
        flag = FileAccess.loadPrimes(m_Primes, tfPrimeFile.getText());
        tfPrimeFileName.setText(tfPrimeFile.getText());
        lblPrimeCount.setText("" + m_Primes.primeCount());
        lblLargestPrime.setText("" + m_Primes.sizeofLastPrime());
        if (flag) {
          lblStatus.setText("Status: Primes list loaded successfully.");
        } else {
          lblStatus.setText("Status: Primes list loaded unsuccessfully");
        }

        updateStats();
      }
    });
    gbcVals2.gridx = 0;
    gbcVals2.gridy = 1;
    gbcVals2.anchor = GridBagConstraints.EAST;
    pnlGenerate.add(primeLoad, gbcVals2);

    gbcVals2.anchor = GridBagConstraints.WEST;

    // PRIME FILE SAVE BUTTON
    JButton primeSave = new JButton("Save");
    primeSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boolean flag;
        flag = FileAccess.savePrimes(m_Primes, tfPrimeFile.getText());
        tfPrimeFileName.setText(tfPrimeFile.getText());
        if (flag) {
          lblStatus.setText("Status: Primes list saved successfully.");
        } else {
          lblStatus.setText("Status: Primes list saved unsuccessfully.");
        }
        updateStats();
      }
    });
    gbcVals2.gridx = 1;
    gbcVals2.gridy = 1;
    pnlGenerate.add(primeSave, gbcVals2);

    nameHexWindow.add(pnlGenerate, gbcVals);

    // PANEL FOR CROSSES
    JPanel pnlGenerate2 = new JPanel();
    pnlGenerate2.setLayout(new GridBagLayout());

    // PRIME FILE TEXT FIELD
    JTextField tfHexFile = new JTextField(tfCrossFileName.getText());
    tfHexFile.setColumns(55);
    tfHexFile.setFont(new Font("Tahoma", Font.PLAIN, 12));
    gbcVals2.gridx = 0;
    gbcVals2.gridy = 0;
    pnlGenerate2.add(tfHexFile, gbcVals2);

    // CROSS COUNTER
    JLabel amountHex = new JLabel(lblCrossCount.getText());
    amountHex.setFont(new Font("Dialog", Font.BOLD, 12));
    gbcVals2.gridx = 1;
    gbcVals2.anchor = GridBagConstraints.CENTER;
    pnlGenerate2.add(amountHex, gbcVals2);

    gbcVals2.anchor = GridBagConstraints.WEST;

    // CROSS LABEL
    JLabel HexLabel = new JLabel("Hexagon Cross File");
    HexLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
    gbcVals2.gridx = 0;
    gbcVals2.gridy = 1;
    pnlGenerate2.add(HexLabel, gbcVals2);

    // CROSS LOAD BUTTON
    JButton hexLoad = new JButton("Load");
    hexLoad.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boolean flag = false;
        flag = FileAccess.loadCrosses(m_Primes, tfHexFile.getText());
        tfCrossFileName.setText(tfHexFile.getText());
        lblCrossCount.setText("" + m_Primes.crossesCount());
        lblLargestCrossOne.setText("" + m_Primes.sizeofLastCross().left());
        lblLargestCrossTwo.setText("" + m_Primes.sizeofLastCross().right());
        if (flag) {
          lblStatus.setText("Status: Cross list loaded succesfully");
        } else {
          lblStatus.setText("Status: Cross list loaded unsuccesfully");
        }

        updateStats();
      }
    });
    gbcVals2.gridx = 0;
    gbcVals2.gridy = 1;
    gbcVals2.anchor = GridBagConstraints.EAST;
    pnlGenerate2.add(hexLoad, gbcVals2);

    gbcVals2.anchor = GridBagConstraints.WEST;

    // CROSS SAVE BUTTON
    JButton hexSave = new JButton("Save");
    hexSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boolean flag;
        flag = FileAccess.saveCrosses(m_Primes, tfHexFile.getText());
        if (flag) {
          lblStatus.setText("Status: Cross list saved successfully.");
        } else {
          lblStatus.setText("Status: Cross list saved unsuccessfully .");
        }
        updateStats();
      }
    });
    gbcVals2.gridx = 1;
    gbcVals2.gridy = 1;
    pnlGenerate2.add(hexSave, gbcVals2);

    gbcVals.gridy = 1;

    nameHexWindow.add(pnlGenerate2, gbcVals);

    // PANEL FOR GENERATION
    JPanel pnlGenerate3 = new JPanel();
    pnlGenerate3.setLayout(new GridBagLayout());


    // GENERATE PRIMES BUTTON
    JButton genPrime = new JButton("Generate Primes");
    genPrime.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        lblStatus.setText("Status: Excited. Primes have been generated.");
        popupGeneratePrimes();

      }
    });
    gbcVals2.gridx = 0;
    gbcVals2.gridy = 0;
    gbcVals2.insets = new Insets(0, 20, 0, 0);
    pnlGenerate3.add(genPrime, gbcVals2);

    // LABEL FOR AMOUNT OF DIGITS
    JLabel largePrime =
        new JLabel("<html><div style = 'text-align: center;'> The largest prime has "
            + lblLargestPrime.getText() + " digits. <br/> The larges cross has "
            + lblLargestCrossOne.getText() + " and " + lblLargestCrossTwo.getText()
            + " digits. </html>");
    largePrime.setFont(new Font("Tahoma", Font.BOLD, 12));
    gbcVals2.gridx = 1;
    gbcVals2.gridy = 0;
    pnlGenerate3.add(largePrime, gbcVals2);

    // GENERATE CROSSES BUTTON
    JButton genCross = new JButton("Generate Crosses");
    genCross.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        m_Primes.generateTwinPrimes();
        m_Primes.generateHexPrimes();
        lblCrossCount.setText("" + m_Primes.crossesCount());
        lblLargestCrossOne.setText("" + m_Primes.sizeofLastCross().left());
        lblLargestCrossTwo.setText("" + m_Primes.sizeofLastCross().right());
        lblStatus.setText("Status: Excited. Crosses have been generated.");
        updateStats();
      }
    });
    gbcVals2.gridx = 2;
    gbcVals2.gridy = 0;
    pnlGenerate3.add(genCross, gbcVals2);

    gbcVals.gridy = 2;

    nameHexWindow.add(pnlGenerate3, gbcVals);


    // STATUS PANEL
    JPanel pnlGenerate4 = new JPanel();
    pnlGenerate4.setLayout(new GridBagLayout());

    // STATUS LABEL
    JLabel statusBar = new JLabel(lblStatus.getText());
    statusBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    gbcVals2.insets = new Insets(0, 2, 0, 0);
    gbcVals2.gridx = 0;
    gbcVals2.gridy = 0;
    pnlGenerate4.add(statusBar, gbcVals2);

    gbcVals.gridy = 3;

    nameHexWindow.add(pnlGenerate4, gbcVals);

    // CREATE WINDOW
    nameHexWindow.setSize(1000, 400);
    nameHexWindow.pack();
    nameHexWindow.setVisible(true);
  }

  // THIS IS ALL GLEN'S CODE (DO NOT TOUCH PLZ)
  protected void popupGeneratePrimes() {
    JDialog dPrimes = new JDialog(this, "Prime Number Generation");
    GridBagLayout gridLayout = new GridBagLayout();
    dPrimes.getContentPane().setBackground(new Color(52, 0, 0));
    dPrimes.getContentPane().setLayout(gridLayout);

    GridBagConstraints gbcDialog = new GridBagConstraints();
    gbcDialog.fill = GridBagConstraints.HORIZONTAL;
    gbcDialog.anchor = GridBagConstraints.WEST;
    gbcDialog.ipady = 10;
    gbcDialog.weightx = .5;
    gbcDialog.insets = new Insets(1, 2, 0, 0);
    gbcDialog.gridx = 0;
    gbcDialog.gridy = 0;

    GridBagConstraints gbcPanel = new GridBagConstraints();
    gbcPanel.anchor = GridBagConstraints.WEST;
    gbcPanel.weightx = .5;
    gbcPanel.insets = new Insets(1, 2, 0, 0);
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
        try {
          BigInteger start = new BigInteger(tfStart.getText());
          int count = Integer.parseInt(tfCount.getText());
          m_Primes.generatePrimes(start, count);
          lblPrimeCount.setText("" + m_Primes.primeCount());
          lblLargestPrime.setText("" + m_Primes.sizeofLastPrime());
          lblStatus.setText("Status: Excited. Primes have been generated.");
          updateStats();
          dPrimes.dispose();
        } catch (NumberFormatException ex) {
          lblStatus.setText(
              "You failed to type in an integer successfully. You are terrible at math. Shame.");
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
    gbcPanel.insets = new Insets(1, 2, 0, 0);
    gbcPanel.gridx = 0;
    gbcPanel.gridy = 1;

    JLabel lblNotice = new JLabel(
        "Warning: This application is single threaded, and will freeze while generating primes.");
    lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 12));
    pnlStatus.add(lblNotice, gbcPanel);

    gbcDialog.gridy = 2;
    dPrimes.add(pnlStatus, gbcDialog);

    dPrimes.setSize(200, 200);
    dPrimes.pack(); // Knowing what this is and why it is needed is important. You should read the
                    // documentation on this function!
    dPrimes.setVisible(true);
  }

  // This function updates all the GUI statistics. (# of primes, # of crosses, etc)
  private void updateStats() {

    // DESTROYS FRAME AND RECREATES SAME FRAME, MAKES IT SO NEW VALUES ARE IN
    nameHexWindow.dispose();
    popupGenerateHex();
  }

}
