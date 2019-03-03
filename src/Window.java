import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {
    TimerListener tl = new TimerListener();
    TimerListen t2 = new TimerListen();
    Window window;
    JButton buttonStart;
    JMenuBar menuBar;
    JFrame frame;
    Box[][] boxes;
    Box box;

    @Override
    public void run() {
        initMenu();
        initframe();
        initBoxes();
        refreshD();
        // initGeneration();
    //     initTimer();
    }


    private void initMenu() {
        menuBar = new JMenuBar();
        menuBar.setVisible(true);

        buttonStart = new JButton("Start/stop");
    //    buttonStart.setActionCommand(ButtonListener.Actions.START.name());
        menuBar.add(buttonStart);
    //    buttonStart.addActionListener(new ButtonListener());
        buttonStart.addActionListener(e -> {

            initTimer();
            System.out.println("Works Start");

        });



        JButton buttonOneStep = new JButton("One step");
        menuBar.add(buttonOneStep);
        buttonOneStep.addActionListener(e -> {
            oneStep();
        });

        JButton buttonSetup = new JButton("Setup");
        menuBar.add(buttonSetup);

        JButton buttonClean = new JButton("clean");
        menuBar.add(buttonClean);

    }




    void initframe() {
        frame = new JFrame();
        frame.setJMenuBar(menuBar);
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.SIZE * Config.WIDTH, Config.SIZE * Config.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Life of Game");
       // frame.pack();
    }


    void initBoxes() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                for (int sx = -1; sx <= +1; sx++) {
                    for (int sy = -1; sy <= +1; sy++) {
                        if (!(sx == 0 && sy == 0)) {
                            boxes[x][y].cell.addNear(boxes
                                    [(x + sx + Config.WIDTH) % Config.WIDTH]
                                    [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell);
                        }
                    }
                }
            }

        }
        for (int x = 10; x < 15; x++) {
            boxes[x][10].cell.status = Status.LIVE;
            boxes[x][10].setColor();
        }
    }
 /*   public void initGeneration() {
        boolean flop = false;
        while(true){
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int y = 0; y < Config.HEIGHT; y++) {
                    if (flop)
                        boxes[x][y].step1();
                    else
                        boxes[x][y].step2();

                }

            }
        }
    }*/

    public void initTimer() {

        Timer generaion = new Timer(Config.SLEEPMS, tl);

        generaion.start();

    }

    public void oneStep() {
        boolean flop = false;
        flop = !flop;
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                if (flop)
                    boxes[x][y].step1();
                else
                    boxes[x][y].step2();

            }

        }
    }


    public void refreshD() {
        Timer refresh = new Timer(25, t2);
        refresh.start();
    }

    public class TimerListen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int y = 0; y < Config.HEIGHT; y++) {
                    boxes[x][y].refresh();

                }

            }

        }
    }



    private class TimerListener implements ActionListener {

        boolean flop = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int y = 0; y < Config.HEIGHT; y++) {
                    if (flop)
                        boxes[x][y].step1();
                    else
                        boxes[x][y].step2();

                }

            }

        }

    }


}
