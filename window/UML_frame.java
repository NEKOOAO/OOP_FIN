package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;


public class UML_frame extends JFrame{
    public window.menu.menu_bar menu_bar;
    Container container;
    public UML_frame(){
        super("UML editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800,600));
        container = getContentPane();
    }
    void createAndShowGUI(){
        container.add(canva.get_canva(),BorderLayout.CENTER);
        canva.get_canva().addMouseListener(mouse_controller.get_mouse());
        canva.get_canva().addMouseMotionListener(mouse_controller.get_mouse());
        container.add(new button_group().get_penel(),BorderLayout.WEST);
        setJMenuBar(new window.menu.menu_bar());
        setSize(1100,700);
        setResizable(false);
        setVisible(true);
    }
    public void show_window(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}