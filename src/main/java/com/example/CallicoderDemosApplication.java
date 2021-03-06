package com.example;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import com.example.model.elementCollection.Child;
import com.example.model.elementCollection.ChildAddress;
import com.example.repository.BeerRepository;
import com.example.repository.ChildRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.PostM2MRepository;
import com.example.repository.StudentRepository;
import com.example.repository.TagRepository;

@SpringBootApplication
@EnableJpaAuditing
public class CallicoderDemosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallicoderDemosApplication.class, args);
	}

}

@Component
class BeerCmdRunner implements CommandLineRunner{

	private final BeerRepository repository;
	
/*    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;*/
	
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostM2MRepository postRepository;
    
    @Autowired
    private StudentRepository studentRepo;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    ChildRepository userRepository;
	
	public BeerCmdRunner(BeerRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*Stream.of("Cerner India","Cerner KC","Cerner Kolkata").forEach(
				name->repository.save(new Beer(name)));
		repository.findAll().forEach(System.out::println);
		
	      // Clean up database tables
        userProfileRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();

        //=========================================

        // Create a User instance
        User user = new User("Rajeev", "Singh", "rajeev@callicoder.com",
                "MY_SUPER_SECRET_PASSWORD");

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);

        // Create a UserProfile instance
        UserProfile userProfile = new UserProfile("+91-8197882053", Gender.MALE, dateOfBirth.getTime(),
                "747", "2nd Cross", "Golf View Road, Kodihalli", "Bangalore",
                "Karnataka", "India", "560008");


        // Set child reference(userProfile) in parent entity(user)
        user.setUserProfile(userProfile);

        // Set parent reference(user) in child entity(userProfile)
        userProfile.setUser(user);

        // Save Parent Reference (which will save the child as well)
        userRepository.save(user);

        //=========================================
*/	
		/*postRepository.deleteAllInBatch();
        tagRepository.deleteAllInBatch();*/

        // =======================================

        // Create a Post
       /* PostM2M post = new PostM2M("Hibernate Many to Many Example with Spring Boot",
                "Learn how to map a many to many relationship using hibernate",
                "Entire Post content with Sample code");

        // Create two tags
        Tag tag1 = new Tag("Spring Boot");
        Tag tag2 = new Tag("Hibernate");


        // Add tag references in the post
        post.getTags().add(tag1);
        post.getTags().add(tag2);

        // Add post reference in the tags
        tag1.getPostM2Ms().add(post);
        tag2.getPostM2Ms().add(post);

        postRepository.save(post);*/
		
		/*studentRepo.deleteAllInBatch();

        // Insert a new user in the database
        Name name = new Name("Rajeev", "Kumar", "Singh");
        Address address = new Address("747", "Golf View Road", "Bangalore", "Karnataka", "India", "560008");
        Student stu = new Student(name, "rajeev@callicoder.com", address);

        studentRepo.save(stu);
	*/
		
		  // Cleanup employees table
        /*employeeRepository.deleteAllInBatch();

        // Insert a new Employee in the database
        Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"),
                "Rajeev Kumar Singh",
                "rajeev@callicoder.com",
                "+91-9999999999");

        employeeRepository.save(employee);*/
		
		/*System.out.println(employeeRepository.findById(new EmployeeIdentity("E-123", "D-457")));
		System.out.println(employeeRepository.findByEmployeeIdentityCompanyId("D-457"));*/
		
        // Cleanup database tables.
        userRepository.deleteAll();

        // Insert a user with multiple phone numbers and addresses.
        Set<String> phoneNumbers = new HashSet<>();
        phoneNumbers.add("+91-9999999999");
        phoneNumbers.add("+91-9898989898");

        Set<ChildAddress> addresses = new HashSet<>();
        addresses.add(new ChildAddress("747", "Golf View Road", "Bangalore",
                "Karnataka", "India", "560008"));
        addresses.add(new ChildAddress("Plot No 44", "Electronic City", "Bangalore",
                "Karnataka", "India", "560001"));

        Child user = new Child("Rajeev Kumar Singh", "rajeev@callicoder.com",
                phoneNumbers, addresses);

        userRepository.save(user);
	}
}
