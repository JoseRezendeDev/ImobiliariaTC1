package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Cliente {
    private String nome;
    // chave primaria
    private String cpf;
    private Date dataNascimento;
    private Enum<Sexo> sexo;
    private Double salario;
    private List<String> emails;
    private List<String> telefones;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return new SimpleDateFormat().format(dataNascimento);
    }

    public void setDataNascimento(String dataNascimento) throws ParseException {
        this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
    }

    public String getSexo() {
        return sexo.toString();
    }

    public void setSexo(String sexo) throws Exception {
        if (sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("masculino")) {
            this.sexo = Sexo.MASCULINO;
        } else if (sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("feminino")) {
            this.sexo = Sexo.FEMININO;
        } else {
            throw new Exception();
        }

    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }
}