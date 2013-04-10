/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aihm.tp2;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import aihm.elevalor.ElevatorController;

/**
 *
 * @author greg
 */
public class RightPanel extends JPanel implements ActionListener{
	
	private JTextField elevatorStage;
	
	RightPanel()
	{
		super();
		init();
	}
	public void init()
	{
		JLabel title = new JLabel("Cabine");
		this.elevatorStage = new JTextField("0");
		
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
		
		ElevatorButton button0 = new ElevatorCabinButton(0);
		ElevatorButton button1 = new ElevatorCabinButton(1);
		ElevatorButton button2 = new ElevatorCabinButton(2);
		
		button0.setElevator(AIHMTP2.elevator);
		button1.setElevator(AIHMTP2.elevator);
		button2.setElevator(AIHMTP2.elevator);
		
            button0.setElevatorController(AIHMTP2.controller);
            button1.setElevatorController(AIHMTP2.controller);
            button2.setElevatorController(AIHMTP2.controller);
	    
	    buttonsPanel.add(title, BorderLayout.NORTH);
		buttonsPanel.add(this.elevatorStage);
	    buttonsPanel.add(button2);
	    buttonsPanel.add(button1);
	    buttonsPanel.add(button0);
	    this.add(buttonsPanel, BorderLayout.CENTER);
	    
	    //AIHMTP2.elevator.addController(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
        }
    
}
