import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import HelperMethods.DateFormatter;
import HelperMethods.NoteFormatter;

public class NoteGeneratorGui {

    //TODO Some Variables will need to be stored at at certain frames. See MSID for examples

    private String currentDate = DateFormatter.formattedDate();
    private JPanel mainPanel;
    private JPanel loginPanel;
    private JPanel pendCodePanel;
    private JPanel verificationPanel;
    private JPanel pendOutreachStatusPanel;
    private JPanel finalPendNotePanel;
    private JTextField msidTextField;
    private String msid;
    private JLabel loginPanelHeader;
    private JComboBox pendCodeDropDownBox;
    private Object selectedPendOption;
    private JLabel pendCodePanelLabel;
    private JTextField unveriChartsTextField;
    private String unveriCharts = unveriChartsTextField.getText();
    private JTextField veriChartsTextField;
    private String veriCharts = veriChartsTextField.getText();
    private JTextField unveriProvidersTextField;
    private String unveriProviders = unveriProvidersTextField.getText();
    private JTextField siteAddressTextField;
    private String siteAddress = siteAddressTextField.getText();
    private JComboBox destMethodDropDownBox;
    private JLabel veriChartsLabel;
    private JLabel unveriChartsLabel;
    private JLabel veriProvidersLabel;
    private JLabel unveriProvidersLabel;
    private JLabel siteAddressLabel;
    private JLabel destiMethodLabel;
    private JTextField veriProvidersTextField;
    private String veriProviders = veriProvidersTextField.getText();
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
    private JTextField destInfoTextField;
    private JLabel destInfoLabel;
    private JLabel destAttnLabel;
    private JTextField destAttnTextField;
    private JPanel pend2VerificationPanel;
    private JRadioButton agreedRadioButton;
    private JRadioButton refusedRadioButton;
    private JTextField pend2SiteAddressEntry;
    private JLabel didProviderAgree;
    private JLabel pend2ConfirmedAddress;
    private JLabel pend2DestinationLabel;
    private JComboBox pend2DestinationDropdown;
    private JTextField textField1;
    private JLabel pend2destinationEntryLabel;
    private JTextField pend2AttnEntry;
    private JLabel pend2AttnLabel;
    private JButton pend2BackButton;
    private JButton pend2ContinueButton;
    private JLabel pend2ReturnMethod;
    private JComboBox pend2RetirevalMethodDropdown;

    public NoteGeneratorGui() {
        //Add ActionListener to Continue Button on LoginPanel
        loginPanelContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msid = msidTextField.getText();
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
                selectedPendOption = pendCodeDropDownBox.getSelectedItem();

                //TODO Specific frames will need to be added based on the pend code selected.

                if (selectedPendOption == "Pend001"){
                    mainPanel.removeAll();
                    mainPanel.add(verificationPanel);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                } else if (selectedPendOption == "Pend002") {
                    mainPanel.removeAll();
                    mainPanel.add(pend2VerificationPanel);
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

                //TODO finish adding the parameters needed to complete the NoteFormatter

                NoteFormatter newNote = new NoteFormatter(msid, currentDate,selectedPendOption);
                String formattedText = newNote.formattedNote();
                pendNoteTextBox.setText(formattedText);
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

        //Add ActionListioner to the Continue button on the Pend002 Verification Frame
        pend2ContinueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(pendOutreachStatusPanel);
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
