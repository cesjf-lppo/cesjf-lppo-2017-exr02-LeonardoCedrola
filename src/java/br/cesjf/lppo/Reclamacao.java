package br.cesjf.lppo;

public class Reclamacao {
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private Integer status;

    public Reclamacao() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    void setId(long id) {
        this.id = id;
    }
    
    public String stringStatus () {
        switch (status) {
            case 0:
                return "Aberto";
            case 1:
                return "Confirmado";
            case 2:
                return "Recusado";
            case 3:
                return "Em execução";
            case 4:
                return "Resolvido";
            default: return "";
        }
    }
}
