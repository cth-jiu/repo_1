import com.cc.domain.Orders;
import com.cc.domain.User;
import com.cc.mapper.OrdersMapper;
import com.cc.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class test {
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
         sqlSession = sqlSessionFactory.openSession();

    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findById(1);

        for (User user : userList) {
            System.out.println(user);
        }
    }@Test
    public void test3(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();

        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void test2(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User();
        user1.setUsername("撒旦");
        user1.setBirthday(new Date());
        user1.setSex("男");
        user1.setAddress("上海");

        mapper.save(user1);

    }
    @Test
    public void test4(){
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = mapper.findAll();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }

}
