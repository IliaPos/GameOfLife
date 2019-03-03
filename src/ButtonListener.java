import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    Cell cell;
    Window window;

    public ButtonListener(Cell cell) {
        super();
        this.cell = cell;
    }

   /* public ButtonListener(Window window) {
        super();
        this.window = window;
    }*/


    @Override
    public void actionPerformed(ActionEvent e) {
        Object v = e.getSource();
     //   if (v == this.window.buttonStart) {
//            window.initGeneration();
      //  } else {


            cell.turn();
      //  }
    }
}
