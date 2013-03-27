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
public class ElevatorCabinButton extends ElevatorButton {

	public ElevatorCabinButton(int stage)
	{
		super(stage);
	}
	public ElevatorCabinButton(int stage, boolean callButton)
	{
		super(stage, callButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		//button.setSelected(true);
		int stage = Integer.parseInt(button.getName()); 
		elevator.goToStage(stage);
		
	}
	
	public void modelPropertyChange()
	{
		this.setSelected(elevator.getStageQueue().get(this.stage));
	}
	
	public void propertyChange()
	{
		Iterator<ElevatorButton> it = buttonList.iterator(); 
		while(it.hasNext()){
			it.next().modelPropertyChange();
		}
	}
	
}
