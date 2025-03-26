package com.luismede.adminsys.model;

public class Funcionario {
    private String nome;
    private String cargo;
    private String cpf;
    private double salario;
    private int dept_id;

    public Funcionario() {}

    public Funcionario(String nome, String cargo, String cpf, double salario, int dept_id) {
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
        this.salario = salario;
        this.dept_id = dept_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public double getSalario() {
        return salario;
    }


    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", Cargo: " + this.cargo + ", CPF: " +
                this.cpf + ", Salario: " + this.salario + ", Departamento: "  + this.dept_id;
    }
}
