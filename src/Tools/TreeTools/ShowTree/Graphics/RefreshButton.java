package Tools.TreeTools.ShowTree.Graphics;

import Tools.TreeTools.ShowTree.ShowTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class RefreshButton extends JButton {
    public RefreshButton(){
        this.setText("REFRESH");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowTree.repaintTree();
            }
        });
    }
}
