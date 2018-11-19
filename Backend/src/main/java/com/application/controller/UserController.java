package com.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.pojo.User;
import com.application.pojo.UserLogs;
import com.application.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Test";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestParam String userId,
                        @RequestParam String password,
                        @RequestParam Integer levelOfExpertise) {
        return userService.addUser(userId, password, levelOfExpertise);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/checkIfValidCredentials", method = RequestMethod.GET)
    public Boolean checkIfValidCredentials(@RequestParam String userId,
                                           @RequestParam String password) {
    	LOGGER.info("checking if " + userId + " is a valid user!");
        return userService.checkIfValidCredentials(userId, password);
    }

    @RequestMapping(value = "/logs/addUserLog", method = RequestMethod.POST)
    public UserLogs addUserLog(@RequestParam Integer speed,
                               @RequestParam Integer numberOfWallCollisions,
                               @RequestParam Integer taskNumber,
                               @RequestParam String userId,
                               @RequestParam Boolean isSuccess,
                               @RequestParam Long timeTaken) {
        return userService.addUserLog(speed, numberOfWallCollisions, taskNumber, userId, isSuccess, timeTaken);
    }

    @RequestMapping(value = "/logs/{userId}", method = RequestMethod.GET)
    public List<UserLogs> getUserLogs(@PathVariable("userId") String userId) {
        return userService.getUserLogs(userId);
    }

    @RequestMapping(value = "/getGameSettingsForUser", method = RequestMethod.GET)
    public String getGameSettingsForUser(@RequestParam("userId") String userId) {
        return userService.getGameSettingsForUser(userId).toString();
    }

    @RequestMapping(value = "/stats/getEndOfSceneStats", method = RequestMethod.GET)
    public String getEndOfSceneStats(@RequestParam("userId") String userId,
                                     @RequestParam("taskNumber") Integer taskNumber) {
        return userService.getEndOfSceneStats(userId, taskNumber).toString();
    }

}
