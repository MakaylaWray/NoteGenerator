import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import HelperMethods.DateFormatter;

public class NoteGeneratorGui {
    private String currentDate = DateFormatter.formattedDate();
    private JPanel mainPanel;
    private JPanel loginPanel;
    private JPanel pendCodePanel;
    private JPanel verificationPanel;
    private JPanel pendOutreachStatusPanel;
    private JPanel finalPendNotePanel;
    private JTextField msidTextField;
    private JLabel loginPanelHeader;
    private JComboBox pendCodeDropDownBox;
    private JLabel pendCodePanelLabel;
    private JTextField unveriChartsTextField;
    private JTextField veriChartsTextField;
    private JTextField unveriProvidersTextField;
    private JTextField siteAddressTextField;
    private JComboBox destMethodDropDownBox;
    private JLabel veriChartsLabel;
    private JLabel unveriChartsLabel;
    private JLabel veriProvidersLabel;
    private JLabel unveriProvidersLabel;
    private JLabel siteAddressLabel;
    private JLabel destiMethodLabel;
    private JButton veriPanelBackButton;
    private JButton veriPanelContButton;
    private JRadioButton veriChartsNaButton;
    private JRadioButton unverifiedChartsNaButton;
    private JRadioButton veriProvidersNaButton;
    private JRadioButton unveriProvidersNaButton;
    private JRadioButton siteAddressNaButton;
    private JLabel finalPendNoteHeader;
    private JTextArea pendNoteTextBox;
    private JButton finalPendNoteBackButton;
    private JButton finalPendNoteNewButton;
    private JButton loginPanelContButton;
    private JButton pendCodePanelContButton;
    private JComboBox pendOutreachStatusPanelDropDownBox;
    private JLabel pendOutreachStatusPanelHeader;
    private JButton pendOutreachStatusPanelBackButton;
    private JButton pendOutreachStatusPanelContinueButton;
    private JPanel panelContainer;
    private JTextField veriProvidersTextField;
    private JTextField destInfoTextField;
    private JLabel destInfoLabel;
    private JLabel destAttnLabel;
    private JTextField destAttnTextField;

    public NoteGeneratorGui() {
        //Add ActionListener to Continue Button on LoginPanel
        loginPanelContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mainPanel.removeAll();
               mainPanel.add(pendCodePanel);
               mainPanel.repaint();
               mainPanel.revalidate();;
            }
        });
        // Add ActionListener to Continue Button on PendCodePanel
        pendCodePanelContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedOption = pendCodeDropDownBox.getSelectedItem();
                if (selectedOption == "Pend001"){
                    mainPanel.removeAll();
                    mainPanel.add(verificationPanel);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }
            }
        });

        //Add ActionListener to the Back Button of the Verification JPanel
        veriPanelBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(pendCodePanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        //Adds an action listener to the drop-down box for destination method
        destMethodDropDownBox.addActionListener(new ActionListener() {
            @Override
            /**
             * For each destination method selected, the appropiate label will show.
             * The Destination attn and info field is not visible when "No Provider Pacakge is selected"
             */
            public void actionPerformed(ActionEvent e) {
                Object selectedObject = destMethodDropDownBox.getSelectedItem();
                if (selectedObject == "Fax"){
                    destInfoLabel.setVisible(true);
                    destInfoTextField.setVisible(true);
                    destAttnLabel.setVisible(true);
                    destAttnTextField.setVisible(true);
                    destInfoLabel.setText("Fax Number");
                } else if (selectedObject == "Mail") {
                    destInfoLabel.setVisible(true);
                    destInfoTextField.setVisible(true);
                    destAttnLabel.setVisible(true);
                    destAttnTextField.setVisible(true);
                    destInfoLabel.setText("Mailing Address");
                } else if (selectedObject == "Email") {
                    destInfoLabel.setVisible(true);
                    destInfoTextField.setVisible(true);
                    destAttnLabel.setVisible(true);
                    destAttnTextField.setVisible(true);
                    destInfoLabel.setText("Email Address");
                }
                else{
                    destInfoLabel.setVisible(false);
                    destInfoTextField.setVisible(false);
                    destAttnLabel.setVisible(false);
                    destAttnTextField.setVisible(false);
                }
            }
        });
        //Add ActionListener to the continue button on the verification panel
        veriPanelContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(pendOutreachStatusPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        //Add ActionListener to the Continue Button on the Pend Outreach Status Frame
        pendOutreachStatusPanelContinueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(finalPendNotePanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        //Add ActionListener to the Back button on the Pend Outreach Status Frame
        pendOutreachStatusPanelBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();;
                mainPanel.add(verificationPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NoteGenerator");
        frame.setContentPane(new NoteGeneratorGui().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
