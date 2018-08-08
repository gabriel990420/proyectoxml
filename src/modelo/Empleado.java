/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author dacastro
 */
public class Empleado extends Persona {

    private String codigoEmpleado;
    private String departamento;

    public Empleado() {
    }

    public Empleado(String codigoEmpleado, String departamento, String nombre, String direccion, int edad) {
        super(nombre, direccion, edad);
        this.codigoEmpleado = codigoEmpleado;
        this.departamento = departamento;
    }

    /**
     * Get the value of departamento
     *
     * @return the value of departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Set the value of departamento
     *
     * @param departamento new value of departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Get the value of codigoEmpleado
     *
     * @return the value of codigoEmpleado
     */
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    /**
     * Set the value of codigoEmpleado
     *
     * @param codigoEmpleado new value of codigoEmpleado
     */
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    @Override
    public String toString() {
        return  super.toString() + "," + codigoEmpleado + "," + departamento ;
    }

    public boolean guardarEmpleados(LinkedList<Empleado> listaEmpleados) {
        boolean g = false;
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("Empleados.txt");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            for (int i = 0; i < listaEmpleados.size(); i++) {
                //escribe los datos en el archivo
                bfwriter.write(listaEmpleados.get(i) + "\n");
            }
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");
            g = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return g;

    }
    public LinkedList<Empleado> recuperarDeArchivo() 
            
    {
       LinkedList<Empleado> losEmpleado=  new LinkedList<>();
        try { 

            String Archivo = "Empleados.txt";                
 
            BufferedReader  input  =  new  BufferedReader( 
                new  FileReader(Archivo) ) ;
            String[] datos;
            String linea;
            int laEdad;
            String nombre;
            String direccion;
            String Departamento;
            String codigo;
            
            while( ( linea = input.readLine() ) != null )
            {
                // Separa cada dato de la cadena leida, usando el formato utilizado al guardar
                datos = linea.split(",");
                nombre = datos[0];
                direccion = datos[1];
                Departamento = datos[4];
                codigo = datos[3];
                laEdad = Integer.parseInt(datos[2]);
                losEmpleado.add(new Empleado(codigo, Departamento, nombre, direccion, laEdad));
            }
            input.close();
                                                      
       } catch( java.io.IOException  e ) { 
           // Se ´puede personalizar el mensaje de error           
           e.printStackTrace() ; 
       }
        return losEmpleado;
    }

    public String buscarEmpleados(String codigoB) {
     String ans ="";
     LinkedList<Empleado> losEmpleaditos= recuperarDeArchivo();
        for (int i = 0; i < losEmpleaditos.size(); i++) {
            if(losEmpleaditos.get(i).getCodigoEmpleado().equals(codigoB)){
            ans+= losEmpleaditos.get(i).getNombre() + "\n"+ 
                    losEmpleaditos.get(i).getDireccion()+"\n"+
                    losEmpleaditos.get(i).getEdad()+"\n"+
                    losEmpleaditos.get(i).getCodigoEmpleado()+"\n"+
                    losEmpleaditos.get(i).getDepartamento()+"\n";
            
            
            }
            
        }
     return ans;
    }

    public LinkedList<Empleado> ordenarEmpleados(LinkedList<Empleado> ListaEmpleado) {
          
         ListaEmpleado= recuperarDeArchivo();
//         for (int i = 0; i < ListaTemporal.size(); i++) {
//            ListaEmpleado.set(i, ListaTemporal.get(i).getNombre());
//        }
       for (int i = 0; i < ListaEmpleado.size(); i++) {
            for (int j = 0; j < ListaEmpleado.size()-1; j++) {
                if(ListaEmpleado.get(j).getNombre().compareTo(ListaEmpleado.get(j+1).getNombre())>0){
                   Empleado aux = new Empleado();
                    aux=ListaEmpleado.get(j);
                    ListaEmpleado.set(j, ListaEmpleado.get(j+1));
                    ListaEmpleado.set(j+1, aux);
                    
                
                
              
            }
      }


       } 
        
        return ListaEmpleado;
    }

    public boolean crearFileXML(LinkedList<Empleado> listaEmpleado) {
        try {
            Element company = new Element("company");
            Document doc= new Document(company);
           
            for (int i = 0; i < 10; i++) {
                   Element empleado=new Element("empleado");   
                
            empleado.addContent(new Element("nombre").setText(listaEmpleado.get(i).getNombre()));
            empleado.addContent(new Element("Dreccion").setText(listaEmpleado.get(i).getDireccion()));
            }
       
        }

    }
       
    }



