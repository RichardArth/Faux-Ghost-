package com.fauxghost.service;

import com.fauxghost.dto.LoginRequest;
import com.fauxghost.dto.LoginResponse;
import com.fauxghost.dto.RegistroRequest;
import com.fauxghost.model.Usuario;
import com.fauxghost.repository.UsuarioRepository;
import com.fauxghost.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String registrar(RegistroRequest req) {
        if (usuarioRepository.existsByEmail(req.getEmail())) {
            return "Email já cadastrado!";
        }
        Usuario u = new Usuario();
        u.setNome(req.getNome());
        u.setEmail(req.getEmail());
        u.setSenha(passwordEncoder.encode(req.getSenha()));
        u.setRole("user");
        usuarioRepository.save(u);
        return "ok";
    }

    public LoginResponse login(LoginRequest req) {
        Usuario u = usuarioRepository.findByEmail(req.getEmail()).orElse(null);
        if (u == null || !passwordEncoder.matches(req.getSenha(), u.getSenha())) {
            return null;
        }
        String token = jwtUtil.gerarToken(u.getEmail(), u.getRole());
        return new LoginResponse(u.getNome(), u.getEmail(), u.getRole(), token);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public boolean atualizarPerfil(String email, String nome, String senha) {
        Usuario u = usuarioRepository.findByEmail(email).orElse(null);
        if (u == null) return false;
        u.setNome(nome);
        if (senha != null && !senha.isEmpty()) {
            u.setSenha(passwordEncoder.encode(senha));
        }
        usuarioRepository.save(u);
        return true;
    }
}