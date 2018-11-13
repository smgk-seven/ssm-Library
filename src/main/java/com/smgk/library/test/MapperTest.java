package com.smgk.library.test;

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
import com.smgk.library.dao.LeadMapper;
import com.smgk.library.dao.StudentMapper;
import com.smgk.library.service.AdminService;
import com.smgk.library.service.StudentService;
import com.smgk.library.dao.GenreMapper;

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
		Book book = bookMapper.selectByPrimaryKey(1);
		//System.out.println(book);
		List<Lead> leadList = leadMapper.getAllLeadBookStuInfo();
		for(Lead l:leadList){
			//System.out.println(l);
		}
		//查找 所有的书 书和 他的类别 的信息
		List<Book> bookList = bookMapper.getAllBookAndGenre();
		for(Book b:bookList){
			//System.out.println(b);
		}
		Book book1 = bookMapper.getBookAndGenreById(1);
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
			 System.out.println(l);
			 System.out.println(l.getBook().getBookAuthor());
		}
		System.out.println(count);
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
		Student stu=new Student(null, "小邓", "1", "xd@xd.com","0", "xxxddd", "123456");
		studentMapper.insertSelective(stu);
		
	}
	
	
	
}
