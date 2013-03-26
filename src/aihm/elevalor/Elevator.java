package aihm.elevalor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import aihm.tp2.ElevatorButton;

public class Elevator {
	
	private List<Object> controllers;
	private int actualStage;
	private boolean up;
	private Map<Integer, Boolean> stageQueue;
	

	
	public Elevator()
	{
		stageQueue = new HashMap();
		stageQueue.put(0, false);
		stageQueue.put(1, false);
		stageQueue.put(2, false);
		controllers = new ArrayList<Object>();
		up=false;
	}

	public void addController(Object controller)
	{
		this.controllers.add(controller);
	}
	
	public void removeController(Object controller)
	{
		this.controllers.remove(controller);
	}
	
	public Map<Integer, Boolean> getStageQueue()
	{
		return this.stageQueue;
	}
	
	
	public int getActualStage() 
	{
		return actualStage;
	}
	
	public void setActualStage(int stage) 
	{
		stageQueue.put(stage, false);
		up = (stage>actualStage)? true : false;
		System.out.println("Je suis a l'etage "+stage);
		actualStage=stage;
	}
	
	public int getNextStage()
	{
		if (up)
		{
			//Si on est entrain de monter on regarde si des etages supérieurs
			//ont été appélés, dans ces cas on va aux étages sup.
			for (Integer stage : stageQueue.keySet()) {
				if(stageQueue.get(stage)&&actualStage<stage)
					return stage;
			}
		}else{
			//Si on est entrain de descendre on regarde si des etages inférieurs
			//ont été appélés, dans ces cas on va aux étages inf.
			for (Integer stage : stageQueue.keySet()) {
				if(stageQueue.get(stage)&&actualStage>stage)
					return stage;
			}
		}
		
		//Si il n'y a pas d'etage appelé dans le sens de ciruculation alors on
		//va a un étage actif
		for (Integer stage : stageQueue.keySet()) {
			if(stageQueue.get(stage))
				return stage;
		}
		
		//Sinon on retourne l'étage actuel (si aucun appel n'a été lancé)
		return actualStage;
	}
	
	public void goToStage(int stage)
	{
		stageQueue.put(stage, true);
		System.out.println("J'appel l'etage "+stage);
		//setActualStage(stage);
		propertyChange();
	}
	
	public void propertyChange()
	{
		Iterator<Object> it = controllers.iterator(); 
		while(it.hasNext())
		{
			ElevatorController controller = (ElevatorController) it.next();
			controller.propertyChange();
		}
	}

}
