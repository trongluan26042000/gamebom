package com.boom.bomberman.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.boom.bomberman.gui.CodeDialog;
import com.boom.bomberman.gui.Frame;
import com.boom.bomberman.gui.InfoDialog;

public class Game extends JMenu {

	public Frame frame;
	
	public Game(Frame frame) {
		super("Game");
		this.frame = frame;
		
		/*
		 * New Game
		 */
		JMenuItem newgame = new JMenuItem("New Game");
		newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newgame.addActionListener(new MenuActionListener(frame));
		add(newgame);
		
		/*
		 * Codes
		 */
		JMenuItem codes = new JMenuItem("Level");
		codes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		codes.addActionListener(new MenuActionListener(frame));
		add(codes);
	}
	
	class MenuActionListener implements ActionListener {
		public Frame _frame;
		public MenuActionListener(Frame frame) {
			_frame = frame;
		}
		
		  @Override
		public void actionPerformed(ActionEvent e) {
			  
			  if(e.getActionCommand().equals("New Game")) {
				  _frame.newGame();
			  }
			  

			  
			  if(e.getActionCommand().equals("Level")) {
				  new CodeDialog(_frame);
			  }

		  }
		}

}
