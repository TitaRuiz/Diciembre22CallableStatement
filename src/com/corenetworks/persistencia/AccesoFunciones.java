package com.corenetworks.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoFunciones extends Conexion{

    public int probarFuncion() throws SQLException, ClassNotFoundException {
        //1. Declaracion de variables
        CallableStatement sentencia = null;
        ResultSet rejilla = null;
        String sql = "select cantidades_existencia();";
        int resultado = 0;
        //2. Abrir la conexion
        abrirConexion();
        //3. Crear el statement
        sentencia = miConexion.prepareCall(sql);
        //4. Ejecutar el statement
        rejilla = sentencia.executeQuery();
        if(rejilla.next()){
            resultado = rejilla.getInt("cantidades_existencia");
        }
        //5. Devolver el resultado
        return resultado;
    }

    public String probarFuncionConParametro(int id) throws SQLException, ClassNotFoundException {
        //1. Declaracion de variables
        CallableStatement sentencia = null;
        ResultSet rejilla = null;
        String sql = "select nombre_producto(?);";
        String resultado = null;
        //2. Abrir la conexion
        abrirConexion();
        //3. Crear el statement
        sentencia = miConexion.prepareCall(sql);
        sentencia.setInt(1,id);
        //4. Ejecutar el statement
        rejilla = sentencia.executeQuery();
        if(rejilla.next()){
            resultado = rejilla.getString("nombre_producto");
        }
        //5. Devolver el resultado
        return resultado;
    }
}
