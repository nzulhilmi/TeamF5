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
	private int period;
	
	JButton playSecret = new JButton("");
	
	public controlsPanel (algModel model){
		super();
		this.model = model;
		this.period = 1000;
		this.timer = new Timer(period, new MyTimerActionListener()); 
		JSlider slider = new JSlider();
		slider.addChangeListener(e -> {
			int value = slider.getValue();
			model.setSpeed(value);
			System.out.println("value: " + value);
			period = 200 + 30*value;
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
		
		//JButton playSecret = new JButton("");
		playSecret.addActionListener(e-> model.goForward());
		//playSecret.setVisible(false);
		//Color c = new Color(205-201-201);
		playSecret.setOpaque(false);
		playSecret.setContentAreaFilled(false);
		playSecret.setBorderPainted(false);
		
		//forward.
		add(slider);
		add(back);
		add(play);
		add(pause);
		add(forward);
		add(playSecret);
		
	}
	class MyTimerActionListener implements ActionListener {
		  public void actionPerformed(ActionEvent e) {
			if(model.getCurrent() < model.getBound()){
				timer.setDelay(period);
				playSecret.doClick();
			}else{
				timer.stop();
			}
		    //System.out.print("1");

		  }
		}

}
