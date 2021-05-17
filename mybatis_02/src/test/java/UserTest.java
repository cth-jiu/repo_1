import com.cc.domain.User;
import com.cc.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        PageHelper.startPage(1,2);

        List<User> list = mapper.findAll();

        PageInfo<User> userPageInfo = new PageInfo<User>(list);

        for (User user : list) {
            System.out.println(user);
        }

        System.out.println(userPageInfo.getPages());
        System.out.println(userPageInfo.getTotal());
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.findUserById(1);

        System.out.println(user);

    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.findUserByIdAndName(1,"子 慕");

        for (User user1 : user) {
            System.out.println(user1);
        }

    }
    @Test
    public void test4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.findUserByIdAndName1(1,"子 慕");

        for (User user1 : user) {
            System.out.println(user1);
        }

    }
    @Test
    public void test5() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user2 = new User();
        user2.setUsername("子 慕");
        user2.setId(1);
        List<User> user = mapper.findUserByIdAndName2(user2);

        for (User user1 : user) {
            System.out.println(user1);
        }

    }
    @Test
    public void test6() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> user = mapper.findUserByName("%子 慕%");

        for (User user1 : user) {
            System.out.println(user1);
        }

    }
    @Test
    public void test7() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> user = mapper.findUserByName2("%子 慕%");

        for (User user1 : user) {
            System.out.println(user1);
        }

    }
    @Test
    public void test8() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

        user.setUsername("张");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京");

        System.out.println(user);
        mapper.saveUser(user);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test9() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("楠");
//        user.setId(5);
        List<User> users = mapper.findUserByName3(user);

        for (User user1 : users) {
            System.out.println(user1);
        }

    }

    @Test
    public void test10() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

        user.setId(6);

//        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("福建");

        mapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test11() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(8);

        List<User> list1 = mapper.findList(list);

        for (User user : list1) {
            System.out.println(user);
        }
//        sqlSession.commit();
        sqlSession.close();

    }
}
