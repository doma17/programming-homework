import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SinCosTanGraph {

    public static void main(String[] args) {
        new SwingDraw().setVisible(true);
    }
}

class SwingDraw extends JFrame implements ActionListener { // JFrame을 종속
 private static final long serialVersionUID = 1L;
 private JButton btn;

    public SwingDraw() {
        this.setLayout(new FlowLayout());

        btn = new JButton("실행");
        btn.addActionListener(this);
        this.add(btn);

        this.setSize(1400, 700);  //크기는 마음대로
        this.setDefaultCloseOperation(<wbr />JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        Graphics g = this.getGraphics();

        // 원점 이동
        g.translate(this.getWidth() / 2, this.getHeight() / 2);

        // x축 그리기
        g.drawLine(-this.getWidth() / 2, 0, this.getWidth() / 2, 0);
        // y축 그리기
        g.drawLine(0, -this.getHeight() / 2, 0, this.getHeight() / 2);

        // Sin 그리기
        g.setColor(Color.RED);
        g.drawString("--- Sin", 20, 30);
        for (int i = -540; i <= 540; i++) {
            g.drawOval(i, (int)(80 * -Math.sin(Math.toRadians(i))), 1, 1);
        }

        // Cos 그리기
        g.setColor(Color.BLUE);
        g.drawString("--- Cos", 20, 50);
        for (int i = -540; i <= 540; i++) {
            g.drawOval(i, (int)(80 * -Math.cos(Math.toRadians(i))), 1, 1);
        }


        // Tan 그리기
        g.setColor(Color.MAGENTA);
        g.drawString("--- Tan", 20, 90);
        for (int j = -2; j <= 2; j++) {
            for (int i = -90 + j * 180 + 1; i <= 90 + j * 180 - 1; i++) {
                g.drawOval(i, (int)(80 * -Math.tan(Math.toRadians(i))), 1, 1);
            }
        }
    }
}