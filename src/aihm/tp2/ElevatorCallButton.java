/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aihm.tp2;

import java.awt.event.ActionEvent;
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
		int stagetmp = Integer.parseInt(button.getName()); 
		controller.goToStage(stagetmp,true);
		
	}
	
}
