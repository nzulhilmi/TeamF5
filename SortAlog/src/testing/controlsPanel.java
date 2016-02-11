package testing;

import java.time.temporal.JulianFields;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class controlsPanel extends JPanel{ 
	algModel model;
	public controlsPanel (algModel model){
		super();
		this.model = model;
		
		JSlider slider = new JSlider();
		slider.addChangeListener(e -> {
			int value = slider.getValue();
			model.setSpeed(value);
		});
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(0 - 100/4);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		JButton back = new JButton("|<<");
		back.addActionListener(e -> model.goBack());
		
		JButton play = new JButton("play");
		play.addActionListener(e -> model.play());
		
		JButton pause = new JButton("pause");
		pause.addActionListener(e -> model.pause());
		
		JButton forward = new JButton(">>|");
		forward.addActionListener(e -> model.goForward());
		
		add(slider);
		add(back);
		add(play);
		add(pause);
		add(forward);
	}

}
