package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

public class PessoaMapper {

    private PessoaMapper() {}

    public static PessoaEntity toEntity(PessoaBO bo) {
        PessoaEntity e = new PessoaEntity();
        e.setId(bo.getId());
        e.setNomeCompleto(bo.getNomeCompleto());
        e.setCpf(bo.getCpf());
        e.setDataNascimento(bo.getDataNascimento());
        e.setEmail(bo.getEmail());
        e.setTelefone(bo.getTelefone());
        return e;
    }

    public static PessoaBO toBO(PessoaEntity e) {
        PessoaBO bo = new PessoaBO();
        bo.setId(e.getId());
        bo.setNomeCompleto(e.getNomeCompleto());
        bo.setCpf(e.getCpf());
        bo.setDataNascimento(e.getDataNascimento());
        bo.setEmail(e.getEmail());
        bo.setTelefone(e.getTelefone());
        return bo;
    }
}