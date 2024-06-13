package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JButton;

import modes.mode_controller;
import modes.mode_list;
import window.buttons.button;
public class button_group {
    Panel button_panel;
    ArrayList<button> button_list;
    public mode_controller _mode_controller;
    mode_list now_mode;
    button nowButton;
    public button_group(){
        create_button();
        button_panel = new Panel();
        button_panel.setPreferredSize(new Dimension(200,600));
        for (JButton jButton : button_list) {
            button_panel.add(jButton);
        }
        _mode_controller = mode_controller.get_mode_con();
        now_mode = mode_list.select_mode;
        nowButton = button_list.get(0);
        nowButton.setBackground(Color.white);
    }
    public Panel get_penel(){
        return button_panel;
    }
    private void create_button(){
        button_list = new ArrayList<>();
        button_list.add(new button( mode_list.select_mode,this,"window\\buttons\\image\\arrow.png"));
        button_list.add(new button( mode_list.create_mode_class,this,"window\\buttons\\image\\class.PNG"));
        button_list.add(new button( mode_list.create_mode_usecase,this,"window\\buttons\\image\\use.PNG"));
        button_list.add(new button( mode_list.line_mode_assoc,this,"window\\buttons\\image\\ass.PNG"));
        button_list.add(new button( mode_list.line_mode_comp,this,"window\\buttons\\image\\com.PNG"));
        button_list.add(new button( mode_list.line_mode_gen,this,"window\\buttons\\image\\gen.PNG"));
    }
    public void push_button(mode_list to_mode,button tobutton){
        if(now_mode!=to_mode){
            nowButton.unselect();
            nowButton = tobutton;
            now_mode = to_mode;
            _mode_controller.change_mode(to_mode);
        }
    }
}
