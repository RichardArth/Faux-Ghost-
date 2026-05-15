package com.fauxghost.config;

import com.fauxghost.model.Produto;
import com.fauxghost.model.Usuario;
import com.fauxghost.repository.ProdutoRepository;
import com.fauxghost.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final ProdutoRepository produtoRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UsuarioRepository usuarioRepository,
                      ProdutoRepository produtoRepository,
                      PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.produtoRepository = produtoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (!usuarioRepository.existsByEmail("admin@faux.com")) {
            Usuario admin = new Usuario();
            admin.setNome("Admin");
            admin.setEmail("admin@faux.com");
            admin.setSenha(passwordEncoder.encode("123456"));
            admin.setRole("admin");
            usuarioRepository.save(admin);
        }

        if (produtoRepository.count() == 0) {
            String[][] dados = {
    {"Camiseta Básica", "Algodão penteado · preta", "49.90", "60", "Camisetas", "/imagens/roupa1.jpg", "true"},
    {"Jaqueta Jeans", "Jeans azul · lavagem clara", "179.90", "22", "Jaquetas", "/imagens/roupa2.jpg", "true"},
    {"Calça Cargo", "Sargaço · preta", "129.90", "30", "Calças", "/imagens/roupa3.jpg", "true"},
    {"Moletom Capuz", "Felpo macio · cinza mescla", "99.90", "25", "Moletons", "/imagens/roupa4.jpg", "true"},
    {"Regata Canelada", "Canelada · branca", "39.90", "40", "Camisetas", "/imagens/roupa5.jpg", "true"},
    {"Blazer Slim", "Microfibra · preto", "249.90", "12", "Blazers", "/imagens/roupa6.jpg", "true"},
    {"Shorts Sarja", "Sarja · bege", "79.90", "35", "Shorts", "/imagens/roupa7.jpg", "true"},
    {"Camisa Linho", "Linho · branca", "159.90", "18", "Camisas", "/imagens/roupa8.jpg", "true"}
};

            for (String[] d : dados) {
                Produto p = new Produto();
                p.setNome(d[0]);
                p.setDescricao(d[1]);
                p.setPreco(Double.parseDouble(d[2]));
                p.setEstoque(Integer.parseInt(d[3]));
                p.setTipo(d[4]);
                p.setImagem(d[5]);
                p.setDestaque(Boolean.parseBoolean(d[6]));
                produtoRepository.save(p);
            }
        }
    }
}