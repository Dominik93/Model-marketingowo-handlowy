/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.view;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dominik
 */
public class PositionAbstractTableModel extends AbstractTableModel {

  Object rowData[][];
  String columnNames[];

    public void setRowData(Object[][] rowData) {
        this.rowData = rowData;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
  
  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  @Override
  public int getRowCount() {
    return rowData.length;
  }

  @Override
  public Object getValueAt(int row, int column) {
    return rowData[row][column];
  }
  
  @Override
  public Class getColumnClass(int column) {
    return (getValueAt(0, column).getClass());
  }
  
  @Override
  public void setValueAt(Object value, int row, int column) {
    rowData[row][column] = value;
  }
  
  @Override
  public boolean isCellEditable(int row, int column) {
    return (column != 0);
  }
}
