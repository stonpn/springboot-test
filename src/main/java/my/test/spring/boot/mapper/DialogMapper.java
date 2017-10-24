package my.test.spring.boot.mapper;

import my.test.spring.boot.model.DialogModel;

import java.util.List;

public interface DialogMapper {

    List<DialogModel> selectAll();

    void insert(String dialog);

    void delete(int id);

}
