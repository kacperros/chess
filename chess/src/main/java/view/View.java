package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.game.Board;

public class View {

    /** glowny panel w ktorym beda wyswietlane pola i figury */
    public JPanel mainPanel;
    /** ramka w ktorej beda wszystkie elementy */
    public JFrame frame;

    public View(final Board board, int[] x, boolean checked) {
        // parametry ramki
        frame = new JFrame("Szachy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 0, 800, 800);
        mainPanel = new ViewBoard(board, x, checked);
        
        frame.add(mainPanel, BorderLayout.CENTER);

        mainPanel.setVisible(true);
        frame.setVisible(true);
    }

    /**
     * funkcja tworzy nowy watek aby zmienic widok
     * 
     * @param tab - tablica na podstawie ktorej rysuje pola
     */
    public void update(final Board board) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	
            	frame.repaint();
            	/*
                frame.remove(mainPanel);
                mainPanel = new ViewBoard(board);
                frame.add(mainPanel);
                frame.validate();
                */
            }
        });
    }
    
    public void close(){
    	frame.setVisible(false);
    	frame.dispose();
    }

}
