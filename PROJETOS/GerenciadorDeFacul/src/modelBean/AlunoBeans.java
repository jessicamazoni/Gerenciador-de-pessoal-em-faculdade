package modelBean;

public class AlunoBeans extends Pessoa {

    private int curso;

    public AlunoBeans(long id, String nome, String data, String sexo, long rg, int curso, String endereco, int id_campus) {
        super(id, nome, data, sexo, rg, endereco, id_campus);
        this.curso = curso;
    }

    public AlunoBeans() {

    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

}
