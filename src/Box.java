import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Box extends JButton {

    Cell cell;
    public Box(int x, int y) {
        super();

        cell = new Cell();
        setBounds(x * Config.SIZE, y * Config.SIZE, Config.SIZE, Config.SIZE);
        setBorder(BorderFactory.createLineBorder(Config.borderColor, 1));
        setBackground(Config.getColor(Status.NONE));
        addActionListener(new ButtonListener(this.cell));

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
}
