package aihm.elevalor;

public class Elevator {
	
	private int actualStage;
	private boolean up;

	public int getActualStage() 
	{
		return actualStage;
	}
	
	public void goToStage(int stage)
	{
		this.actualStage=stage;
	}

}
