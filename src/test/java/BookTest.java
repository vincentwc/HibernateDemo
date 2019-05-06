import com.entity.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试类
 */
public class BookTest {

    private SessionFactory factory;

    @Before
    public void init() {
        //1.c创建一个configuration对象
        Configuration cfg = new Configuration().configure();
        //2.创建SessionFactory对象
        factory = cfg.buildSessionFactory();
    }

    @Test
    public void testSave() {
        //3.创建session对象，该对象具有增删改的方法
        Session session = factory.openSession();
        //4.开启事务
        Transaction tx = session.beginTransaction();
        //5.保存数据
        Book book = new Book();
        book.setName("Java从入门到精通");
        book.setAuthor("vincent");
        book.setPrice(9.9);
        session.save(book);
        //6. 提交事务
        tx.commit();
        //7.释放资源
        session.close();
    }

    @Test
    public void testFindOne() {
        //获得session对象
        Session session = factory.openSession();
        //通过session进行查询
        Book book = session.get(Book.class, 2);
        System.out.println(book);
        session.close();
    }



}
