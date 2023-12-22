package com.corenetworks.presentacion;

import com.corenetworks.persistencia.AccesoFunciones;

import java.sql.SQLException;

public class ProbarFuncion {

    public static void main(String[] args) {
        AccesoFunciones aF1 = new AccesoFunciones();
        try {
            System.out.println("Cantidad en existencia -> " + aF1.probarFuncion());
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
