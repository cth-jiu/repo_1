import com.lagou.damain.User;
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
    public void findtest() throws IOException {

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
    public void savetest() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("成");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("福建福州");

        sqlSession.insert("UserMapper.saveUser",user);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updatetest() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(5);
        user.setUsername("楠");
        user.setSex("男");

        sqlSession.update("UserMapper.updateUser",user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("UserMapper.delUser",6);

        sqlSession.commit();
        sqlSession.close();
    }
}
