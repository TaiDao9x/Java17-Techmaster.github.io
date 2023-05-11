package view;

import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.JFrame;

public class DecorateBut extends AbstractButton {
	AbstractButton btn;
	
	public DecorateBut(AbstractButton c){
		
		btn=c;
		setLayout(new BorderLayout());
		add("Center",c);
		
	}

	public AbstractButton getBtn() {
		return btn;
	}
	
	
	

}
