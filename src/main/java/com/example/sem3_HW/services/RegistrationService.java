package com.example.sem3_HW.services;

import com.example.sem3_HW.domain.User;
import com.example.sem3_HW.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    //  поял юзер сервиз, нотификат
    //добавить метод процесс регистрэйшн
    /*Создать сервис "RegistrationService", который принимает на вход данные о
пользователе (имя, возраст, email), создает пользователя с помощью
UserService, затем использует DataProcessingService для добавления
пользователя в список и выполнения операций над этим списком. После
выполнения каждой операции, использовать NotificationService для вывода
информации о выполненной операции.*/

    private UserService userService;
    private DataProcessingServise dataProcessingServise;

    private NotificationService notificationService;


    public DataProcessingServise getDataProcessingServise(){
        return dataProcessingServise;

    }

    public RegistrationService(UserService userService, DataProcessingServise dataProcessingServise, NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingServise = dataProcessingServise;
        this.notificationService = notificationService;
    }

    public void registration(String name, int age, String email) {
        User user = userService.createUser(name,age, email);
        dataProcessingServise.addUserToList(user);
        notificationService.notifyUser(user);

    }


}
