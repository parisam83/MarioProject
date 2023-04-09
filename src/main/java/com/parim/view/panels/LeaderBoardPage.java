package com.parim.view.panels;

import com.parim.listener.LeaderBoardListener;
import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LeaderBoardPage extends JPanel {
    private String[] columnNames = {"Rank", "Username", "Max Score"};
    private final Object[][] users = LeaderBoardListener.getAllUsers();

    public LeaderBoardPage(){
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        table.setFont(FontLoader.font.deriveFont(32f));
        table.setDragEnabled(false);
        table.setEnabled(false);

        table.setRowHeight(50);
        table.getTableHeader().setSize(new Dimension(0, 100));
        table.getTableHeader().setFont(FontLoader.buttonFont);
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setBackground(Color.darkGray);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(Object.class, centerRenderer);

        for (String col : columnNames)
            model.addColumn(col);
        for (Object[] obj : users)
            model.addRow(obj);

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Logs of previous games!", TitledBorder.CENTER, TitledBorder.TOP, FontLoader.buttonFont));
        this.setLayout(new BorderLayout());
        this.add(scrollPane);
        this.setPreferredSize(MainFrame.getScreenSize());
        this.addKeyListener(new AL());
    }

    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                MainFrame.getInstance().setMenuPage();
        }
    }
}