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
    protected ElevatorButton btn0, btn1, btn2; // left panel
    protected JLabel text1;
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
        LeftPanel pg = new LeftPanel();
        panel.setLeftComponent(pg);
        pg.setElevator(AIHMTP2.elevator);
        AIHMTP2.elevator.addController(pg);
        
        /*pg.setMinimumSize(new Dimension(100,400));
        panel.setLeftComponent(pg);
        pg.setLayout(new BoxLayout(pg, BoxLayout.Y_AXIS));*/
        
        //panneau droit
        JPanel pd = new RightPanel();
        panel.setRightComponent(pd);

    }

    private void addToolBarButtons(JComponent p) {
            btn0 = new ElevatorButton(0);
            btn1 = new ElevatorButton(1);
            btn2 = new ElevatorButton(2);
            
            btn0.setElevator(AIHMTP2.elevator);
            btn1.setElevator(AIHMTP2.elevator);
            btn2.setElevator(AIHMTP2.elevator);   
            
            AIHMTP2.elevator.addController(btn0);
            AIHMTP2.elevator.addController(btn1);
            AIHMTP2.elevator.addController(btn2);

            p.add(btn0);
            p.add(btn1);
            p.add(btn2);
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
