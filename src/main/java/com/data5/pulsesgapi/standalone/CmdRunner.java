package com.data5.pulsesgapi.standalone;

import com.data5.pulsesgapi.document.User;
import com.data5.pulsesgapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CmdRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {
//
//        User u1 = createUser("user::0001", "Vijay", "kesanu", "vijaya.say@5datainc.com", "Who can we get on the case?");
//        userRepository.save(u1);
//
//        User u2 = createUser("user::0002", "TestFirstName", "TestLastname", "major.tom@5datainc.com", "Send me up a drink");
//        userRepository.save(u2);
//
//
//        User u3 = createUser("user::0003", "Jerry", "Wasaracecardriver", "jerry.wasaracecardriver@5datainc.com", "el sob number one");
//        userRepository.save(u3);

        Optional<User> user = userRepository.findById("user::0001");
        System.out.println("User found = "+user.get().getFirstName());

//        List<User> result = userRepository.findAll();
//        System.out.println( "Total of @5datainc.com users = "+result.size()  );
//
//        List<User> result1 = userRepository.findAllByEmail("%datainc");
//        System.out.println( "Total of @5datainc.com users = "+result.size()  );


    }

    public static User createUser(String id, String firstName, String lastName,
                                  String email, String tagLine) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setTagLine(tagLine);
        return user;
    }

}
