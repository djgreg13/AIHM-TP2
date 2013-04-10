package aihm.tp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import aihm.elevalor.Elevator;
import aihm.elevalor.ElevatorController;

public abstract class ElevatorButton extends JButton implements ActionListener {
    
    	protected int stage;
	protected Elevator elevator;
        protected ElevatorController controller;
        protected static List<ElevatorButton> buttonList = new ArrayList<ElevatorButton>();
        
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
        
        public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}
        
        public void setElevatorController(ElevatorController controller)
        {
            this.controller=controller;
        }
        
        @Override
	public abstract void actionPerformed(ActionEvent e);
}
