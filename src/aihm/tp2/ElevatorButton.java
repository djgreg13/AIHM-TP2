package aihm.tp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import aihm.elevalor.Elevator;

public class ElevatorButton extends JButton implements ActionListener {
	
	private int stage;
	private Elevator elevator;
	private static List<ElevatorButton> buttonList = new ArrayList<ElevatorButton>();

	public ElevatorButton(int stage)
	{
		super();
		this.stage = stage;
		init(false);
	}
	public ElevatorButton(int stage, boolean callButton)
	{
		super();
		this.stage = stage;
		init(callButton);
	}
	
	public void init( boolean callButton)
	{
		String buttonImg;
		if(callButton)
		{
			buttonImg="Call";
		}else{
			
			switch (this.stage){
				case 0: buttonImg="Zero"; break;
				case 1: buttonImg="One"; break;
				case 2: buttonImg="Two"; break;
				default : buttonImg="Call";
			}
		}
		
		this.setIcon(new ImageIcon("img/"+buttonImg+".png" ));
		this.setName(""+this.stage);
		this.setSelectedIcon(new ImageIcon("img/"+buttonImg+"Selected.png" ));
		this.addActionListener(this);
		buttonList.add(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		//button.setSelected(true);
		int stage = Integer.parseInt(button.getName()); 
		elevator.goToStage(stage);
		
	}

	public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
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
