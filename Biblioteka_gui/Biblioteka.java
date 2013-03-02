import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.io.BufferedOutputStream;

// Okno "About"
class AboutDialog extends JDialog {
    
	private static final long serialVersionUID = 8169178928427118906L;

	public AboutDialog() {

        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel name = new JLabel("Biblioteka, 1.00");
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setAlignmentX(0.5f);
        add(name);

        add(Box.createRigidArea(new Dimension(0, 50)));

        JButton close = new JButton("Zamknij");

        // Akcja podpieta pod przycisk "Zamknij"
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        close.setAlignmentX(0.5f);
        add(close);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("O programie");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 200);
    }
}

// Okno dodawania nowego czytelnika
class ReaderDialog extends JDialog {

	private static final long serialVersionUID = 9092551044456132035L;
	private Biblioteka bib;
	
    public ReaderDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Imie:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField fnameTextField = new JTextField(20);
        add(fnameTextField);
        
        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel lname = new JLabel("Nazwisko:");
        lname.setFont(new Font("Serif", Font.BOLD, 12));
        lname.setAlignmentX(0.5f);
        add(lname);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField lnameTextField = new JTextField(20);
        add(lnameTextField);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton addButton = new JButton("Dodaj");
        
        // Akcja podpieta pod przycisk "Dodaj"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.dodajCzytelnika(new Czytelnik(fnameTextField.getText(), lnameTextField.getText(), bib.kolejny_numer_czytelnika()));
                dispose();
            }
        });

        addButton.setAlignmentX(0.5f);
        add(addButton);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Dodaj czytelnika");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 220);
    }
}


//Okno dodawania nowej ksiazki
class KsiazkaDialog extends JDialog {

	private static final long serialVersionUID = 9092551044456132035L;
	private Biblioteka bib;
	
 public KsiazkaDialog(Biblioteka bib) {
 	this.bib = bib;	
     initUI();
 }

 public final void initUI() {

     setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel autor = new JLabel("Autor:");
     autor.setFont(new Font("Serif", Font.BOLD, 12));
     autor.setAlignmentX(0.5f);
     add(autor);

     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JTextField autorTextField = new JTextField(20);
     add(autorTextField);
     
     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel tytul = new JLabel("Tytul:");
     tytul.setFont(new Font("Serif", Font.BOLD, 12));
     tytul.setAlignmentX(0.5f);
     add(tytul);
     
     final JTextField tytulTextField = new JTextField(20);
     add(tytulTextField);
     
     add(Box.createRigidArea(new Dimension(0, 6)));
     
     JLabel isbn = new JLabel("ISBN:");
     isbn.setFont(new Font("Serif", Font.BOLD, 12));
     isbn.setAlignmentX(0.5f);
     add(isbn);
     
     final JTextField isbnTextField = new JTextField(20);
     add(isbnTextField);
     
     add(Box.createRigidArea(new Dimension(0, 6)));
          
     JLabel iloscegz = new JLabel("Ilosc egzemplarzy:");
     iloscegz.setFont(new Font("Serif", Font.BOLD, 12));
     iloscegz.setAlignmentX(0.5f);
     add(iloscegz);
     
     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JTextField iloscegzTextField = new JTextField(20);
     add(iloscegzTextField);

     add(Box.createRigidArea(new Dimension(0, 10)));

     JButton addButton = new JButton("Dodaj");
     
     // Akcja podpieta pod przycisk "Dodaj"
     addButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
        	bib.dodajKsiazke(new Ksiazka(autorTextField.getText(),tytulTextField.getText(),isbnTextField.getText(),Integer.parseInt(iloscegzTextField.getText())));
         	dispose();
         }
     });

     addButton.setAlignmentX(0.5f);
     add(addButton);
     
     add(Box.createRigidArea(new Dimension(0, 10)));
     
     JButton cancelButton = new JButton("Anuluj");
     cancelButton.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent event) {
             dispose();
         }
     });

     cancelButton.setAlignmentX(0.5f);
     add(cancelButton);


     setModalityType(ModalityType.APPLICATION_MODAL);

     setTitle("Dodaj ksiazke");
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     setLocationRelativeTo(null);
     setSize(400, 220);
 }
}




// Okno wypozyczania
class LendDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
    public LendDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Czytelnicy:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox readersComboBox = new JComboBox(bib.getCzytelnicy().toArray());
        readersComboBox.setSelectedIndex(-1);
        readersComboBox.setPreferredSize(new Dimension(450, 22));
        readersComboBox.setMaximumSize(new Dimension(450, 22));
        add(readersComboBox);
        
        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel lname = new JLabel("Ksiazki:");
        lname.setFont(new Font("Serif", Font.BOLD, 12));
        lname.setAlignmentX(0.5f);
        add(lname);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox booksComboBox = new JComboBox(bib.getKsiazki().toArray());
        booksComboBox.setSelectedIndex(-1);
        booksComboBox.setPreferredSize(new Dimension(450, 22));
        booksComboBox.setMaximumSize(new Dimension(450, 22));
        add(booksComboBox);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton lendButton = new JButton("Wypozycz");
        
        // Akcja podpieta pod przycisk "Wypozycz"
        lendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.wypozyczKsiazkeCzytelnikowi(bib.getKsiazki().get(booksComboBox.getSelectedIndex()), bib.getCzytelnicy().get(readersComboBox.getSelectedIndex()));
                dispose();
            }
        });

        lendButton.setAlignmentX(0.5f);
        add(lendButton);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Wypozycz ksiazke czytelnikowi");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}

//Okno zwrotu ksiazek
class ReturnDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
 public ReturnDialog(Biblioteka bib) {
 	this.bib = bib;	
     initUI();
 }

 public final void initUI() {

     setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel fname = new JLabel("Wypozyczenia:");
     fname.setFont(new Font("Serif", Font.BOLD, 12));
     fname.setAlignmentX(0.5f);
     add(fname);

     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JComboBox returnComboBox = new JComboBox(bib.getWypozyczenia().toArray());
     returnComboBox.setSelectedIndex(-1);
     returnComboBox.setPreferredSize(new Dimension(450, 22));
     returnComboBox.setMaximumSize(new Dimension(450, 22));
     add(returnComboBox);
     
     add(Box.createRigidArea(new Dimension(0, 6)));

     JButton lendButton = new JButton("Zwrot");
     
     // Akcja podpieta pod przycisk "Zwrot"
     lendButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
         	bib.usunWypozyczenie(bib.getWypozyczenia().get(returnComboBox.getSelectedIndex()));
             dispose();
         }
     });

     lendButton.setAlignmentX(0.5f);
     add(lendButton);
     
     add(Box.createRigidArea(new Dimension(0, 10)));
     
     JButton cancelButton = new JButton("Anuluj");
     cancelButton.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent event) {
             dispose();
         }
     });

     cancelButton.setAlignmentX(0.5f);
     add(cancelButton);


     setModalityType(ModalityType.APPLICATION_MODAL);

     setTitle("Zwrot ksiazki czytelnika");
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     setLocationRelativeTo(null);
     setSize(500, 220);
 }
}

//Okno usuwania ksiazki
class DeletBookDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
 public DeletBookDialog(Biblioteka bib) {
 	this.bib = bib;	
     initUI();
 }

 public final void initUI() {

     setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel fname = new JLabel("Ksiazki:");
     fname.setFont(new Font("Serif", Font.BOLD, 12));
     fname.setAlignmentX(0.5f);
     add(fname);

     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JComboBox booksComboBox = new JComboBox(bib.getKsiazki().toArray());
     booksComboBox.setSelectedIndex(-1);
     booksComboBox.setPreferredSize(new Dimension(450, 22));
     booksComboBox.setMaximumSize(new Dimension(450, 22));
     add(booksComboBox);
     
     add(Box.createRigidArea(new Dimension(0, 6)));

     JButton DeleteBookButton = new JButton("Usun ksiazke");
     
     // Akcja podpieta pod przycisk "Usun ksiazke"
     DeleteBookButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
         	bib.usunKsiazke(bib.getKsiazki().get(booksComboBox.getSelectedIndex()));
             dispose();
         }
     });

     DeleteBookButton.setAlignmentX(0.5f);
     add(DeleteBookButton);
     
     add(Box.createRigidArea(new Dimension(0, 10)));
     
     JButton cancelButton = new JButton("Anuluj");
     cancelButton.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent event) {
             dispose();
         }
     });

     cancelButton.setAlignmentX(0.5f);
     add(cancelButton);


     setModalityType(ModalityType.APPLICATION_MODAL);

     setTitle("Usun ksiazke");
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     setLocationRelativeTo(null);
     setSize(500, 220);
 }
}

//Okno usuwania czytelnika
class DeletReaderDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
public DeletReaderDialog(Biblioteka bib) {
	this.bib = bib;	
   initUI();
}

public final void initUI() {

   setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

   add(Box.createRigidArea(new Dimension(0, 6)));

   JLabel fname = new JLabel("Czytelnicy:");
   fname.setFont(new Font("Serif", Font.BOLD, 12));
   fname.setAlignmentX(0.5f);
   add(fname);

   add(Box.createRigidArea(new Dimension(0, 6)));
   
   final JComboBox booksComboBox = new JComboBox(bib.getCzytelnicy().toArray());
   booksComboBox.setSelectedIndex(-1);
   booksComboBox.setPreferredSize(new Dimension(450, 22));
   booksComboBox.setMaximumSize(new Dimension(450, 22));
   add(booksComboBox);
   
   add(Box.createRigidArea(new Dimension(0, 6)));

   JButton DeleteBookButton = new JButton("Usun czytelnika");
   
   // Akcja podpieta pod przycisk "Usun czytelnika"
   DeleteBookButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent event) {
       	bib.usunCzytelnika(bib.getCzytelnicy().get(booksComboBox.getSelectedIndex()));
           dispose();
       }
   });

   DeleteBookButton.setAlignmentX(0.5f);
   add(DeleteBookButton);
   
   add(Box.createRigidArea(new Dimension(0, 10)));
   
   JButton cancelButton = new JButton("Anuluj");
   cancelButton.addActionListener(new ActionListener() {

       public void actionPerformed(ActionEvent event) {
           dispose();
       }
   });

   cancelButton.setAlignmentX(0.5f);
   add(cancelButton);


   setModalityType(ModalityType.APPLICATION_MODAL);

   setTitle("Usun czytelnika");
   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   setLocationRelativeTo(null);
   setSize(500, 220);
}
}

//Okno wyswietlania informacji o koncie czytelnika
class ReaderBookDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	     		
public ReaderBookDialog(Biblioteka bib) {
	this.bib = bib;	
 initUI();
}

public final void initUI() {
 
 setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

 add(Box.createRigidArea(new Dimension(0, 6)));

 JLabel fname = new JLabel("Czytelnicy:");
 fname.setFont(new Font("Serif", Font.BOLD, 12));
 fname.setAlignmentX(0.5f);
 add(fname);

 add(Box.createRigidArea(new Dimension(0, 6)));
 
 final JComboBox booksComboBox = new JComboBox(bib.getCzytelnicy().toArray());
 booksComboBox.setSelectedIndex(-1);
 booksComboBox.setPreferredSize(new Dimension(450, 22));
 booksComboBox.setMaximumSize(new Dimension(450, 22));
 add(booksComboBox);
 
 add(Box.createRigidArea(new Dimension(0, 6)));

 JButton Readerstatus = new JButton("Informacja o wypozyczeniach");
 
  // Akcja podpieta pod przycisk "Informacja o wypozyczeniach"
 
 Readerstatus.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent event) {
        // Panel
     	JPanel panel = new JPanel();
        // Pole tekstowe
     	final JTextArea textArea = new JTextArea("");
        textArea.setPreferredSize(new Dimension(550, 100));
        textArea.setEditable(false);  
        // Dodanie pola tekstowego do panelu
        panel.add(textArea);     
        // Dodanie panelu do JFrame
        add(panel);
        pack();
        Czytelnik c = bib.getCzytelnicy().get(booksComboBox.getSelectedIndex());
        textArea.append(c.toString()+"\n");
    	for (Wypozyczenie k: bib.wypozyczenia) {  
    	if (k.getCzytelnik() == bib.getCzytelnicy().get(booksComboBox.getSelectedIndex()))
    	textArea.append(k.toString()+"\n");
    	}
    	}
 });
 
 Readerstatus.setAlignmentX(0.5f);
 add(Readerstatus);
 
 add(Box.createRigidArea(new Dimension(0, 10)));
 
 JButton cancelButton = new JButton("Zamknij");
 cancelButton.addActionListener(new ActionListener() {

     public void actionPerformed(ActionEvent event) {
        dispose();
     }
 });

 cancelButton.setAlignmentX(0.5f);
 add(cancelButton);


 setModalityType(ModalityType.APPLICATION_MODAL);

 setTitle("Wyswietlania informacji o koncie czytelnika");
 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 setLocationRelativeTo(null);
 setSize(500, 220);
}
}

//Okno wyswietlania informacji ksiazce
class BookStatusDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	     		
public BookStatusDialog(Biblioteka bib) {
	this.bib = bib;	
initUI();
}

public final void initUI() {

setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

add(Box.createRigidArea(new Dimension(0, 6)));

JLabel fname = new JLabel("Ksiazki:");
fname.setFont(new Font("Serif", Font.BOLD, 12));
fname.setAlignmentX(0.5f);
add(fname);

add(Box.createRigidArea(new Dimension(0, 6)));

final JComboBox booksComboBox = new JComboBox(bib.getKsiazki().toArray());
booksComboBox.setSelectedIndex(-1);
booksComboBox.setPreferredSize(new Dimension(450, 22));
booksComboBox.setMaximumSize(new Dimension(450, 22));
add(booksComboBox);

add(Box.createRigidArea(new Dimension(0, 6)));

JButton Bookstatus = new JButton("Wypozyczenia ksiazki");

// Akcja podpieta pod przycisk "Wypozyczenia ksiazki"

Bookstatus.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
      // Panel
   	JPanel panel = new JPanel();
      // Pole tekstowe
   	final JTextArea textArea = new JTextArea("");
      textArea.setPreferredSize(new Dimension(550, 100));
      textArea.setEditable(false);  
      // Dodanie pola tekstowego do panelu
      panel.add(textArea);     
      // Dodanie panelu do JFrame
      add(panel);
      pack();
      Ksiazka k = bib.getKsiazki().get(booksComboBox.getSelectedIndex());
      textArea.append(k.toString()+"\n");
  	for (Wypozyczenie w: bib.wypozyczenia) {  
  	if (w.getKsiazka() == bib.getKsiazki().get(booksComboBox.getSelectedIndex()))
  	textArea.append(w.toString()+"\n");
  	}
  	}
});

Bookstatus.setAlignmentX(0.5f);
add(Bookstatus);

add(Box.createRigidArea(new Dimension(0, 10)));

JButton cancelButton = new JButton("Zamknij");
cancelButton.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent event) {
      dispose();
   }
});

cancelButton.setAlignmentX(0.5f);
add(cancelButton);


setModalityType(ModalityType.APPLICATION_MODAL);

setTitle("Wyswietlania informacji wypozyczeniach ksiazki");
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setLocationRelativeTo(null);
setSize(500, 220);
}
}


// Klasa Biblioteka
public class Biblioteka extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3167090132551198602L;
	// Listy ksiazek, czytelnikow i wypozyczen
	ArrayList<Ksiazka> ksiazki;
	ArrayList<Czytelnik> czytelnicy;
	ArrayList<Wypozyczenie> wypozyczenia;
	long numer_czytelnika;
	
	/**
	 * Konstruktor
	 */
	public Biblioteka() {
		this.ksiazki = new ArrayList<Ksiazka>();
		this.czytelnicy = new ArrayList<Czytelnik>();
		this.wypozyczenia = new ArrayList<Wypozyczenie>();
		this.numer_czytelnika = 1;
		initUI(this);
	}
	// Metoda inicjalizująca GUI
	public final void initUI(final Biblioteka bib) {
		
		// Panel
		JPanel panel = new JPanel();

		// Pole tekstowe
		final JTextArea textArea = new JTextArea("");
        textArea.setPreferredSize(new Dimension(550, 600));
        textArea.setEditable(false);
        
        // Dodanie pola tekstowego do panelu
        panel.add(textArea);
        
        // Dodanie panelu do JFrame
        add(panel);
        pack();
        // Pasek menu
        JMenuBar menubar = new JMenuBar();
        // Menu Biblioteka
        JMenu lib = new JMenu("Biblioteka");
        lib.setMnemonic(KeyEvent.VK_B);
        // Pozycja menu: Zakoncz
        JMenuItem eMenuItem = new JMenuItem("Zakoncz");
        eMenuItem.setMnemonic(KeyEvent.VK_Z);
        eMenuItem.setToolTipText("Zakoncz program");
        // Podpiecie akcji pod "Zakoncz"
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	System.exit(0);
            	          	
            }
        });

        // Pozycja menu: Wyswietl czytelnikow
        JMenuItem usersMenuItem = new JMenuItem("Wyswietl czytelnikow");
        usersMenuItem.setMnemonic(KeyEvent.VK_C);
        usersMenuItem.setToolTipText("Wyswietlenie listy czytelnikow");
        // Podpiecie akcji pod "Wyswietl czytelnikow"
        usersMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Czytelnik c: czytelnicy) {  
            		textArea.append(c+"\n");
            	}		
            }		  
        });
        
        // Pozycja menu: Wyswietl ksiazki
        JMenuItem booksMenuItem = new JMenuItem("Wyswietl ksiazki");
        booksMenuItem.setMnemonic(KeyEvent.VK_K);
        booksMenuItem.setToolTipText("Wyswietlenie listy ksiazek");
        // Podpiecie akcji pod "Wyswietl ksiazki"
        booksMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Ksiazka k: ksiazki) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });

        // Pozycja menu: Wyswietl wypozyczenia
        JMenuItem lendsMenuItem = new JMenuItem("Wyswietl wypozyczenia");
        lendsMenuItem.setMnemonic(KeyEvent.VK_Y);
        lendsMenuItem.setToolTipText("Wyswietlenie listy ksiazek");
        // Podpiecie akcji pod "Wyswietl wypozyczenia"
        lendsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Wypozyczenie k: wypozyczenia) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });
        
        // Pozycja menu: Dodaj nowego czytelnika
        JMenuItem newReaderMenuItem = new JMenuItem("Dodaj nowego czytelnika");
        newReaderMenuItem.setMnemonic(KeyEvent.VK_N);
        // Podpiecie akcji pod "Dodaj nowego czytelnika"
        newReaderMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ReaderDialog ad = new ReaderDialog(bib);
                ad.setVisible(true);
            }
        });
        
     // Pozycja menu: Dodawanie nowej ksiazki
        JMenuItem newBookMenuItem = new JMenuItem("Dodaj nowa ksiazke");
        newBookMenuItem.setMnemonic(KeyEvent.VK_D);
        newBookMenuItem.setToolTipText("Dodowanie nowej ksiazki do listy");
        // Podpiecie akcji pod "Dodaj nowa ksiazke"
        newBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	KsiazkaDialog ad = new KsiazkaDialog(bib);
                ad.setVisible(true);
            }
        });
        
        // Pozycja menu: Wypozycz ksiazke czytelnikowi
        JMenuItem lendBookMenuItem = new JMenuItem("Wypozycz ksiazke czytelnikowi");
        lendBookMenuItem.setMnemonic(KeyEvent.VK_W);
        // Podpiecie akcji pod "Wypozycz ksiazke czytelnikowi"
        lendBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LendDialog ad = new LendDialog(bib);
                ad.setVisible(true);
            }
        });

        // Pozycja menu: Zwroc ksiazke czytelnika
        JMenuItem ReturnBookMenuItem = new JMenuItem("Zwroc ksiazke czytelnikowi");
        ReturnBookMenuItem.setMnemonic(KeyEvent.VK_Z);
        // Podpiecie akcji pod "Zwroc ksiazke czytelnikowi"
        ReturnBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ReturnDialog ad = new ReturnDialog(bib);
                ad.setVisible(true);
            }
        });
        
     // Pozycja menu: Usuwanie wybranej ksiazki
        JMenuItem DeleteBookMenuItem = new JMenuItem("Usun ksiazke");
        DeleteBookMenuItem.setMnemonic(KeyEvent.VK_U);
        // Podpiecie akcji pod "Usuwanie wybranej ksiazki"
        DeleteBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	DeletBookDialog ad = new DeletBookDialog(bib);
                ad.setVisible(true);
            }
        });
        
        // Pozycja menu: Usuwanie czytelnika
        JMenuItem DeleteReaderMenuItem = new JMenuItem("Usun czytelnika");
        DeleteReaderMenuItem.setMnemonic(KeyEvent.VK_C);
        // Podpiecie akcji pod "Usuwanie czytelnika"
        DeleteReaderMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	DeletReaderDialog ad = new DeletReaderDialog(bib);
                ad.setVisible(true);
            }
        });
        
        // Pozycja menu: Wyswietlanie informacji o koncie czytelnika
        JMenuItem ReaderStatusMenuItem = new JMenuItem("Informacja o koncie czytelnika");
        ReaderStatusMenuItem.setMnemonic(KeyEvent.VK_S);
        // Podpiecie akcji pod "Wyswietlanie informacji o koncie czytelnika"
        ReaderStatusMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	ReaderBookDialog ad = new ReaderBookDialog(bib);
                ad.setVisible(true);
               }
        });
        
     // Pozycja menu: Wyswietlanie informacji wypozyczeniach ksiazki
        JMenuItem BookStatusMenuItem = new JMenuItem("Informacja o ksiazce");
        BookStatusMenuItem.setMnemonic(KeyEvent.VK_B);
        // Podpiecie akcji pod "Informacja o ksiazce"
        BookStatusMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	BookStatusDialog ad = new BookStatusDialog(bib);
                ad.setVisible(true);
        }
        });
        
        // Pozycja menu: Zapisywanie do pliku
        JMenuItem SaveMenuItem = new JMenuItem("Zapisywanie do pliku");
        SaveMenuItem.setMnemonic(KeyEvent.VK_S);
        // Podpiecie akcji pod "Zapisywanie do pliku"
        SaveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try {
                	bib.zapisksiazka();
                	bib.zapisczytelnik();
                	bib.zapiswypozyczenie();
            		}  catch (IOException e) {
                	}
        }
        });
        // Pozycja menu: Odczytywanie z pliku
        JMenuItem ReadMenuItem = new JMenuItem("Odczytywanie z pliku");
        ReadMenuItem.setMnemonic(KeyEvent.VK_O);
        // Podpiecie akcji pod "Odczytywanie z pliku"
        ReadMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try {
            	try {
                	bib.odczytksiazki();
                	bib.odczytczytelnicy();
                	bib.odczytwypozyczenia();
                   	}  catch (IOException e) {
                	}
            		}  catch (ClassNotFoundException c){
            		}
        }
        });
                   
        // Dodanie pozycji do menu "Biblioteka"
        lib.add(lendBookMenuItem);
        lib.add(ReturnBookMenuItem);
        lib.add(ReaderStatusMenuItem);        
        lib.addSeparator();
        lib.add(newReaderMenuItem);
        lib.add(newBookMenuItem);
        lib.add(BookStatusMenuItem); 
        lib.addSeparator();
        lib.add(DeleteBookMenuItem);
        lib.add(DeleteReaderMenuItem);
        lib.addSeparator();
        lib.add(usersMenuItem);        
        lib.add(booksMenuItem);
        lib.add(lendsMenuItem);
        lib.addSeparator();
        lib.add(SaveMenuItem);
        lib.add(ReadMenuItem);
        lib.add(eMenuItem);

        // Menu "Pomoc"
        JMenu help = new JMenu("Pomoc");
        help.setMnemonic(KeyEvent.VK_P);
        
        // Pozycja menu: O programie
        JMenuItem about = new JMenuItem("O programie");
        about.setMnemonic(KeyEvent.VK_O);
        
        // Podpiecie akcji pod "O programie"
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AboutDialog ad = new AboutDialog();
                ad.setVisible(true);
            }
        });

        // Dodanie pozycji "O programie" do menu "Pomoc"
        help.add(about);
        
        // Dodanie menu "Biblioteka" i "Pomoc" do paska menu
        menubar.add(lib);
        menubar.add(help);

        setJMenuBar(menubar);
        
        setTitle("Biblioteka");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	// Metody zapisywania do plikow ser
	
	public void zapisksiazka () throws IOException {
				
		FileOutputStream fos = new FileOutputStream("ksiazki.ser");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(ksiazki);
		oos.close();
	}
	public void zapisczytelnik () throws IOException {
		
		FileOutputStream fos = new FileOutputStream("czytelnicy.ser");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(czytelnicy);
		oos.close();
	}
	public void zapiswypozyczenie () throws IOException {
		
		FileOutputStream fos = new FileOutputStream("wypozyczenia.ser");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(wypozyczenia);
		oos.close();
	}
	
	//metody odczytywania plikow

	public void odczytksiazki() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("ksiazki.ser");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		while(bis.available() > 0) {
			ksiazki = (ArrayList<Ksiazka>) ois.readObject();
			}
		
		ois.close();
	}
	public void odczytczytelnicy() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("czytelnicy.ser");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		while(bis.available() > 0) {
			czytelnicy = (ArrayList<Czytelnik>) ois.readObject();
		}
		
		ois.close();
	}
	public void odczytwypozyczenia() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("wypozyczenia.ser");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		while(bis.available() > 0) {
				wypozyczenia = (ArrayList<Wypozyczenie>) ois.readObject();
		}
		
		ois.close();
	}
	// Metody get i set
	
	/**
	 * @return the ksiazki
	 */
	public ArrayList<Ksiazka> getKsiazki() {
		return ksiazki;
	}


	/**
	 * @param ksiazki the ksiazki to set
	 */
	public void setKsiazki(ArrayList<Ksiazka> ksiazki) {
		this.ksiazki = ksiazki;
	}

	/**
	 * @return the czytelnicy
	 */
	public ArrayList<Czytelnik> getCzytelnicy() {
		return czytelnicy;
	}

	/**
	 * @param czytelnicy the czytelnicy to set
	 */
	public void setCzytelnicy(ArrayList<Czytelnik> czytelnicy) {
		this.czytelnicy = czytelnicy;
	}

	/**
	 * @return the wypozyczenia
	 */
	public ArrayList<Wypozyczenie> getWypozyczenia() {
		return wypozyczenia;
	}

	/**
	 * @param wypozyczenia the wypozyczenia to set
	 */
	public void setWypozyczenia(ArrayList<Wypozyczenie> wypozyczenia) {
		this.wypozyczenia = wypozyczenia;
	}

	public long getNumer_czytelnika() {
		return numer_czytelnika;
	}

	public void setNumer_czytelnika(long numer_czytelnika) {
		this.numer_czytelnika = numer_czytelnika;
	}
	
	public long kolejny_numer_czytelnika() {
		return numer_czytelnika++;
	}
	
	public void dodajKsiazke(Ksiazka k) {
		ksiazki.add(k);
	}

	public void dodajCzytelnika(Czytelnik c) {
		czytelnicy.add(c);
	}

	public void dodajWypozyczenie(Wypozyczenie w) {
		wypozyczenia.add(w);
	}

	public void usunKsiazke(Ksiazka k) {
		ksiazki.remove(k);
	}

	public void usunCzytelnika(Czytelnik c) {
		czytelnicy.remove(c);
	}

	public void usunWypozyczenie(Wypozyczenie w) {
		wypozyczenia.remove(w);
	}
	
	public boolean wypozyczKsiazkeCzytelnikowi(Ksiazka k, Czytelnik c) {
		if (k.wypozycz()) {
			dodajWypozyczenie(new Wypozyczenie(k, c));
			return true;
		}
		else 
			return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Biblioteka bib = new Biblioteka();
                bib.dodajCzytelnika(new Czytelnik("Jan", "Kowalski", bib.kolejny_numer_czytelnika()));
                bib.dodajCzytelnika(new Czytelnik("Dariusz", "Malinowski", bib.kolejny_numer_czytelnika()));
                bib.dodajCzytelnika(new Czytelnik("Wojciech", "Kaminski", bib.kolejny_numer_czytelnika()));
                bib.dodajKsiazke(new Ksiazka("D. Thomas", "Programming Ruby 1.9", "978-1-934356-08-1", 5));
                bib.dodajKsiazke(new Ksiazka("J. Loeliger", "Version Control with Git", "978-0-596-52012-0", 2));
                bib.dodajKsiazke(new Ksiazka("J.E.F. Friedl", "Matering Regular Expressions", "978-0-596-52812-6", 1));
                bib.setVisible(true);
            }
        });
	}
	
}
