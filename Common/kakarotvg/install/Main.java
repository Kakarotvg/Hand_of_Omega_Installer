package kakarotvg.install;

import kakarotvg.install.mainwindow.Installwindow;
import kakarotvg.install.update.Update;
import kakarotvg.install.update.UpdateChecker;

public class Main {

    public static void main(String arg[]) throws Exception {

        for (int i = 0; i < 1; i++) {

            try {
                if (Double.parseDouble(Update.getLatestVersion()) > 0.2) {
                    new UpdateChecker(Update.getWhatsNew());
                }
                else {
                    Installwindow iw = new Installwindow();
                    iw.setVisible(true);
                }

            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
