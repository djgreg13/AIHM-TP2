package aihm.elevalor;

import java.util.HashMap;
import java.util.Map;


public class Elevator {
	private int actualStage;
	private boolean up;
	private Map<Integer, Boolean> stageQueue;
	private Map<Integer, Boolean> callQueue;
        private Map<Integer, Boolean> cabinQueue;
        
        public static enum stateList {
            READY, MOVE, DOOR_OPEN, DOOR_CLOSE, OPEN
        }
        private stateList status;

	
	public Elevator()
	{
		stageQueue = new HashMap();
		stageQueue.put(0, false);
		stageQueue.put(1, false);
		stageQueue.put(2, false);
		up=false;
                
                callQueue = new HashMap();
		callQueue.put(0, false);
		callQueue.put(1, false);
		callQueue.put(2, false);
                
                cabinQueue = new HashMap();
		cabinQueue.put(0, false);
		cabinQueue.put(1, false);
		cabinQueue.put(2, false);
                
                status = stateList.READY;
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

        public stateList getStatus() {
            return status;
        }

        public void setStatus(stateList status) {
            this.status = status;
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
                
		//up = (stage>actualStage)? true : false;
		System.out.println("Je suis a l'etage "+stage);
		actualStage=stage;
	}

        public void setUp(boolean up) {
            this.up = up;
        }
        
	
	public int getNextStage()
	{
		if (up)
		{
			//Si on est entrain de monter on regarde si des etages supérieurs
			//ont été appélés, dans ces cas on va aux étages sup.
                    System.out.println("up");
			for (Integer stage : stageQueue.keySet()) {
				if(stageQueue.get(stage)&&actualStage<stage)
					return stage;
			}
		}else{
                    System.out.println("down");
			//Si on est entrain de descendre on regarde si des etages inférieurs
			//ont été appélés, dans ces cas on va aux étages inf.
			for (int i = stageQueue.size()-1 ; i>0 ; i--) {
				if(stageQueue.get(i)&&actualStage>i)
					return i;
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
	}
        
        public void goToStage(int stage, boolean callButton)
	{
            if(this.getActualStage()!=stage || status != stateList.READY)
            {
                if(callButton)
                    callQueue.put(stage,true);
                else
                    cabinQueue.put(stage,true);
            }
            this.goToStage(stage);
	}

}
