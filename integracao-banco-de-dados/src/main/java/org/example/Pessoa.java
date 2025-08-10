package org.example;

import java.time.LocalDate;

public class Pessoa {
    private long id;
    private String nome;
    private String cpf;
    private String sobrenome;
    private double altura;
    private double peso;
    private boolean ativo;
    private LocalDate dataNascimento;

    public Pessoa(long id, String nome, String cpf, String sobrenome, double altura, double peso, boolean ativo, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
        this.altura = altura;
        this.peso = peso;
        this.ativo = ativo;
        this.dataNascimento = dataNascimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String isAtivo() {
        return ativo;
    }

    public void setAtivo() {
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
