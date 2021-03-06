package Library;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar{

	static JButton backToMain = new JButton("Back");
	static JButton addBookButton = new JButton("Add");
	
	@SuppressWarnings("deprecation")
	public ToolBar() {
		
		backToMain.setFont(Main.font);
		addBookButton.setFont(Main.font);
		
		backToMain.hide();
		
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		
		this.setFloatable(false);
		this.add(Box.createRigidArea(new Dimension(10,0)));
		this.add(backToMain);
		this.add(Box.createHorizontalGlue());
		this.add(addBookButton);
		this.add(Box.createRigidArea(new Dimension(20,0)));
		
		backToMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				addBookButton.show();
				backToMain.hide();
				
				Main.cl.show(Main.mainPanel, "Main");
				
			}		
		});
		
		addBookButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				backToMain.show();
				addBookButton.hide();
				AddBookPanel.returnToNormal();
				
				Main.cl.show(Main.mainPanel, "AddBook");
			}		
		});
	}
	

}
