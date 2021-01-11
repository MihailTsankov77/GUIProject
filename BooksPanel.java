package Library;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BooksPanel extends JPanel{
	
	public BooksPanel() {
		
		setBorder(BorderFactory.createTitledBorder("Butoni"));
		
		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.insets = new Insets(10, 10, 10, 10);
	
		gc.anchor = GridBagConstraints.CENTER;

		for(int y = 0; y <40/5 ; y+=1) {
			for(int x = 0; x < 5 ; x+=1) {
				gc.gridx = x;
				gc.gridy = y;
				
				add(this.createButton("BOOK"), gc);
			}
		}
		
		
		
		
	}
	
	private JButton createButton(String title) {
		
		JButton button = new JButton(title);
		
		button.setPreferredSize(new Dimension(100, 100));;

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.cl.show(MainFrame.mainPanel, "BookInfo");
				
			}	
				
				
		});
		return button;
	}
}
