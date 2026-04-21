package ricardo.gabriel.praticando_spring.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ricardo.gabriel.praticando_spring.model.Usuario;

@Service
public class UsuarioDetailsService implements UserDetailsService {
    
    private final UsuarioService usuarioService;

    public UsuarioDetailsService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioService.buscarPorUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        return User.builder()
            .username(usuario.getUsername())
            .password(usuario.getPassword())
            .roles("USER")
            .build();
    }
}
