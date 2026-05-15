package com.fauxghost.service;

import com.fauxghost.dto.ProdutoDTO;
import com.fauxghost.model.Produto;
import com.fauxghost.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public Produto salvar(ProdutoDTO dto) {
        Optional<Produto> existente = produtoRepository.findByNome(dto.getNome());
        Produto p;
        if (existente.isPresent()) {
            p = existente.get();
        } else {
            p = new Produto();
            p.setNome(dto.getNome());
        }
        p.setPreco(dto.getPreco());
        p.setEstoque(dto.getEstoque() != null ? dto.getEstoque() : 0);
        p.setDescricao(dto.getDescricao());
        p.setImagem(dto.getImagem());
        p.setTipo(dto.getTipo());
        p.setDestaque(dto.getDestaque());
        return produtoRepository.save(p);
    }

    public void remover(String nome) {
        Produto p = produtoRepository.findByNome(nome).orElse(null);
        if (p != null) produtoRepository.delete(p);
    }
}