package aihm.tp2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
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
    protected ElevatorButton btn0, btn1, btn2; // left panel
    protected JLabel text1;
    protected JToolBar toolBar;
    
    protected List<ElevatorButton> buttons;

    public MainFrame() {
        buttons = new ArrayList<> ();
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
        LeftPanel pg = new LeftPanel();
        panel.setLeftComponent(pg);
        pg.setElevator(AIHMTP2.elevator);
        
        /*pg.setMinimumSize(new Dimension(100,400));
        panel.setLeftComponent(pg);
        pg.setLayout(new BoxLayout(pg, BoxLayout.Y_AXIS));*/
        
        //panneau droit
        JPanel pd = new RightPanel();
        panel.setRightComponent(pd);

    }

    private void addToolBarButtons(JComponent p) {
            btn0 = new ElevatorCabinButton(0);
            btn1 = new ElevatorCabinButton(1);
            btn2 = new ElevatorCabinButton(2);
            
            btn0.setElevator(AIHMTP2.elevator);
            btn1.setElevator(AIHMTP2.elevator);
            btn2.setElevator(AIHMTP2.elevator);   
            
            btn0.setElevatorController(AIHMTP2.controller);
            btn1.setElevatorController(AIHMTP2.controller);
            btn2.setElevatorController(AIHMTP2.controller);

            p.add(btn0);
            p.add(btn1);
            p.add(btn2);
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
