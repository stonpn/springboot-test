package my.test.spring.boot.mapper;

import my.test.spring.boot.common.model.MemberModel;
import org.apache.ibatis.annotations.Param;


/**
 * Created by pengni on 17-7-13.
 */
public interface TestMapper {

    void updateById(@Param("id") long id);

    MemberModel selectById(@Param("id") long id);
}
