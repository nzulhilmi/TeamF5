package testing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

public class controlsPanel extends JPanel{ 
	algModel model;
	private Timer timer;
	private int Period;
	public controlsPanel (algModel model){
		super();
		this.model = model;
		this.Period = 1000;
		this.timer = new Timer(1000, new MyTimerActionListener()); 
		JSlider slider = new JSlider();
		slider.addChangeListener(e -> {
			int value = slider.getValue();
			model.setSpeed(value);
		});
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(100/4);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		JButton back = new JButton("|<<");
		back.addActionListener(e -> model.goBack());
		
		JButton play = new JButton("play");
		play.addActionListener(e -> timer.start());
		
		JButton pause = new JButton("pause");
		pause.addActionListener(e -> timer.stop());
		
		JButton forward = new JButton(">>|");
		forward.addActionListener(e -> model.goForward());
		
		add(slider);
		add(back);
		add(play);
		add(pause);
		add(forward);
	}
	class MyTimerActionListener implements ActionListener {
		  public void actionPerformed(ActionEvent e) {
			if(model.getCurrent() < model.getBound()){
				model.goForward();
			}else{
				timer.stop();
			}
		    System.out.println("1");

		  }
		}

}
