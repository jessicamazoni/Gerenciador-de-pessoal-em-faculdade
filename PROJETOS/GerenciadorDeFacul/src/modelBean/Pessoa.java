package modelBean;

public abstract class Pessoa {

    private long id;
    private String nome;
    private String data;
    private String sexo;
    private long rg;
    private String endereco;
    private int id_campus;

    public Pessoa(long id, String nome, String data, String sexo, long rg, String endereco, int id_campus) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.sexo = sexo;
        this.rg = rg;
        this.endereco = endereco;
        this.id_campus = id_campus;
    }

    public Pessoa() {

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId_campus() {
        return id_campus;
    }

    public void setId_campus(int id_campus) {
        this.id_campus = id_campus;
    }

}
