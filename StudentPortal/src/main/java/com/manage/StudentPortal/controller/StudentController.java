package com.manage.StudentPortal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manage.StudentPortal.model.Student;
import com.manage.StudentPortal.model.StudentSolr;
import com.manage.StudentPortal.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentser;
	
	@Autowired
	private SolrController solrrepo;
	
	
	
	 
	
	
	
	@GetMapping("/viewAll")
    public String viewHomePage(Model model) {
        List<Student> liststudent = studentser.listAll();//fetching all student data in list
        model.addAttribute("liststudent", liststudent);//adding attribute named="liststudent" to model and giving it list of all data
//       List<Proffesor> listProffesor =profser.listAll();
//       model.addAttribute("listproffesor",listProffesor);
//       model.addAttribute("student",new Student());
        System.out.print("Get / ");
        return "viewAll";
    }
	@GetMapping("/")
	public String homePage(Model model)
	{
		return "index";
	}
	


   
	@RequestMapping(value="/new")
    public String add(Model model) {
    	System.out.println("in new");
        model.addAttribute("student", new Student());
       // model.addAttribute("proffesor", new Proffesor());
        return "new";
    }
	
	@RequestMapping("/findStudent")
	public String find(Model model)
	{
		System.out.println("in new");
        model.addAttribute("student", new Student());
        return "find";
		
	}
 
    
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Student std = studentser.get(id);
        mav.addObject("student", std);
        return mav;
        
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    
    public ModelAndView searchStudentPage(@ModelAttribute("student")  Student std,Model m) {
        ModelAndView mav = new ModelAndView("search");
        
        System.out.print("id valur to search"+std.getStudent_id());
     // List<Student>  studentList=solrrepo.find(std.getStudent_id());
      List<StudentSolr> listbyname=solrrepo.findByName(std.getStudent_name());
//       List<StudentSolr> studentList=new ArrayList<>();
//       redisList.ifPresent(studentList::add);
//       
//       Optional<StudentRedis> redisOptional=studentredis.findById(std.getStudent_id());
//       List<StudentRedis> redisList=new ArrayList<>();
//       redisOptional.ifPresent(redisList::add);
       
//       Optional<StudentRedis> redisList=stdredisser.findById(std.getStudent_id());
//       Optional<Student> redisList=studentser.getRedisById(std.getStudent_id());
//       List<Student> studentList=new ArrayList<>();
   //  java.util.Iterator<StudentSolr> iterator = listbyname.iterator();
//       System.out.println("check point");
//       while(iterator.hasNext())
//       {
//    	   System.out.println(iterator.next());
//    	   
//       }
//       redisList.ifPresent(studentList::add);
      // System.out.print("name"+listbyname.get(0));
//      for (int i=0; i<listbyname.size(); i++){
//    	   System.out.println("Element "+listbyname.get(i));
//    	}
      m.addAttribute("searchList", listbyname);
     //  m.addAttribute("searchList", studentList);
        return mav;
        
    }
    
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
    	studentser.delete(id);
        return "redirect:/";
    }
	
	

    @RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudentAndProffesor(@ModelAttribute("student") Student std)
	{
		//std.setStudent_name(student_name);
    	System.out.println(std.student_name);
    //	System.out.println("proff:"+pf.proffesor_name);
    	//Long s_id = std.getStudent_id();
    	
    	
		studentser.saveStudent(std);
		
		
		
	Long s_id=studentser.getLatestId();
		std.setStudent_id(s_id);
//		System.out.println("s_id"+s_id);
//		pf.setStudent_id(s_id);
//		 profser.saveProf(pf);
		 List<StudentSolr> listsolr=new ArrayList<>();
		 listsolr.add(new StudentSolr(s_id,std.getStudent_name(),std.getFather_name(),std.getLast_name(),std.getAddress(),std.getDept(),std.getRoll_no()));
		 solrrepo.saveStudent(listsolr);
		 return "redirect:/";
		 
		 
	}
//	@RequestMapping(value="/searchStudent",method=RequestMethod.POST)
//	public void search(@ModelAttribute("student") Student std,Model model)
//	{
//		System.out.print("find id"+std.getStudent_id());
//		solrrepo.find(std.getStudent_id());
//		
//		//return "find";
//	}
    @GetMapping(value="studentDetail/{id}")
    public ModelAndView studentDetail(@PathVariable(name="id") Long id,Model model)
    {
    	ModelAndView mav = new ModelAndView("studentDetail");
    	Optional<Student> optList=studentser.getRedisById(id);
    	List<Student> studentList=new ArrayList<>();
    	optList.ifPresent(studentList::add);
    	model.addAttribute("studentList",studentList);
    	return mav;
    	
    	
    }
	public List<Student> showAll()
	{
		return studentser.listAll();
	}
	
	
	

}

