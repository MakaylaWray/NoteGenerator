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
    private String msid;
    private JLabel loginPanelHeader;
    private JComboBox pendCodeDropDownBox;
    private Object selectedPendOption;
    private String outreachid;
    private JTextField outreachIdEntryField;
    private JLabel outreachIdLabel;
    private JLabel pendCodePanelLabel;
    private JTextField phoneNumberEntryBox;
    private String phoneNumber;
    private JLabel phoneNumberLabel;
    private JTextField pend001SpokeToEntryBox;
    private JLabel pend1SpokeToLabel;
    private String spokeTo;
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
    private Object pendOutreachStatus;
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
    private Boolean isProviderVerifiedEmpty = true;
    private Boolean isChartsVerifiedEmpty = true;
    private Boolean isProviderUnverifiedEmpty = true;
    private Boolean isChartsUnverifiedEmpty = true;
    private Boolean isMemberVerifiedEmpty = true;

    public NoteGeneratorGui() {
        //Add ActionListener to Continue Button on LoginPanel
        loginPanelContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msid = msidTextField.getText();
                mainPanel.removeAll();
                mainPanel.add(pendCodePanel);
                mainPanel.repaint();
                mainPanel.revalidate();
                ;
            }
        });
        // Add ActionListener to Continue Button on PendCodePanel
        pendCodePanelContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPendOption = pendCodeDropDownBox.getSelectedItem();
                if (selectedPendOption == "Pend001") {
                    outreachid = outreachIdEntryField.getText();
                    phoneNumber = phoneNumberEntryBox.getText();
                    mainPanel.removeAll();
                    mainPanel.add(verificationPanel);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                } else if (selectedPendOption == "Pend002") {
                    outreachid = outreachIdEntryField.getText();
                    phoneNumber = phoneNumberEntryBox.getText();
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
                if (selectedObject == "Fax") {
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
                } else {
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
                if (veriProvidersTextField.getText().length() > 0) {
                    isProviderVerifiedEmpty = false;
                }
                if (unveriProvidersTextField.getText().length() > 0) {
                    isProviderUnverifiedEmpty = false;
                }
                if (veriChartsTextField.getText().length() > 0) {
                    isChartsVerifiedEmpty = false;
                }
                if (unveriChartsTextField.getText().length() > 0) {
                    isChartsUnverifiedEmpty = false;
                }
                veriProviders = veriProvidersTextField.getText();
                veriCharts = veriChartsTextField.getText();
                unveriProviders = unveriProvidersTextField.getText();
                unveriCharts = unveriChartsTextField.getText();

                spokeTo = pend001SpokeToEntryBox.getText();
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
                pendOutreachStatus = pendOutreachStatusPanelDropDownBox.getSelectedItem();
                mainPanel.removeAll();
                mainPanel.add(finalPendNotePanel);
                mainPanel.repaint();
                mainPanel.revalidate();

                pendNoteTextBox.setText(pendNoteParts());
            }
        });

        //Add ActionListener to the Back button on the Pend Outreach Status Frame
        pendOutreachStatusPanelBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
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
        //Add Action Listoner to the Back Button on the PendOutreach Frame
        finalPendNoteBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isChartsUnverifiedEmpty= true;
                isChartsVerifiedEmpty= true;
                isProviderVerifiedEmpty= true;
                isProviderUnverifiedEmpty= true;
                mainPanel.removeAll();
                mainPanel.add(verificationPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
    }
    public String pendNoteParts(){
        String goal;
        String providerPackage;
        String retrievalMethod;
        if (pendOutreachStatus == "Made Contact with Provider"){
            if (selectedPendOption == "Pend001"){
                goal = providerVerification() + " "+ memberVerification();
                return goal;
            }
        }
        return "Another option selected";
    }

    public String providerVerification() {
        if (isProviderVerifiedEmpty == true && isProviderUnverifiedEmpty == true) {
            return " ";
        } else if (isProviderVerifiedEmpty == false && isProviderUnverifiedEmpty == true) {
            return "Verified the provider(s): " + veriProviders + " at this location. ";
        } else if (isProviderVerifiedEmpty == true && isProviderUnverifiedEmpty == false) {
            return "Unable to verify the provider(s): " + unveriProviders + " at this location. ";
        }
        else {
            return "Verified the provider(s): " + veriProviders + " at this location. Unable to verify the provider(s): " + unveriProviders;
        }
    }
    public String memberVerification(){
        if (isChartsVerifiedEmpty == true && isChartsUnverifiedEmpty == true){
            return " ";
        }
        else if (isChartsVerifiedEmpty == false  && isChartsUnverifiedEmpty == true) {
            return "Verified the chart id(s): " + veriCharts + "DOS/at this location. ";
        }
        else if (isChartsVerifiedEmpty == true && isChartsUnverifiedEmpty == false){
            return "Unable to verify the chartid(s): " + unveriCharts + " DOS/at this location. ";
        }
        else{
            return "Verified the chartid(s): " + veriCharts + " DOS/at this location. Unable to verify the chartid(s): " + unveriCharts;
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("NoteGenerator");
        frame.setContentPane(new NoteGeneratorGui().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


