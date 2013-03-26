/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aihm.tp2;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author greg
 */
public class RightPanel extends JPanel implements ActionListener{
	
	private JTextField elevatorStage;
	
	RightPanel()
	{
		super();
		init();
	}
	public void init()
	{
		JLabel title = new JLabel("Cabine");
		this.elevatorStage = new JTextField("0");
		
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
		
		ElevatorButton button0 = new ElevatorButton(0);
		ElevatorButton button1 = new ElevatorButton(1);
		ElevatorButton button2 = new ElevatorButton(2);
		
		button0.setElevator(AIHMTP2.elevator);
		button1.setElevator(AIHMTP2.elevator);
		button2.setElevator(AIHMTP2.elevator);
		
		AIHMTP2.elevator.addController(button0);
		AIHMTP2.elevator.addController(button1);
		AIHMTP2.elevator.addController(button2);
		
		
		/*JButton button0 = new JButton(new ImageIcon("img/Zero.png" ));
	    button0.setSelectedIcon(new ImageIcon("img/ZeroSelected.png" ));
	    button0.addActionListener(new SelectButton());
	    button0.setName("0");
	    
	    JButton button1 = new JButton(new ImageIcon("img/One.png" ));
	    button1.setSelectedIcon(new ImageIcon("img/OneSelected.png" ));
	    button1.addActionListener(new SelectButton());
	    button1.setName("1");
		
		JButton button2 = new JButton(new ImageIcon("img/Two.png" ));
	    button2.setSelectedIcon(new ImageIcon("img/TwoSelected.png" ));
	    button2.addActionListener(new SelectButton());
	    button2.setName("2");
	    */
	    
	    
	    buttonsPanel.add(title, BorderLayout.NORTH);
		buttonsPanel.add(this.elevatorStage);
	    buttonsPanel.add(button2);
	    buttonsPanel.add(button1);
	    buttonsPanel.add(button0);
	    this.add(buttonsPanel, BorderLayout.CENTER);
	    
	    
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}
