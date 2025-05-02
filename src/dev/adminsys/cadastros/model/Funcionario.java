package dev.adminsys.cadastros.model;

import java.sql.Date;

public class Funcionario {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Date data_contratacao;
    private double salario;
    private String cargo;
    private String cpf;
    private String nomeDepartamento;
    private Departamento departamento;

    // NoArgsConstructor
    public Funcionario() {}

    // AllArgsConstructor


    public Funcionario(Long id, String nome, String telefone, String email, Date data_contratacao, double salario, String cargo, String cpf, String nomeDepartamento, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.data_contratacao = data_contratacao;
        this.salario = salario;
        this.cargo = cargo;
        this.cpf = cpf;
        this.nomeDepartamento = nomeDepartamento;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return String.format("""
        Funcionario [
            ID: %d
            Nome: %s
            Telefone: %s
            Email: %s
            Data de Contratação: %s
            Salário: R$ %.2f
            Cargo: %s
            CPF: %s
            Departamento: %s
        ]
        """, id, nome, telefone, email,
                data_contratacao != null ? data_contratacao.toString() : "Não Informada",
                salario, cargo, cpf != null ? cpf : "Não Informado", nomeDepartamento != null ? nomeDepartamento : "Não Vinculado");
    }

}
