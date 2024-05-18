import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteGeneratorGui {
    private JPanel mainPanel;
    private JPanel loginPanel;
    private JPanel pendCodePanel;
    private JPanel verificationPanel;
    private JPanel pendOutreachStatusPanel;
    private JPanel finalPendNotePanel;
    private JTextField textField1;
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
    private JRadioButton destiMethodNaButton;
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

    public NoteGeneratorGui() {
        //Add ActionLister to Continue Button on LoginPanel
        loginPanelContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mainPanel.removeAll();
               mainPanel.add(pendCodePanel);
               mainPanel.repaint();
               mainPanel.revalidate();;
            }
        });
        // Add ActionLister to Continue Button on PendCodePanel
        pendCodePanelContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedOption = pendCodeDropDownBox.getSelectedItem();
                if (selectedOption == "Pend001"){
                    mainPanel.removeAll();
                    mainPanel.add(verificationPanel);
                    mainPanel.repaint();
                    mainPanel.revalidate();

                    //Automatically set all fields to N/A
                    veriChartsNaButton.setSelected(true);
                    unverifiedChartsNaButton.setSelected(true);
                    veriProvidersNaButton.setSelected(true);
                    unveriProvidersNaButton.setSelected(true);
                    siteAddressNaButton.setSelected(true);
                    destiMethodNaButton.setSelected(true);
                }
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
