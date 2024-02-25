package tr.com.onurdemirel.test;

import tr.com.onurdemirel.dal.UrunlerDal;
import tr.com.onurdemirel.ui.LoginCom;
import tr.com.onurdemirel.ui.MainWindowUi;

import javax.swing.*;

public class Run {
    public static void main(String[] args) {

        try {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (Exception e) {

        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {


                new LoginCom();
                //new UrunlerDal().GetAll();
            }
        });
    }
}
