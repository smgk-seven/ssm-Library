package com.smgk.library.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.smgk.library.bean.Admin;
import com.smgk.library.bean.Book;
import com.smgk.library.bean.Genre;
import com.smgk.library.bean.Lead;
import com.smgk.library.bean.StuLeadInfo;
import com.smgk.library.bean.Student;
import com.smgk.library.dao.AdminMapper;
import com.smgk.library.dao.BookMapper;
import com.smgk.library.dao.GenreMapper;
import com.smgk.library.dao.LeadMapper;
import com.smgk.library.dao.StudentMapper;
import com.smgk.library.service.AdminService;
import com.smgk.library.service.StudentService;
import com.smgk.library.util.utils;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	private AdminService adminService;
	@Autowired
	private StudentService studentService;
	@Autowired
	SqlSession sqlSession;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private LeadMapper leadMapper;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private GenreMapper genreMapper;
	
	@Test
	public void testMapperCRUD(){
		Student stu = studentMapper.getStuLeadBookByStuId(1);
		//System.out.println(stu);
		List<Lead> lendList = leadMapper.selectByExample(null);
		for(Lead le:lendList){
			//System.out.println(le);
		}
		Student student = studentMapper.selectByPrimaryKey(1);
		//System.out.println(student);
		//Book book = bookMapper.selectByPrimaryKey(1);
		//System.out.println(book);
		List<Lead> leadList = leadMapper.getAllLeadBookStuInfo();
		for(Lead l:leadList){
			System.out.println(l);
		}
		//查找 所有的书 书和 他的类别 的信息
		List<Book> bookList = bookMapper.getAllBookAndGenre();
		for(Book b:bookList){
			System.out.println(b);
		}
		//Book book1 = bookMapper.getBookAndGenreById(1);
		//System.out.println(book1);
		//查找 类别 下的书
		Genre gen = genreMapper.getGenreAndAllBookById(1);
//		System.out.println(gen);
		List<Book> books = gen.getBooks();
		for(Book b:books){
			//System.out.println(b);
		}
		Student stuLeadBookByStuId = studentMapper.getStuLeadBookByStuId(1);
		List<Lead> lends = stuLeadBookByStuId.getLends();
		int count=0;
		StuLeadInfo sli=new StuLeadInfo();
		for(Lead l:lends){
			// System.out.println(l);
			 //System.out.println(l.getBook().getBookAuthor());
		}
		//System.out.println(count);
	}
	@Test
	public void test(){
		List<Admin> Admins = adminMapper.selectByExample(null);
		for(Admin a:Admins){
			//System.out.println(a);
		}
		List<Student> allStus = studentService.getAllStus();
		for(Student s:allStus){
			//System.out.println(s);
		}
		//Student stu=new Student(null, "小邓", "1", "xd@xd.com","0", "xxxddd", "123456");
		//studentMapper.insertSelective(stu);
		leadMapper.resultBook(1, "0");
	}
	@Test
	public void test5(){
		//PageHelper.startPage(1, 3);
		List<Book> books = bookMapper.getBookByBook_Genre(1);
		for(Book b:books){
			System.out.println(b);
		}
	}
	@Test
	public void testAddBook(){
		BookMapper bm=sqlSession.getMapper(BookMapper.class);
		for(int i=18;i<50;i++){
			String name=i+"python";
			System.out.println(name);
			bm.insertSelective(new Book(null, name, name+"描述", "${APP_PATH}/static/images/book/ai.png", "小p"+i, new Date(), 50, 1));
		}
		
	}
	
	@Test
	public void testBook(){
		Book book=new Book(1, "c++设计", "一本c++设计书", "c.png", "小鹏", new Date(), 50, 1);
		//bookMapper.insertSelective(book);
		//查找 所有的书 和类别信息
		List<Book> books = bookMapper.getAllBookAndGenre();
		for(Book b:books){
			System.out.println(b);
		}
		System.out.println(books.size());
		bookMapper.updateByPrimaryKeySelective(book);
		
	}
	@Test
	public void testAdmin(){
		adminMapper.insertSelective(new Admin(null,"张老板", "zadmin", "666666"));
	}
	@Test
	public void testLead(){
		//leadMapper.insertSelective(new Lead(null, 585856,null, "0", 1, 1, null));
		//leadMapper.insertSelective(new Lead(null, 585856,new Date(), "0", 1, 1));
		//借出的书和总借书记录数
//		List<Lead> lends = leadMapper.selectByExample(null);
		List<Lead> lends = leadMapper.getAllLeadBookStuInfo();
		int i=0;
		int h=0;
		for(Lead l:lends){
			if(l.getLendStatus().equals("0")){
				i++;
			}else{
				h++;
			}
		}
		System.out.println("总数"+lends.size());
		System.out.println("待还"+i);
		System.out.println("已还"+h);
		
	}
	@Test
	public void testStu(){
		/*Student stuAllInfo = studentMapper.getStuLeadBookByStuId(1);
		for(Lead l:stuAllInfo.getLends()){
			System.out.println(l);
		}*/
		Student stu=new Student(null, "老张", "0", "lz@lx.com", "0", "lllzzz", "123456");
		stu.setStuPwd(utils.md5(stu.getStuPwd()));
		studentMapper.insertSelective(stu);
		
	}
	
}


