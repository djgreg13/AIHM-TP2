/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aihm.tp2;

import aihm.elevalor.Elevator;
import aihm.elevalor.ElevatorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author greg
 */
public class ElevatorCallButton extends ElevatorButton {

	public ElevatorCallButton(int stage)
	{
		super(stage, true);
	}
	public ElevatorCallButton(int stage, boolean callButton)
	{
		super(stage, callButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		//button.setSelected(true);
		int stage = Integer.parseInt(button.getName()); 
		elevator.goToStage(stage,true);
		
	}
	
}
