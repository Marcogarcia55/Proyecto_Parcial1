package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class Farmacia {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idFarmacia;
    private String nombreFarmacia;
    private String direccion;
    private String telefono;
    private int activo;

    public Farmacia(int idFarmacia, String nombreFarmacia, String direccion, String telefono, int activo) {
        this.idFarmacia = idFarmacia;
        this.nombreFarmacia = nombreFarmacia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.activo = activo;
    }

    public Farmacia() {
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public void setNombreFarmacia(String nombreFarmacia) {
        this.nombreFarmacia = nombreFarmacia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM farmacias";

        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM farmacias WHERE idfarmacias = " + idFarmacia;
        DefaultTableModel res = dataAccess.Query(query);
        idFarmacia = (int) res.getValueAt(0, 0);
        nombreFarmacia = (String) res.getValueAt(0, 1);
        direccion = (String) res.getValueAt(0, 2);
        telefono = (String) res.getValueAt(0, 3);
        activo = (int) res.getValueAt(0, 4);

    }

    public boolean Add() {
        String query = "INSERT INTO farmacias(nombreFarmacias, direccion, telefono, activo)"
                + "VALUES('" + nombreFarmacia + "', '" + direccion + "','" + telefono + "', " + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM farmacias WHERE idfarmacias = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete2() {
        String query = "DELETE productos, farmacias FROM productos JOIN farmacias ON "
                + "productos.idFarmacia=farmacias.idfarmacias WHERE farmacias.idfarmacias = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE farmacias SET "
                + "nombreFarmacias = '" + nombreFarmacia + "', "
                + "direccion = '" + direccion + "', "
                + "telefono = " + telefono + ", "
                + "activo = " + activo + " "
                + "WHERE idfarmacias = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }

}
