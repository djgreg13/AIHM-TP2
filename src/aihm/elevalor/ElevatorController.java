package aihm.elevalor;

import aihm.tp2.ElevatorButton;
import aihm.tp2.LeftPanel;
import java.util.ArrayList;
import java.util.List;

public class ElevatorController
{
	private Elevator elevator;
        private List<ElevatorButton> buttons = new ArrayList<ElevatorButton>();
        
        public ElevatorController(Elevator elevator)
        {
            this.elevator = elevator;
        }
        
        public void addButton(ElevatorButton button)
        {
            this.buttons.add(button);
        }
        
        private void modelPropertyChange()
        {
            System.out.println("jai change");
        }
        
        public void goToStage(int stage, boolean callButton)
        {
            elevator.goToStage(stage, callButton);
            this.modelPropertyChange();
        }
        
        public void SetActualStage(int stage)
        {
            elevator.setActualStage(stage);
            this.modelPropertyChange();
        }
}
