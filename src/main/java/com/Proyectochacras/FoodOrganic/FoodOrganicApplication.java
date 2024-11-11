package com.Proyectochacras.FoodOrganic;

import com.Proyectochacras.FoodOrganic.models.EstadoChacra;
import com.Proyectochacras.FoodOrganic.models.Productor;
import com.Proyectochacras.FoodOrganic.models.Publicacion;
import com.Proyectochacras.FoodOrganic.models.Rol;
import com.Proyectochacras.FoodOrganic.service.ProductorService;
import com.Proyectochacras.FoodOrganic.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodOrganicApplication implements CommandLineRunner {

	@Autowired
	private ProductorService productorService;

	@Autowired
	private PublicacionService publicacionService;

	public static void main(String[] args) {
		SpringApplication.run(FoodOrganicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Crear algunos productores de ejemplo
		Productor productor1 = new Productor();
		productor1.setContrasena("12345");
		productor1.setCorreo("productor1@correo.com");
		productor1.setNombre("Productor 1");
		productor1.setRol(Rol.USUARIO);

		Productor productor2 = new Productor();
		productor2.setContrasena("54321");
		productor2.setCorreo("productor2@correo.com");
		productor2.setNombre("Productor 2");
		productor2.setRol(Rol.ADMINISTRADOR);

		// Guardar los productores en la base de datos
		productorService.crearProductor(productor1);
		productorService.crearProductor(productor2);

		// Crear publicaciones asociadas a los productores
		Publicacion publicacion1 = new Publicacion();
		publicacion1.setNombreChacra("Chacra 1");
		publicacion1.setDescripcion("Descripción de la chacra 1");
		publicacion1.setUbicacionChacra("Ubicación de la chacra 1");
		publicacion1.setEstado(EstadoChacra.DISPONIBLE);
		publicacion1.setProductor(productor1); // Asignar productor1 a la publicación

		Publicacion publicacion2 = new Publicacion();
		publicacion2.setNombreChacra("Chacra 2");
		publicacion2.setDescripcion("Descripción de la chacra 2");
		publicacion2.setUbicacionChacra("Ubicación de la chacra 2");
		publicacion2.setEstado(EstadoChacra.OCUPADO);
		publicacion2.setProductor(productor2); // Asignar productor2 a la publicación

		// Guardar las publicaciones en la base de datos
		publicacionService.crearPublicacion(
				productor1.getId(),
				publicacion1.getNombreChacra(),
				publicacion1.getDescripcion(),
				publicacion1.getUbicacionChacra(),
				publicacion1.getEstado().toString()
		);

		publicacionService.crearPublicacion(
				productor2.getId(),
				publicacion2.getNombreChacra(),
				publicacion2.getDescripcion(),
				publicacion2.getUbicacionChacra(),
				publicacion2.getEstado().toString()
		);
	}
}
