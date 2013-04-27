package card_db_editor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import com.Card;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCardDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtLevel;
	private JTextField txtPower;
	private JTextField txtDamage;
	private JTextField txtEffect;
	private JTextField txtEffectValue;
	private JTextField txtMin;
	private JTextField txtElo;
	private JTextField txtValue;
	private JComboBox cmbClan;
	private JComboBox cmbCondition;
	private JComboBox cmbRarity;
	
	private Card card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddCardDialog dialog = new AddCardDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCardDialog() {
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 580, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblName);
		}
		{
			txtName = new JTextField();
			txtName.setText("txtName");
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Clan:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			cmbClan = new JComboBox();
			cmbClan.setModel(new DefaultComboBoxModel(new String[] {"All_Stars", "Bangers", "Fang_Pi_Clang", "Freaks", "GHEIST", "Jungo", "Junkz", "La_Junta", "Leader", "Montana", "Nightmare", "Piranas", "Pussycats", "Rescue", "Roots", "Sakrohm", "Sentinel", "Skeelz", "Ulu_Watu", "Uppers"}));
			contentPanel.add(cmbClan);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Level:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtLevel = new JTextField();
			contentPanel.add(txtLevel);
			txtLevel.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("POW");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtPower = new JTextField();
			contentPanel.add(txtPower);
			txtPower.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("DMG:");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtDamage = new JTextField();
			contentPanel.add(txtDamage);
			txtDamage.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Condition:");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_4);
		}
		{
			cmbCondition = new JComboBox();
			cmbCondition.setModel(new DefaultComboBoxModel(new String[] {"Team: courage:", "Team:", "Support:", "Stop:", "Revenge:", "Protection:", "Courage:", "Confidence:"}));
			contentPanel.add(cmbCondition);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Effect:");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtEffect = new JTextField();
			contentPanel.add(txtEffect);
			txtEffect.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Effect Value:");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_6);
		}
		{
			txtEffectValue = new JTextField();
			contentPanel.add(txtEffectValue);
			txtEffectValue.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Effect Min:");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_7);
		}
		{
			txtMin = new JTextField();
			contentPanel.add(txtMin);
			txtMin.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Elo:");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_8);
		}
		{
			txtElo = new JTextField();
			contentPanel.add(txtElo);
			txtElo.setColumns(10);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("Rarity");
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_9);
		}
		{
			cmbRarity = new JComboBox();
			cmbRarity.setModel(new DefaultComboBoxModel(new String[] {"R", "U"}));
			contentPanel.add(cmbRarity);
		}
		{
			JLabel lblNewLabel_10 = new JLabel("Value");
			lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_10);
		}
		{
			txtValue = new JTextField();
			contentPanel.add(txtValue);
			txtValue.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						createCard();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
					
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public Card getCard(){
		return card;
	}
	public void createCard(){
		try{
		String name= txtName.getText();
		String clan = cmbClan.getSelectedItem().toString();
		int lvl = Integer.parseInt(txtLevel.getText());
		int pow = Integer.parseInt(txtPower.getText());
		int dmg = Integer.parseInt(txtDamage.getText());
		String cond = cmbCondition.getSelectedItem().toString();
		String effect = txtEffect.getText();
		int efVal = Integer.parseInt(txtEffectValue.getText());
		int effectMin = Integer.parseInt(txtMin.getText());
		String elo = txtElo.getText();
		String rarity = cmbRarity.getSelectedItem().toString();
		int value =  Integer.parseInt(txtValue.getText());
		card = new Card(name, clan , lvl,pow, dmg, cond, effect, efVal, effectMin, elo,rarity, value);
		this.setVisible(false);
		}catch(NumberFormatException e){
			card=null;
			JOptionPane.showMessageDialog(this, "NumerFormatException");
		}
		
	}
	public void closeD(){
		this.setVisible(false);
	}

}
