package modelBean;

public class FuncionarioBeans extends Pessoa {

    private int id_prof;

    public FuncionarioBeans(long id, String nome, String data, String sexo, long rg, int id_prof, String endereco, int id_campus) {
        super(id, nome, data, sexo, rg, endereco, id_campus);
        this.id_prof = id_prof;
    }

    public FuncionarioBeans() {

    }

    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

}
