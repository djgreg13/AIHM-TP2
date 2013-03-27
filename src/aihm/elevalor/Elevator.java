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
	private Map<Integer, Boolean> callQueue;
        private Map<Integer, Boolean> cabinQueue;

	
	public Elevator()
	{
		stageQueue = new HashMap();
		stageQueue.put(0, false);
		stageQueue.put(1, false);
		stageQueue.put(2, false);
		controllers = new ArrayList<Object>();
		up=false;
                
                callQueue = new HashMap();
		callQueue.put(0, false);
		callQueue.put(1, false);
		callQueue.put(2, false);
                
                cabinQueue = new HashMap();
		cabinQueue.put(0, false);
		cabinQueue.put(1, false);
		cabinQueue.put(2, false);
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
        
	public Map<Integer, Boolean> getCabinQueue()
	{
		return this.cabinQueue;
	}
        
	public Map<Integer, Boolean> getCallQueue()
	{
		return this.callQueue;
	}
	
	
	public int getActualStage() 
	{
		return actualStage;
	}
	
	public void setActualStage(int stage) 
	{
		stageQueue.put(stage, false);
                cabinQueue.put(stage, false);
                callQueue.put(stage, false);
                
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
	
	private void goToStage(int stage)
	{
		stageQueue.put(stage, true);
		System.out.println("J'appel l'etage "+stage);
		//setActualStage(stage);
		propertyChange();
	}
        
        public void goToStage(int stage, boolean callButton)
	{
                if(callButton)
                    callQueue.put(stage,true);
                else
                    cabinQueue.put(stage,true);
                this.goToStage(stage);
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
