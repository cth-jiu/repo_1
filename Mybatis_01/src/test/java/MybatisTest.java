import com.cc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    @Test
    public void findTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("UserMapper.findAll");

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    @Test
    public void saveTest() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("张");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("福州");

        sqlSession.insert("UserMapper.saveUser",user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void updateTest() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(3);
        user.setUsername("李");
//        user.setBirthday(new Date());
        user.setSex("女");
//        user.setAddress("福州");

        sqlSession.update("UserMapper.updateUser",user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void delTest() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(3);

        sqlSession.delete("UserMapper.delUser",user);

        sqlSession.commit();
        sqlSession.close();

    }
}
