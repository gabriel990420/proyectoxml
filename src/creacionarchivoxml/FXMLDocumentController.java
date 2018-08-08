/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacionarchivoxml;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Empleado;

/**
 *
 * @author gabriel.mercado
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label ltitulo, lnombre, ldireccion, ledad, lcodigo, ldepartamento;
    @FXML
    private TextField tnombre, tdireccion, tedad, tcodigo, tdepartamento;
    LinkedList<Empleado> listaEmpleado;

    @FXML
    private void agregarEmpleado(ActionEvent event) {
        String nombre = tnombre.getText();
        String direccion = tdireccion.getText();
        int edad = Integer.parseInt(tedad.getText());
        String codigo = tcodigo.getText();
        String departamento = tdepartamento.getText();
        listaEmpleado.add(new Empleado(codigo, departamento, nombre, direccion, edad));
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaEmpleado = new LinkedList<>();
    }

}
