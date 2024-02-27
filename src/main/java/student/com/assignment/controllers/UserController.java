package student.com.assignment.controllers;


import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletResponse;
import student.com.assignment.models.StudentData;
import student.com.assignment.models.UserRepository;


@Controller
public class UserController
{
   @Autowired
   private UserRepository userRepo;

  
   @GetMapping("/student/view")
   public String getAllUsers(Model model)
   {
    System.out.println("Getting all users");
    List<StudentData> user = userRepo.findAll();
    model.addAttribute("us", user);
    return "student/showAll";
   }

   @PostMapping("/student/add")
   public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response)
   {
    System.out.println("Add user");
    String newFirst = newuser.get("firstname");
    String newLast = newuser.get("lastname");
    int newWeight = Integer.parseInt(newuser.get("weight"));
    int newHeight = Integer.parseInt(newuser.get("height"));
    String newhair = newuser.get("haircolor");
    float newGPA = Float.parseFloat(newuser.get("gpa"));
    userRepo.save(new StudentData(newFirst,newLast,newWeight,newHeight,newhair,newGPA));
    response.setStatus(201);
    return "redirect:/redirect.html";

   }

 
    
   @PostMapping("/student/remove")
   public String removeUser(@RequestParam Map<String, String> userid, HttpServletResponse response) {
    System.out.println("Remove user");
    String oldFirst = userid.get("firstname");
    String oldLast = userid.get("lastname");

    // Find the user by first name and last name
    List<StudentData> usersToDelete = userRepo.findByFirstnameAndLastname(oldFirst, oldLast);
   
    // Check if the user exists
    if (!usersToDelete.isEmpty()) {
        // Since you're expecting a single user, you can use the first one
        StudentData userToDelete = usersToDelete.get(0);

        // Delete the user
        userRepo.delete(userToDelete);

        response.setStatus(200); // OK
        return "redirect:/redirect.html";
    } else {
        response.setStatus(404); // Not Found
        return "redirect:/fail.html";
    }
}

@GetMapping("/student/list")
public String values(Model model) // get the data from the button then using it make a change value page
{
 System.out.println("Getting all users");
 List<StudentData> user = userRepo.findAll();
 model.addAttribute("us", user);
 return "student/change";
}



@PostMapping("/student/lists")
public String updateUser(@ModelAttribute StudentData student) {
    // Use save method directly - it handles both insert and update
    userRepo.save(student);

    return "redirect:/redirect.html";
}




 
}

