package card_db_editor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import com.CardDB;
import com.Card;
import com.CardDBListener;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;


public class CardDBEditor extends JFrame implements CardDBListener{

	private JPanel contentPane;
	private JTextField txtPath;
	
	
	
	private CardDB db;
	private CardListTableModel tmodel;
	private JTable tblCardList;
	private JButton btnAddFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardDBEditor frame = new CardDBEditor();
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
	public CardDBEditor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPath = new JTextField();
		txtPath.setBounds(10, 11, 463, 20);
		contentPane.add(txtPath);
		txtPath.setColumns(10);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDB();
			}
		});
		btnOpen.setBounds(483, 10, 89, 23);
		contentPane.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save(txtPath.getText());
			}
		});
		btnSave.setBounds(582, 10, 89, 23);
		contentPane.add(btnSave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 46, 760, 413);
		contentPane.add(scrollPane);
		
		tblCardList = new JTable();
		tblCardList.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCardList);
		
		
		
		
		
		
		
		
		tblCardList.setAutoCreateRowSorter(true);
		
		btnAddFile = new JButton("Add File");
		btnAddFile.setBounds(681, 10, 89, 23);
		contentPane.add(btnAddFile);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCardDialog dialog= new AddCardDialog();
				dialog.setVisible(true);
				Card c = dialog.getCard();
				if(c!=null){
					if(db!=null){
						db.addCard(c);
					}
				}
			}
		});
		btnAdd.setBounds(10, 470, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(109, 470, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		btnRemove.setBounds(208, 470, 89, 23);
		contentPane.add(btnRemove);
	}
	
	
	private void openDB(){
		String path = txtPath.getText();
		
		try {
			CardDB db= new CardDB(path);
			setDB(db);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this,
				    "Couldn't finde file: "+path,
				    "Couldn't finde file!",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void setDB(CardDB _db){
		if(_db!=null){
			if(db!=null){
				this.db.removeCardDBListener(tmodel);
			}
			this.db=_db;
			tmodel= new CardListTableModel(db);
			tblCardList.setModel(tmodel);
			tblCardList.invalidate();
			tblCardList.validate();
		}else{
			if(db!=null){
				db.removeCardDBListener(tmodel);
				db=null;
				tblCardList.setModel(new DefaultTableModel(
						new Object[][] {
							{null, null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null, null},
						},
						new String[] {
							"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
						}
					));
			}
		}
	}
	
	private void save(String path){
		if(db!=null){
			try {
				db.toFileTest(txtPath.getText());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, e1);
				e1.printStackTrace();
			}
		}
	}
	
	
	private void remove(){
		if(tmodel!=null){
			int[] colls =tblCardList.getSelectedColumns();
			String[] names = new String[tblCardList.getSelectedColumnCount()];
			for(int i=0; i<tblCardList.getSelectedColumnCount();i++){
				names[i] = tmodel.getValueAt(1, colls[i]).toString();
				
			}
			for(int i=0; i< names.length;i++){
				db.removeCard(names[i]);
			}
		}
	}
	private void edit(){
		
	}

	@Override
	public void cardDBUpdated(CardDB db) {
		tblCardList.invalidate();
		tblCardList.validate();
	}
	
	
	
	class CardListTableModel extends AbstractTableModel implements CardDBListener{
		CardDB db;
		ArrayList<Card> cards;
		String[] colNames ={"ID", "Name", "Clan", "LvL", "POW", "DMG", "Condition", "Effect"};
		
		public CardListTableModel(CardDB db){
			this.db=db;
			db.addCardDBListener(this);
			cards= db.getCards();
			
		}
		@Override
		public int getColumnCount() {
			return 7+1;
		}

		@Override
		public int getRowCount() {
			return cards.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			Card c= cards.get(row);
			switch (col){
			case 0:
				return row;
			case 1:
				return c.getName();
			case 2:
				return c.getClan();
			case 3:
				return c.getLvl();
			case 4:
				return c.getPow();
			case 5:
				return c.getDmg();
			case 6:
				return c.getCondition();
			case 7:
				return c.getEffect();	
				
			default:
				return c.getName();
			}
		}
		public String getColumnName(int col) {
	        return colNames[col];
	    }

		@Override
		public void cardDBUpdated(CardDB db) {
			
			
		}
		
		
		
	}
}
