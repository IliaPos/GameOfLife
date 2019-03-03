import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    public enum Actions {
        START,
        ONESTEP,
        CLICK,
        CLEAN,
        SETUP
    }

    Cell cell;


    public ButtonListener(Cell cell) {
        super();
        this.cell = cell;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == Actions.START.name()) {

        } else if (e.getActionCommand() == Actions.CLICK.name()) {
            cell.turn();
            System.out.println("Works CLICK");
        }
    }
}

