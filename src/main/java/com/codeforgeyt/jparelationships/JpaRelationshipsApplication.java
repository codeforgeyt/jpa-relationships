package com.codeforgeyt.jparelationships;

import com.codeforgeyt.jparelationships.model.manyToMany.Stream;
import com.codeforgeyt.jparelationships.model.manyToMany.Viewer;
import com.codeforgeyt.jparelationships.model.oneToMany.bidirectional.Cart;
import com.codeforgeyt.jparelationships.model.oneToMany.bidirectional.Item;
import com.codeforgeyt.jparelationships.model.oneToMany.unidirectional.Student;
import com.codeforgeyt.jparelationships.model.oneToMany.unidirectional.University;
import com.codeforgeyt.jparelationships.model.oneToOne.bidirectional.Car;
import com.codeforgeyt.jparelationships.model.oneToOne.bidirectional.Owner;
import com.codeforgeyt.jparelationships.model.oneToOne.unidirectional.Address;
import com.codeforgeyt.jparelationships.model.oneToOne.unidirectional.User;
import com.codeforgeyt.jparelationships.repository.manyToMany.StreamRepository;
import com.codeforgeyt.jparelationships.repository.manyToMany.ViewerRepository;
import com.codeforgeyt.jparelationships.repository.oneToMany.bidirectional.CartRepository;
import com.codeforgeyt.jparelationships.repository.oneToMany.unidirectional.StudentRepository;
import com.codeforgeyt.jparelationships.repository.oneToMany.unidirectional.UniversityRepository;
import com.codeforgeyt.jparelationships.repository.oneToOne.bidirectional.CarRepository;
import com.codeforgeyt.jparelationships.repository.oneToOne.bidirectional.OwnerRepository;
import com.codeforgeyt.jparelationships.repository.oneToOne.unidirectional.AddressRepository;
import com.codeforgeyt.jparelationships.repository.oneToOne.unidirectional.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaRelationshipsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(JpaRelationshipsApplication.class, args);

//        Beans
        CartRepository cartRepository = configurableApplicationContext.getBean(CartRepository.class);
        UniversityRepository universityRepository = configurableApplicationContext.getBean(UniversityRepository.class);
        StudentRepository studentRepository = configurableApplicationContext.getBean(StudentRepository.class);
        UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
        AddressRepository addressRepository = configurableApplicationContext.getBean(AddressRepository.class);
        CarRepository carRepository = configurableApplicationContext.getBean(CarRepository.class);
        OwnerRepository ownerRepository = configurableApplicationContext.getBean(OwnerRepository.class);
        StreamRepository streamRepository = configurableApplicationContext.getBean(StreamRepository.class);
        ViewerRepository viewerRepository = configurableApplicationContext.getBean(ViewerRepository.class);

//        OneToOne Unidirectional
        Address firstAddress = new Address("Home st.");
        User firstUser = new User("John Doe");

        addressRepository.save(firstAddress);
        firstUser.setAddress(firstAddress);
        userRepository.save(firstUser);

//        OneToOne bidirectional
        Car car = new Car("m200");
        Owner owner = new Owner("John Doe");

        carRepository.save(car);
        owner.setCar(car);
        ownerRepository.save(owner);
        car.setOwner(owner);
        carRepository.save(car);
        Iterable<Car> cars = carRepository.findAll();
        System.out.println(cars.iterator().next().getOwner().getName());

//        OneToMany Unidirectional university side
        Student firstStudent = new Student("1111");
        Student secondStudent = new Student("2222");
//        For cascade = CascadeType.ALL do not save or else error will be thrown
        studentRepository.save(firstStudent);
        studentRepository.save(secondStudent);
        List<Student> students = new ArrayList<>();
        students.add(firstStudent);
        students.add(secondStudent);
        University university = new University("UoC");
        university.setStudents(students);
        universityRepository.save(university);
//        Test OrphanRemoval set to true
//        universityRepository.delete(university);

//        OneToMany Bidirectional
        Cart cart = new Cart( "C999");
        Item firstItem = new Item("I333", cart);
        Item secondItem = new Item("I444", cart);
        List<Item> items = Arrays.asList(firstItem, secondItem);
        cart.setItems(items);
        cartRepository.save(cart);

//        ManyToMany
        Viewer johnViewer = new Viewer("John12");
        Viewer willViewer = new Viewer("WillM2");
        Viewer samViewer = new Viewer("MightySam");
        List<Viewer> viewers = Arrays.asList(johnViewer, willViewer, samViewer);

        Stream cookingStream = new Stream("CookingIsAwesome");
        Stream gamingStream = new Stream("ChillGaming");
        List<Stream> streams = Arrays.asList(cookingStream, gamingStream);

        streamRepository.saveAll(streams);

        johnViewer.followStream(cookingStream);
        willViewer.followStream(gamingStream);
        samViewer.followStream(gamingStream);

        viewerRepository.saveAll(viewers);
    }
}
