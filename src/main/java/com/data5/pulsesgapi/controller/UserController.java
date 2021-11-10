package com.data5.pulsesgapi.controller;

import com.data5.pulsesgapi.model.User;
import com.data5.pulsesgapi.repository.UserRepository;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Task", tags = {"tasks"})
@RestController
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;


    @ApiOperation(value="getUsersList")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="Authorization", required = false, dataType = "string", value="descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "-0: Success", response=User.class)
    })
    @GetMapping("v1/users")
    public List<User> getUsers() {
        return userRepository.findAllByEmailLike("%5datainc.com");
    }

    @ApiOperation(value="CreateUser")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="Authorization", required = false, dataType = "string", value="descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "-0: Success", response=User.class)
    })
    @PostMapping("v1/create")
    public void createUser(@ApiParam(value = "user data", required = true) @RequestBody User user) {
//        User u1 = createUser("user::0004", "Vijay", "kesanu", "vijaya.say@5datainc.com", "Who can we get on the case?");
//        userRepository.save(u1);
//        User u2 = createUser("user::0005", "Vijay123", "TestLastname", "major.tom@5datainc.com", "Send me up a drink");
//        userRepository.save(u2);
//        User u3 = createUser("user::0006", "Vijay456", "Wasaracecardriver", "jerry.wasaracecardriver@5datainc.com", "el sob number one");
//        userRepository.save(u3);

        userRepository.save(user);
    }

    private User createUser(String id, String firstName, String lastName,
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
