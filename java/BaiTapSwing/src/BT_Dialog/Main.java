package BT_Dialog;

import javax.swing.*;

public class Main {
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    
    MyFrame f = new MyFrame();
    f.setVisible(true);
  }
}
