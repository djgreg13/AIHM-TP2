package aihm.tp2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author greg
 */
public class MainFrame extends JFrame {

    private JSplitPane panel;
    //Boutons
    protected JToggleButton btn1, btn2, btn3; // left panel
    protected JToggleButton btnt1, btnt2, btnt3; //toolbar
    protected JLabel text1;
    protected ImageIcon ico1, ico2, ico3, icos1, icos2, icos3;
    protected JToolBar toolBar;
    
    protected List<JToggleButton> buttons;

    public MainFrame() {
        buttons = new ArrayList<JToggleButton> ();
        initComponants();


        //fermeture de la fenete
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void initComponants() {
        //ajout menu
        this.setJMenuBar(new BarreMenu(this));

        //ajout toolbar
        toolBar = new JToolBar("Still draggable");

        this.getContentPane().add(toolBar, BorderLayout.PAGE_START);
        this.addToolBarButtons(toolBar);

        //ajout panneau principal
        panel = new JSplitPane();
        this.getContentPane().add(panel, BorderLayout.CENTER);

        //PanneauGauche
        JPanel pg = new LeftPanel();
        panel.setLeftComponent(pg);
        /*pg.setMinimumSize(new Dimension(100,400));
        panel.setLeftComponent(pg);
        pg.setLayout(new BoxLayout(pg, BoxLayout.Y_AXIS));*/
        
        //panneau droit
        JPanel pd = new RightPanel();
        panel.setRightComponent(pd);

    }

    private void addToolBarButtons(JComponent p) {
        btnt1 = new JToggleButton();
        btnt2 = new JToggleButton();
        btnt3 = new JToggleButton();


        //Nom

        btnt1.setName("1");
        btnt2.setName("2");
        btnt3.setName("3");


        //Icones

        ico1 = new ImageIcon("img/One.png");
        ico2 = new ImageIcon("img/Two.png");
        ico3 = new ImageIcon("img/Three.png");
        icos1 = new ImageIcon("img/OneSelected.png");
        icos2 = new ImageIcon("img/TwoSelected.png");
        icos3 = new ImageIcon("img/ThreeSelected.png");

        btnt1.setIcon(ico1);
        btnt2.setIcon(ico2);
        btnt3.setIcon(ico3);
        btnt1.setSelectedIcon(icos1);
        btnt2.setSelectedIcon(icos2);
        btnt3.setSelectedIcon(icos3);

        //Listeners


        btnt1.addActionListener(new ButtonListener());
        btnt2.addActionListener(new ButtonListener());
        btnt3.addActionListener(new ButtonListener());

        //Ajout des composants sur le conteneur
        p.add(btnt1);
        p.add(btnt2);
        p.add(btnt3);

        buttons.add(btnt1);
        buttons.add(btnt2);
        buttons.add(btnt3);

    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JToggleButton btn = (JToggleButton) e.getSource();
            StringBuffer buff = new StringBuffer();
            buff.append("Button" + btn.getName() + " : ");
            if (btn.isSelected()) {
                
                buff.append("selected");
            } else {
                buff.append("unselected");
            }
            
            Iterator<JToggleButton> it = buttons.iterator();
            while(it.hasNext())
            {
                JToggleButton btnc = it.next();
                if(btnc.getName().equals(btn.getName()))
                {
                    btnc.setSelected(btn.isSelected());
                }
            }
            
            text1.setText(buff.toString());
        }
    }

    class BarreMenu extends JMenuBar {

        private JMenu file = new JMenu("File");

        BarreMenu(JFrame frame) {
            add(file);

            //ajout des items de File
            file.add(new JMenuItem("Quit") {
                {
                    addActionListener(new QuitListener());
                }
            });
        }

        //listener de l'item Quitter ;)
        class QuitListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
    }
}
