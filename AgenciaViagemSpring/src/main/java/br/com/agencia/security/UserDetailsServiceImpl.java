package br.com.agencia.security;

import br.com.agencia.model.Cliente;
import br.com.agencia.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class  UserDetailsServiceImpl implements UserDetailsService {

    final UsuarioRepository userRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.UsuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Cliente cliente = UsuarioRepository.findByNome(nome)
                .orElseThrow(() -> new ClienteNotFoundException("User Not Found with username: " + nome));
        return new User(cliente.getNome(), cliente.getSenha(), true, true, true,true, cliente.getAuthorities());
    }
}


