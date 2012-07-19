package net.debbabi.cilia;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.liglab.adele.cilia.Data;

public class GuiInputProcessor {

	public Data submit(Data data) {		
		return data;
	}

	public GuiInputProcessor() {
		frame = new JFrame("Gui Input Mediator");
		initGui();
		frame.setVisible(true);
	}
	
	private void initGui() {
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 70));
		frame.setSize(400, 70);
		frame.setLocationRelativeTo(null);

		textField = new JTextField();

		collectBtn = new JButton("Submit");
		collectBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String msg = textField.getText();
				if (msg != null & msg.trim().length() > 0) {
					Data data = new Data(textField.getText(), "guiconsole-data");
					submit(data);
					textField.setText("");
				}
			}
		});

		frame.setLayout(new BorderLayout());

		frame.add(textField, BorderLayout.CENTER);
		frame.add(collectBtn, BorderLayout.EAST);

		frame.getRootPane().setDefaultButton(collectBtn);
	}

	JFrame frame;
	JTextField textField;
	JButton collectBtn;

}
