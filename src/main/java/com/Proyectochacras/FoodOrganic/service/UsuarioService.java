package com.Proyectochacras.FoodOrganic.service;

import com.Proyectochacras.FoodOrganic.models.Usuario;
import com.Proyectochacras.FoodOrganic.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para guardar un usuario
    public void saveUsuario(Usuario usuario) {
        // Aquí puedes agregar lógica adicional, como encriptar la contraseña si es necesario
        usuarioRepository.save(usuario); // Guardar el usuario en la base de datos
    }
}
