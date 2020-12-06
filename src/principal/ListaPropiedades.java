package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ListaPropiedades {
	private String ruta=null;
	private String contenido = null;
	
	File raiz = new File("test_archivo");

	public ListaPropiedades() {
		
	}
	
	public Properties obtenerElementos(String ruta) throws FileNotFoundException, IOException {
        String[] archivos = raiz.list();
        Properties elemento = new Properties();
        for (String archivo : archivos) {
	        elemento.load(new FileReader(ruta+archivo));
		}
		return elemento;
	}
	
	public void establecerContenido(String ruta) {
		this.contenido = "";
		try{
			File archivo = new File(ruta);
			Scanner entrada = new Scanner(archivo);
			while(entrada.hasNextLine()) {
				this.contenido += entrada.nextLine()+"\n";
			}
			entrada.close();
		}catch(FileNotFoundException e) {
			System.out.println("El archivo no se encuentra");
			e.printStackTrace();
		}
	}
	public String obtnerRuta() {
		return this.ruta;
	}
	public void establecerRuta(String ruta) {
		this.ruta = ruta;
	}
	public void agregarElemento(Properties elemento){
		System.out.println();
		escribir(elemento);
		System.out.println("elemento "+elemento+" agregado a la lista\n");
		//establecerContenido(this.ruta);
	}
/*	public void borrarElemento(String elemento){
		String contenidoNuevo = "";
		boolean elementoBorrado = false;

		Scanner entrada = new Scanner(this.contenido);
		while(entrada.hasNextLine()) {
			String buscador = entrada.nextLine();
			if(buscador.equals(elemento)) {
				elementoBorrado = true;
			}else {
				contenidoNuevo += buscador+"\n";
			}
		}
		if (elementoBorrado) {
			escribir(this.ruta,contenidoNuevo);
			establecerContenido(this.ruta);
			System.out.println("\nelemento "+elemento+" encontrado y borrado");
		} else {
			System.out.println("elemento no encontrado");
		}
		entrada.close();
	}*/
	public void datosDelArchivo() {
		File archivo = new File("archivo/Lista");

		System.out.println("File name: " + archivo.getName());
		System.out.println("Absolute path: " + archivo.getAbsolutePath());
		System.out.println("Writeable: " + archivo.canWrite());
		System.out.println("Readable " + archivo.canRead());
		System.out.println("File size in bytes " + archivo.length());
		System.out.println();
	}
	private static void escribir(Properties libro) {
		
		try {
			FileWriter escritor = new FileWriter(libro.getProperty("ruta"));
			libro.store(escritor, "primer libro");
			escritor.close();
			System.out.println("Se complet� la escritura en el archivo");
			}catch(IOException e) {
			System.out.println("Error al escribir el archivo");
			e.printStackTrace();
		}
	}
}
