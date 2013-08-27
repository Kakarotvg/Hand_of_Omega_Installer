package kakarotvg.install.download;

import kakarotvg.install.mainwindow.Installwindow;

public class ProgressbarThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            Installwindow.progressBar.setValue(i);
            Installwindow.progressBar.repaint();
            try {
                Thread.sleep(35);
            }
            catch (InterruptedException err) {
            }
        }

    }

}
