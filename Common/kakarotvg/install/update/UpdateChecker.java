package kakarotvg.install.update;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UpdateChecker extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */

    final URI uri = new URI("http://www.minecraftforum.net/topic/1850853-162hand-of-omega/");
    JEditorPane infoPane;
    JScrollPane scp;
    JButton ok;
    JButton cancel;
    JPanel pan1;
    JPanel pan2;

    public UpdateChecker(String info) throws Exception {
        initComponents();
        infoPane.setText(info);
    }

    private void initComponents() throws Exception {

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("New Update Found");
        pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());

        pan2 = new JPanel();
        pan2.setLayout(new FlowLayout());

        infoPane = new JEditorPane();
        infoPane.setContentType("text/html");

        scp = new JScrollPane();
        scp.setViewportView(infoPane);

        ok = new JButton("Update");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();

                    try {
                        desktop.browse(uri);
                    }
                    catch (Exception ex) {

                    }

                }
                else {

                }
            }

        });

        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                UpdateChecker.this.dispose();
            }
        });
        pan2.add(ok);
        pan2.add(cancel);
        pan1.add(pan2, BorderLayout.SOUTH);
        pan1.add(scp, BorderLayout.CENTER);
        this.add(pan1);
        pack();
        show();
        this.setSize(300, 200);
    }
}
