/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aihm.tp2;

import aihm.elevalor.Elevator;
import aihm.elevalor.ElevatorController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 *
 * @author greg
 */
public class LeftPanel extends JPanel {
    private Elevator elevator;
    private int MAXETAGE = 2;
    private int etage = 0;
    private int nextEtage = 0;
    private int i=0;
    private int offset = 0;

    LeftPanel() {
        super();
       init();
    }

    private void init() {
        this.setLayout(new BorderLayout());

        //Centrage titre
        JPanel titlep = new JPanel() {
            {
                init();
            }

            private void init() {
                this.setBackground(Color.white);
                JLabel title = new JLabel("Ascenseur");
                this.add(title);
            }
        };

        this.add(titlep, BorderLayout.NORTH);

        JPanel elevator = new Child();
        this.add(elevator, BorderLayout.CENTER);
    }
    
    	public void modelPropertyChange()
	{
            if(this.nextEtage==this.etage)
            {
                int stage = elevator.getNextStage();
                    if(stage!=etage)
                        changeEtage(stage);
            }
	}
        public void changeEtage(int stage)
        {
            this.nextEtage=stage;
            Timer timer = new Timer(10,new EventMove());
            timer.start();
            //elevator.setActualStage(stage);
        }
        
        private class EventMove implements ActionListener
        {

        @Override
        public void actionPerformed(ActionEvent e) {
            /*i++;
            if(etage<nextEtage)
            {
                offset=-i;
                System.out.println("je dois monter");
                repaint();
            } else
            {
                offset=i;
                repaint();
                System.out.println("je dois descendre");
            }
            Timer t = (Timer)e.getSource();
            if(i==100*Math.abs(nextEtage-etage))
            {
                i=0;
                offset=0;
                t.stop();
                etage=nextEtage;
                elevator.setActualStage(etage);
                elevator.propertyChange();
                repaint();
            }*/
        }
            
        }
    private class Child extends JPanel {
            protected ElevatorButton btn0, btn1, btn2; // left panel
        Child() {
            super();
            init();
        }

        private void init() {
            this.setBackground(Color.white);
            this.setLayout(null);
            this.setMinimumSize(new Dimension(300, 400));
            addButtons(this);
        }
        
        private void addButtons(JComponent p)
        {
            btn0 = new ElevatorCallButton(0,true);
            btn1 = new ElevatorCallButton(1,true);
            btn2 = new ElevatorCallButton(2,true);
            
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
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.black);
            //g.drawRect(0,0,50,50);
            
            //cage
            g.drawRect(40,10,110,300);
            //cage gauche
            g.drawLine(40,110,44,110);
            
            g.drawLine(40,210,44,210);
            
            btn2.setBounds(170,60,40,40);
            btn1.setBounds(170,160,40,40);
            btn0.setBounds(170,260,40,40);
            
            paintCabine(g);
        }
        
        private void paintCabine(Graphics g)
        {
            
            //cabine
            g.setColor(Color.cyan);;
            g.fillRect(42,12+(MAXETAGE-etage)*100+offset,106,96);
            g.setColor(Color.BLACK);
            g.drawRect(42,12+(MAXETAGE-etage)*100+offset,106,96);
            
            //porte gauche
            g.setColor(Color.yellow);;
            g.fillRect(42,12+(MAXETAGE-etage)*100+offset,106/2-1,96);
            g.setColor(Color.BLACK);
            g.drawRect(42,12+(MAXETAGE-etage)*100+offset,106/2-1,96);
            
            //porte gauche
            g.setColor(Color.yellow);;
            g.fillRect(42+(106/2+1),12+(MAXETAGE-etage)*100+offset,(106/2-1),96);
            g.setColor(Color.BLACK);
            g.drawRect(42+(106/2+1),12+(MAXETAGE-etage)*100+offset,(106/2-1),96);
            
        }
    }
    
	public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}
    
 	class SelectButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			button.setSelected(true);
			String etat = "selectionné";
		}
	}
}