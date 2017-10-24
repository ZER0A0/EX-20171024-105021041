import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame{
    public MainFrame(LoginFrame LF){
        loginFrame = LF;
        initComp();
    }
    private LoginFrame loginFrame;
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmF = new JMenu("File");
    private JMenu jmS = new JMenu("Set");
    private JMenu jmG = new JMenu("Game");
    private JMenu jmA = new JMenu("About");
    private JMenuItem jmiFEX = new JMenuItem("Exit");
    private JMenuItem jmiGLT = new JMenuItem("LoTo");
    private JDesktopPane jdp = new JDesktopPane();
    private int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int fw = 900 , fh = 600;

    private JInternalFrame jif = new JInternalFrame();
    private Container jifCP;
    private JPanel jpn = new JPanel(new GridLayout(1 , 6 , 5 , 5));
    private JPanel jpnB = new JPanel(new GridLayout(1 , 2 , 5 , 5));
    private JButton jbtEX = new JButton("Exit");
    private JButton jbtRE = new JButton("Replay");
    private JLabel jlb[] = new JLabel[6];
    private int data[] = new int[6];
    private Random ran = new Random(System.currentTimeMillis());

    private void initComp(){
        this.setBounds(sw / 2 - fw / 2 , sh / 2 - fh / 2 - 100 , fw , fh);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jpnB.add(jbtRE);
        jifCP = this.getContentPane();
        jif.setBounds(0 , 0 , 240 , 80);
        this.setContentPane(jdp);
        this.setJMenuBar(jmb);
        jmb.add(jmF);
        jmb.add(jmS);
        jmb.add(jmG);
        jmb.add(jmA);
        jmG.add(jmiGLT);
        jmF.add(jmiFEX);
        jmiFEX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmiGLT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jif);
                jif.setVisible(true);
            }
        });
        jmiFEX.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiGLT.setAccelerator(KeyStroke.getKeyStroke('L',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    }
}
