package aihm.elevalor;

import java.util.HashMap;
import java.util.Map;

public class Elevator {
	
	private int actualStage;
	private boolean up;
	private Map<Integer, Integer> stageQueue;
	
	public Elevator()
	{
		stageQueue = new HashMap();
		stageQueue.put(0, 0);
		stageQueue.put(1, 0);
		stageQueue.put(2, 0);
		up=false;
	}

	public int getActualStage() 
	{
		return actualStage;
	}
	
	public void setActualStage(int stage) 
	{
		stageQueue.put(stage, 0);
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
				if(stageQueue.get(stage)==1&&actualStage<stage)
					return stage;
			}
		}else{
			//Si on est entrain de descendre on regarde si des etages inférieurs
			//ont été appélés, dans ces cas on va aux étages inf.
			for (Integer stage : stageQueue.keySet()) {
				if(stageQueue.get(stage)==1&&actualStage>stage)
					return stage;
			}
		}
		
		//Si il n'y a pas d'etage appelé dans le sens de ciruculation alors on
		//va a un étage actif
		for (Integer stage : stageQueue.keySet()) {
			if(stageQueue.get(stage)==1)
				return stage;
		}
		
		//Sinon on retourne l'étage actuel (si aucun appel n'a été lancé)
		return actualStage;
	}
	
	public void goToStage(int stage)
	{
		stageQueue.put(stage, 1);
		System.out.println("J'appel l'etage "+stage);
		setActualStage(stage);
	}

}
