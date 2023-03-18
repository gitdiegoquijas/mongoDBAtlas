/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsm501.mongodbatlas;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author diegopadilla
 */
public class Main {
    
    public static void main(String[] args) {
        // Conexion de MongoAtlas a la aplicacion
        String uri = "mongodb+srv://padillaq7:1234@cluster0.cellp1z.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            JOptionPane.showMessageDialog(null,"Se ha conectado a la base de datos en la nube", "Conexion a MongoAtlas Exitosa", JOptionPane.INFORMATION_MESSAGE);
            MongoDatabase database = mongoClient.getDatabase("rocha");
            MongoCollection<Document> collection = database.getCollection("computadoras");
            
            
            
            
            
            
//            /*Busqueda de una computadora*/
//         String marca = JOptionPane.showInputDialog(null, "Ingresa el atributo a buscar:");
//         String valor = JOptionPane.showInputDialog(null, "Ingresa el valor a buscar:");
//    
//         Document doc = collection.find(eq(marca, valor)).first();
//        if (doc != null) {
//            JOptionPane.showMessageDialog(null, doc.toJson());
//        } else {
//            JOptionPane.showMessageDialog(null, "No se encuentra registrada");
//        }
        
        
        /*Insertamos un documentoNuevo*/
        
        
//         String añoLanzamiento = JOptionPane.showInputDialog(null, "Ingrese el año de la computadora de lanzamiento", "Insertar documento", JOptionPane.INFORMATION_MESSAGE);
//         String medidaPantalla = JOptionPane.showInputDialog(null, "Ingresa la medida de la computadora", "Insertar documento", JOptionPane.INFORMATION_MESSAGE);
//         String marcaInsertar = JOptionPane.showInputDialog(null, "Ingresa la marca de la computadora", "Insertar documento", JOptionPane.INFORMATION_MESSAGE);
//         String modelo = JOptionPane.showInputDialog(null, "Ingresa la marca de la computadora", "Insertar documento", JOptionPane.INFORMATION_MESSAGE);
//         String ram = JOptionPane.showInputDialog(null, "Ingresa la RAM de la computadora", "Insertar documento", JOptionPane.INFORMATION_MESSAGE);
//         String calidadPantalla = JOptionPane.showInputDialog(null, "Ingresa la calidad de la pantalla computadora", "Insertar documento", JOptionPane.INFORMATION_MESSAGE);
//         String procesador = JOptionPane.showInputDialog(null, "Ingresa el procesador de la computadora", "Insertar documento", JOptionPane.INFORMATION_MESSAGE);
//         String tarjetaGrafica = JOptionPane.showInputDialog(null, "Ingresa la tarjeta grafica de la computadora", "Insertar documento", JOptionPane.INFORMATION_MESSAGE);
//         //Inserta un documento nuevo
//           try {
//                InsertOneResult result = collection.insertOne(new Document()
//                                                                .append("añoLanzamiento", añoLanzamiento)
//                                                                .append("medidaPantalla", medidaPantalla)
//                                                                .append("marca", marcaInsertar)
//                                                                .append("modelo", modelo)
//                                                                .append("especificaciones", new Document()
//                                                                                              .append("ram", ram)
//                                                                                              .append("calidadPantalla", calidadPantalla)
//                                                                                              .append("procesador", procesador)
//                                                                                              .append("tarjetaGrafica", tarjetaGrafica)
//                                                                        )
//                                                                );
//                System.out.println("Se pudo hacer la insercion: de la computadora" + modelo);
//                JOptionPane.showMessageDialog(null, "Se ha hecho la insercion correctamente", "Un nuevo Registro", JOptionPane.INFORMATION_MESSAGE);
//            } catch (MongoException me) {
//                System.err.println("No fue posible realizar la insercion, debido a un error: " +me);
//            }


            /*Actualiza la especificacion de una computadora seleccionandola por el nombre*/
           
//            String updateCompu = JOptionPane.showInputDialog(null, "Ingrese la marca de la computadora");
//            //Este actualiza un documento
//           Document query = new Document().append("marca",  updateCompu);
//           String updateEspec = JOptionPane.showInputDialog(null, "Ingrese el nombre de la especificacion de la computadora");
//            String updateValor = JOptionPane.showInputDialog(null, "Ingrese la descripcion de la especificacion");
//            Bson updates = Updates.set(updateEspec, updateValor);
//            UpdateOptions options = new UpdateOptions().upsert(true);
//            try {
//                UpdateResult result = collection.updateOne(query, updates, options);
//                JOptionPane.showMessageDialog(null, "Se ha actualizado un registro para: "+updateCompu, "Actualizacion Correcta", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println("Se ha actualizado una colecion count: " + result.getModifiedCount());
//                System.out.println("Upserted id: " + result.getUpsertedId()); //solo contiene un valor cuando un upsert es ejecutado
//            } catch (MongoException me) {
//                System.err.println("No se ha podido actualizar debido a un error: " + me);
//            }
           
           /*Elimina el documento de la base de datos*/
           String pedirInfo = JOptionPane.showInputDialog(null, "Como desea referir la especificacion para buscar a la computadora");
           String valor =JOptionPane.showInputDialog(null, "escriba la especificacion de la computadora");
           Bson consultaInstruccion = eq(pedirInfo, valor);
            try {
                DeleteResult result = collection.deleteOne(consultaInstruccion);
                 JOptionPane.showMessageDialog(null, "Se ha borrado un registro para: "+valor, "Eliminacion Correcta", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Se ha borrado el registro: " + result.getDeletedCount());
            } catch (MongoException me) {
                System.err.println("No se pudo eliminar la insercion debido a un error: " + me);
                JOptionPane.showMessageDialog(null, "No Se ha borrado un registro para: "+valor, "Error al Eliminar", JOptionPane.ERROR_MESSAGE);
            }
           mongoClient.close();
           
            
        }catch(MongoException me) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion", "Conexion Fallida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: "+me.getMessage());
        }
    }
}
