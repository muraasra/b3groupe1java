package tppoo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Result;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class App1 {

	private JFrame frame;
	private JTextField Nom;
	private JTextField Matricule_E;
	private JTextField Prenom;
	private JTextField Age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App1 window = new App1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		DbConnection con1 = new DbConnection();
		con1.connection();
		frame = new JFrame();
		//frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setBounds(200, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Administrateur");
		/* Panel de connection */
		JPanel panel_connexion = new JPanel();

		// JPanel panel_titre = new JPanel();
		// panel_titre.setBounds(0, 0, 882, 32);
		// panel_titre.setBackground(new Color(0, 0, 0));

		// frame.getContentPane().add(panel_titre);
		// panel_titre.add(barre_menu);

		
			JMenuBar barre_menu = new JMenuBar();
			barre_menu.setMargin(new Insets(5, 50, 0, 0));
			barre_menu.setBounds(0,0,900,20);
			
			frame.getContentPane().add(barre_menu);
	
			JMenu fichier = new JMenu("Fichier");
			barre_menu.add(fichier);
	
			JMenuItem recherche = new JMenuItem("Recherche");
			fichier.add(recherche);
	
			JMenuItem explorer = new JMenuItem("Explorer");
			fichier.add(explorer);
	
			JMenuItem accueil = new JMenuItem("Accueil");
			fichier.add(accueil);
	
			JMenu menu_gerer = new JMenu("Etudiant");
			barre_menu.add(menu_gerer);
	
			JMenuItem ajouter_etudiant = new JMenuItem("Gerer un etudiant");
			menu_gerer.add(ajouter_etudiant);
	
			JMenuItem item_affiche1 = new JMenuItem("Afficher");
			menu_gerer.add(item_affiche1);
	
			// JButton button_Affiche = new JButton("Afficher");
			// button_Affiche.setBounds(200, 450, 102, 33);
			// item_affiche1.add(button_Affiche);
			
			JMenu mnMenu = new JMenu("Autre");
			barre_menu.add(mnMenu);
	
			JMenuItem menu2item_affiche1 = new JMenuItem("Enregistrer");
			mnMenu.add(menu2item_affiche1);
	
			JMenuItem menu2Item_affiche2 = new JMenuItem("Plus...");
			mnMenu.add(menu2Item_affiche2);
			barre_menu.setVisible(false);

		/*Panel recheche */
		JPanel panel_recherche = new JPanel();
		panel_recherche.setForeground(new Color(0, 0, 0));
		panel_recherche.setToolTipText("Ajouter un etudiant");
		panel_recherche.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_recherche.setBounds(0, 0, 900, 700);
		frame.getContentPane().add(panel_recherche);
		panel_recherche.setLayout(null);
		panel_recherche.setVisible(false);
		
		/*Panel de la page d accueil */
		JPanel panel_accueil = new JPanel();
		panel_accueil.setForeground(new Color(0, 0, 0));
		panel_accueil.setToolTipText("Ajouter un etudiant");
		panel_accueil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(panel_accueil);
		panel_accueil.setLayout(null);
		panel_accueil.setBounds(0, 0, 900, 700);
		accueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				panel_accueil.setVisible(true);
				barre_menu.setVisible(false);
				
				
				
		panel_recherche.setVisible(false);
			}
		});
		JLabel label_accueil1 = new JLabel("Bienvenue sur l'application");
		label_accueil1.setFont(new Font("Tahoma", Font.PLAIN, 56));
		label_accueil1.setBounds(100, 150, 700, 50);
		panel_accueil.add(label_accueil1);

		JLabel label_accueil2 = new JLabel("Gestion Des Etudiants");
		label_accueil2.setFont(new Font("Times new roman", Font.PLAIN, 56));
		label_accueil2.setBounds(180, 250, 700, 50);
		panel_accueil.add(label_accueil2);

		JLabel label_accueil3 = new JLabel("Cette application est concu pour la gestion des etudiant");
		label_accueil3.setFont(new Font("Tahoma ", Font.PLAIN, 26));
		label_accueil3.setBounds(100, 400, 700, 50);
		panel_accueil.add(label_accueil3);

		JLabel label_accueil4 = new JLabel("Veillez cliquer sur connection pour vous connecter");
		label_accueil4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_accueil4.setBounds(100, 450, 700, 50);
		panel_accueil.add(label_accueil4);

		JButton connection = new JButton("Connection");
		connection.setBounds(350, 550, 150, 40);
		panel_accueil.add(connection);

		connection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                panel_accueil.setVisible(false);
                barre_menu.setVisible(false);
				panel_connexion.setVisible(true);
	
            }});





		
       




        /*Panel de recherche */





       








		/* Panel de connection */
		JLabel label_connection = new JLabel("Veiller entrer vos donnees");
		//label_connection.setForeground(new Color(0,0 , 255));
		label_connection.setFont(new Font("Times new roman", Font.PLAIN, 18));
		label_connection.setBounds(70, 0, 300, 19);
		panel_connexion.add(label_connection);
		
		final JPasswordField password = new JPasswordField();
		//Password.setForeground(new Color(255, 0, 128));
		//Password.setFont(new Font("Tahoma", Font.PLAIN, 13));
		password.setBounds(190, 80, 200, 19);
		panel_connexion.add(password);

		

		//panel_connexion.setForeground(new Color(0, 0, 0));
		panel_connexion.setToolTipText("Ajouter un etudiant");
		panel_connexion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(panel_connexion);
		panel_connexion.setLayout(null);
		panel_connexion.setBounds(250, 200, 400, 200);

		JLabel lblNewLabel1 = new JLabel("Nom d'Utilisateur ");
		//lblNewLabel1.setForeground(new Color(255, 0, 128));
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel1.setBounds(0, 30, 150, 19);
		panel_connexion.add(lblNewLabel1);

		JTextField Nom_user = new JTextField(" Entrer le nom Utilisateur ");
		//Nom_user.setForeground(new Color(255, 0, 128));
		Nom_user.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Nom_user.setBounds(190, 30, 200, 19);
		panel_connexion.add(Nom_user);

		JLabel lblNewLabel11 = new JLabel("Mots de passe ");
		//lblNewLabel11.setForeground(new Color(255, 0, 128));
		lblNewLabel11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel11.setBounds(0, 80, 300, 19);
		panel_connexion.add(lblNewLabel11);


		JButton btn_connection = new JButton("Connection");
		btn_connection.setBounds(130, 150, 130, 35);
		panel_connexion.add(btn_connection);
		char[] passwordCharArray1 = password.getPassword();
		String passwordField1 = new String(passwordCharArray1);

		
		
		
		btn_connection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result;
				try {
					result = con1.st.executeQuery("SELECT count(*) FROM etudiant WHERE nom='" + Nom_user.getText()
							+ "' AND prenom='" + passwordField1 + "'");
					System.out.println("Ca a marché");
					result.next();
					if (result.getInt("count(*)") > 0) {
						JOptionPane.showMessageDialog(null, passwordField1, "Connection echoue",
								JOptionPane.ERROR_MESSAGE);
		
					} else if (result.getInt("count(*)") == 0) {
						panel_connexion.setVisible(false);
						barre_menu.setVisible(true);
		
						// Afficher la liste des étudiants après connexion réussie
						ResultSet studentResult = con1.st.executeQuery("SELECT * FROM etudiant ORDER BY nom ASC");
		
						String columns[] = { "Matricule_E", "Nom", "PRENOM", "Sexe", "Age", "Filiere" };
		
						Object data[];
						DefaultTableModel table_etudiant_affiche = new DefaultTableModel(columns, 0) {
							private static final long serialVersionUID = 1L;
		
							public boolean isCellEditable(int row, int col) {
								return false;
							};
						};
		
						while (studentResult.next()) {
							data = new Object[] {
									studentResult.getString("matricule"),
									studentResult.getString("nom"),
									studentResult.getString("prenom"),
									studentResult.getString("sexe"),
									studentResult.getString("age"),
									studentResult.getString("filiere")
							};
							table_etudiant_affiche.addRow(data);
						}
		
						JTable table_affiche_etudiant = new JTable(table_etudiant_affiche);
						table_affiche_etudiant.setShowGrid(true);
						table_affiche_etudiant.setShowVerticalLines(true);
						table_affiche_etudiant.setShowHorizontalLines(true);
						table_affiche_etudiant.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
						JScrollPane panel_affichage_etudiant = new JScrollPane(table_affiche_etudiant);
						panel_affichage_etudiant.setBounds(50, 83, 700, 550);
						panel_affichage_etudiant
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
						panel_affichage_etudiant
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
						frame.getContentPane().add(panel_affichage_etudiant);
						frame.repaint();
		
						JOptionPane.showMessageDialog(null, "Connection reusie !!");
					}
				} catch (SQLException e2) {
					System.out.println("Ca n'a pas  marché");
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erreur liée la base de données!",
							"Etudiant non ajouter.eleve nom ajouter", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		/*Panel ajouter  */
		frame.repaint();
				JPanel panel_ajouter = new JPanel();
		panel_ajouter.setForeground(new Color(0, 0, 0));
		panel_ajouter.setToolTipText("Ajouter un etudiant");
		panel_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_ajouter.setBounds(50, 83, 700, 550);
		frame.getContentPane().add(panel_ajouter);
		panel_ajouter.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("GERER UN ETUDIANT ");
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(250, 30, 300, 40);
		panel_ajouter.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(100, 150, 90, 19);
		panel_ajouter.add(lblNewLabel_1);

		Nom = new JTextField();
		Nom.setBounds(200, 150, 300, 19);
		panel_ajouter.add(Nom);
		Nom.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Matricule :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(100, 100, 90, 19);
		panel_ajouter.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("Prenom :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(100, 200, 90, 19);
		panel_ajouter.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Age :");
		lblNewLabel_1_4.setBounds(100, 300, 81, 19);
		panel_ajouter.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Filiere : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(100, 350, 81, 19);
		panel_ajouter.add(lblNewLabel_1_5);

		Matricule_E = new JTextField();
		Matricule_E.setBounds(200, 100, 300, 19);
		panel_ajouter.add(Matricule_E);
		Matricule_E.setColumns(10);

		Prenom = new JTextField();
		Prenom.setColumns(10);
		Prenom.setBounds(200, 200, 300, 19);
		panel_ajouter.add(Prenom);

		Age = new JTextField();
		Age.setColumns(10);
		Age.setBounds(200, 300, 300, 19);
		panel_ajouter.add(Age);

		JLabel sexe = new JLabel("Sexe:");
		sexe.setBounds(100, 250, 90, 19);
		panel_ajouter.add(sexe);

		JRadioButton feminin = new JRadioButton("F");
		feminin.setBounds(250, 250, 45, 21);
		panel_ajouter.add(feminin);

		JRadioButton masculin = new JRadioButton("M");
		masculin.setBounds(200, 250, 51, 21);
		panel_ajouter.add(masculin);
		masculin.setSelected(true);
		masculin.setActionCommand("M");
		feminin.setActionCommand("F");

		ButtonGroup btn_sexe = new ButtonGroup();
		btn_sexe.add(masculin);
		btn_sexe.add(feminin);

		JComboBox Filiere = new JComboBox();
		Filiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		Filiere.setModel(new DefaultComboBoxModel(new String[] { "Science de donnee", "Big Data", "Securite ",
				"Administration systeme", "Administration reseaux", "Genie logiciel" }));
		Filiere.setBounds(200, 350, 300, 19);
		panel_ajouter.add(Filiere);

		JButton btn_motifier = new JButton("Modifier");
		btn_motifier.setBounds(200, 450, 102, 33);
		panel_ajouter.add(btn_motifier);
		btn_motifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con1.st.executeUpdate("UPDATE etudiant set nom='"+ Nom.getText() + "',prenom ='" + Prenom.getText() + "' ,sexe ='" + btn_sexe.getSelection().getActionCommand() + "',age='" + Age.getText() + "',filiere='"+ Filiere.getSelectedItem() + "' WHERE matricule= '"+Matricule_E.getText() + "'");
							
					System.out.println("Ca a marché");
					JOptionPane.showMessageDialog(null, "Modification reussi!");

				} catch (Exception e2) {
					System.out.println("Ca n'a pas  marché");
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erreur liée la base de données! Modification echoue!",
							"Etudiant non ajouter.eleve nom ajouter", JOptionPane.ERROR_MESSAGE);

				}

		frame.repaint();	}
		});

		JButton btn_ajouter = new JButton("Ajouter");
		btn_ajouter.setBounds(400, 450, 102, 33);
		panel_ajouter.add(btn_ajouter);
		btn_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con1.st.executeUpdate("INSERT INTO etudiant (matricule,nom,prenom,sexe,age,filiere) VALUES('"
							+ Matricule_E.getText() + "','" + Nom.getText() + "','" + Prenom.getText() + "','"
							+ btn_sexe.getSelection().getActionCommand() + "','" + Age.getText() + "','"
							+ Filiere.getSelectedItem() + "')");
					System.out.println("Ca a marché");
					JOptionPane.showMessageDialog(null, "Success!");

				} catch (Exception e2) {
					System.out.println("Ca n'a pas  marché");
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erreur liée la base de données!",
							"Etudiant non ajouter.eleve nom ajouter", JOptionPane.ERROR_MESSAGE);

				}

		frame.repaint();	}
		});

		JButton btn_delete = new JButton("Supprimer");
		btn_delete.setBounds(30, 450, 102, 33);
		panel_ajouter.add(btn_delete);
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con1.st.executeUpdate("DELETE FROM etudiant WHERE matricule= '"+Matricule_E.getText() + "'");
							
					System.out.println("Ca a marché");
					JOptionPane.showMessageDialog(null, "Suppression reussi!");

				} catch (Exception e2) {
					System.out.println("Ca n'a pas  marché");
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erreur liée la base de données! Suppression echoue!",
							"Etudiant non supprimer.eleve non supprimer", JOptionPane.ERROR_MESSAGE);

				}

			}
		
		}
		);
		
		item_affiche1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_ajouter.setVisible(false);
				panel_accueil.setVisible(false);
				barre_menu.setVisible(true);
		panel_recherche.setVisible(false);


				
				ResultSet result;

				try {
					result = con1.st.executeQuery("SELECT * FROM etudiant order by nom ASC");

					String columns[] = { "Matricule_E", "Nom", "PRENOM", "Sexe", "Age", "Filiere" };

					Object data[];
					DefaultTableModel table_etudiant_affiche = new DefaultTableModel(columns, 0) {
						private static final long serialVersionUID = 1L;

						public boolean isCellEditable(int row, int col) {
							return false;
						};
					};

					//int k = 1;
					while (result.next()) {
						data = new Object[] {
								// k,
								result.getString("matricule"),
								result.getString("nom"),
								result.getString("prenom"),
								result.getString("sexe"),
								result.getString("age"),
								result.getString("filiere")

						};

						//k++;
						table_etudiant_affiche.addRow(data);
					}

					JTable table_affiche_etudiant = new JTable(table_etudiant_affiche);
					table_affiche_etudiant.setShowGrid(true);
					table_affiche_etudiant.setShowVerticalLines(true);
					table_affiche_etudiant.setShowHorizontalLines(true);
					table_affiche_etudiant.setFont(new Font("Times New Roman", Font.PLAIN, 13));

					JScrollPane panel_affichage_etudiant = new JScrollPane(table_affiche_etudiant);
					panel_affichage_etudiant.setBounds(50, 83, 700, 550);
					panel_affichage_etudiant
							.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
					panel_affichage_etudiant
							.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

					frame.getContentPane().add(panel_affichage_etudiant);

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erreur liée la base de données!", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
			panel_ajouter.setVisible(false);

		panel_connexion.setVisible(false);

		ajouter_etudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_accueil.setVisible(false);
				panel_ajouter.setVisible(true);
				barre_menu.setVisible(true);
		panel_recherche.setVisible(false);


				
				}});
		
	recherche.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panel_ajouter.setVisible(false);
						panel_accueil.setVisible(false);
						barre_menu.setVisible(true);
			panel_recherche.setVisible(true);

		
						frame.repaint();
						
						
		
						JLabel label_recherche = new JLabel("  Recherche: ");
						label_recherche.setFont(new Font("Tahoma", Font.PLAIN, 13));
						label_recherche.setBounds(10, 30, 90, 30);
						

						JTextField recherche_e = new JTextField();
		recherche_e.setBounds(100, 30, 250, 30);
		
		recherche_e.setColumns(10);
						JButton btn_recherche = new JButton("Recherche");

		btn_recherche.setBounds(350, 30, 102, 30);
		panel_recherche.add(label_recherche);
		panel_recherche.add(recherche_e);
		panel_recherche.add(btn_recherche);
		
		btn_recherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			ResultSet result;
		
						try {
							result = con1.st.executeQuery("SELECT * FROM etudiant where nom = '"+recherche_e.getText()+"'order by nom ASC");
		
							String columns[] = { "Matricule_E", "Nom", "PRENOM", "Sexe", "Age", "Filiere","Action" };
		
							Object data[];
							DefaultTableModel table_etudiant_recherche = new DefaultTableModel(columns, 0) {
								private static final long serialVersionUID = 1L;
		
								public boolean isCellEditable(int row, int col) {
									return false;
								};
							};
		
							//int k = 1;
							while (result.next()) {
		
		

								data = new Object[] {
										// k,
										result.getString("matricule"),
										result.getString("nom"),
										result.getString("prenom"),
										result.getString("sexe"),
										result.getString("age"),
										result.getString("filiere")
										
										
										
		
								};
		
								//k++;
								table_etudiant_recherche.addRow(data);
							}
		
							JTable table_recherche_etudiant = new JTable(table_etudiant_recherche);
							table_recherche_etudiant.setShowGrid(true);
							table_recherche_etudiant.setShowVerticalLines(true);
							table_recherche_etudiant.setShowHorizontalLines(true);
							table_recherche_etudiant.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
							JScrollPane panel_recherche_etudiant = new JScrollPane(table_recherche_etudiant);
							panel_recherche_etudiant.setBounds(50, 83, 700, 550);
							panel_recherche_etudiant
									.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
							panel_recherche_etudiant
									.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
									
							frame.getContentPane().add(panel_recherche_etudiant);
		
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Erreur liée la base de données!", "Erreur",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}});
		
					}
				});

	

	}

}
