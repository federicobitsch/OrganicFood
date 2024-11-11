package com.Proyectochacras.FoodOrganic.repositories;

import com.Proyectochacras.FoodOrganic.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
