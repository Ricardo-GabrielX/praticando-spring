package ricardo.gabriel.praticando_spring.service;

import org.springframework.stereotype.Service;

import ricardo.gabriel.praticando_spring.model.Usuario;
import ricardo.gabriel.praticando_spring.repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioService {

        private final UsuarioRepository usuarioRepository;
        private final PasswordEncoder passwordEncoder;
        
        public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
            this.usuarioRepository = usuarioRepository;
            this.passwordEncoder = passwordEncoder;
        }

        public Usuario registrarUsuario(String username, String password) {
            String senhaCriptografada = passwordEncoder.encode(password);
            Usuario usuario = new Usuario(username, senhaCriptografada);
            return usuarioRepository.save(usuario);
        }

        public Optional<Usuario> buscarPorUsername(String username) {
            return usuarioRepository.findByUsername(username);
        }
}
