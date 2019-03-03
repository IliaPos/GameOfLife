import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class Box extends JButton {
    Status status;


    Window window;

    Cell cell;

    public Box(int x, int y) {
        super();


        cell = new Cell();
        setBounds(x * Config.SIZE, y * Config.SIZE, Config.SIZE, Config.SIZE);
        setBorder(BorderFactory.createLineBorder(Config.borderColor, 1));
        setBackground(Config.getColor(Status.NONE));

        addActionListener(e -> {
            cell.turn();
        });


    }


    public void setColor() {
        setBackground(Config.getColor(cell.status));

    }

    public void step1() {
        cell.step1();
        setColor();
    }

    public void step2() {
        cell.step2();
        setColor();

    }

    public void refresh() {
        setColor();
    }


}



