import com.cc.mapper.ArticleMapper;
import com.cc.pojo.Article;
import com.cc.pojo.Comment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ArticleTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession会话对象
        sqlSession = sqlSessionFactory.openSession();
    }
    @After
    public void after(){
        //手动提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test1(){

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        List<Article> articleList = mapper.findAll();

        for (Article article : articleList) {
            System.out.println(article);
            System.out.println(article.getCommentList());
        }
    }
}
