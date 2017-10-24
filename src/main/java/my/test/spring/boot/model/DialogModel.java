package my.test.spring.boot.model;

public class DialogModel {

    private Integer id;

    private String dialog;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DialogModel{" +
                "id=" + id +
                ", dialog='" + dialog + '\'' +
                '}';
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }
}
