package aihm.elevalor;

import aihm.tp2.ElevatorButton;
import aihm.tp2.ElevatorCabinButton;
import aihm.tp2.ElevatorCallButton;
import aihm.tp2.LeftPanel;
import aihm.tp2.RightPanel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class ElevatorController
{
	private Elevator elevator;
        private List<ElevatorButton> buttons = new ArrayList<ElevatorButton>();
        private List<JTextField> textfields = new ArrayList<JTextField>();
        private List<LeftPanel> animations = new ArrayList<>();

        public ElevatorController(Elevator elevator)
        {
            this.elevator = elevator;
        }
        
        public void addView(ElevatorButton button)
        {
            this.buttons.add(button);
        }
        
        public void addView(JTextField textfield)
        {
            this.textfields.add(textfield);
        }
        
        public void addView(LeftPanel panel)
        {
            this.animations.add(panel);
        }
        
        private void modelPropertyChange()
        {
            System.out.println("jai change");
            
            /* Mise à jour des boutons */
            for(ElevatorButton button : buttons)
            {
                boolean selected = false;
                if(button instanceof ElevatorCabinButton)
                {
                    selected = elevator.getCabinQueue().get(button.getStage());
                    button.setSelected(selected);
                } else if(button instanceof ElevatorCallButton)
                {
                    selected = elevator.getCallQueue().get(button.getStage());
                    button.setSelected(selected);
                }
            }
            
            /* Mise à jour des TextFields */
            for(JTextField textField : textfields)
            {
                Integer tmp = elevator.getActualStage();
                textField.setText(tmp.toString());
            }
            
            /* Mise à jour du controleur d'animation(mélangé avec la vue LeftPanel */
            for(LeftPanel panel : animations)
            {
                panel.setEtage(elevator.getActualStage());
                panel.propertyChange();
            }
            
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

    public void setStatus(Elevator.stateList nextStatus) {
        elevator.setStatus(nextStatus);
        this.modelPropertyChange();
    }
}
