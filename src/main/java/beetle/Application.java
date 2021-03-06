package beetle;

import beetle.Entities.Security.CustomUser;
import beetle.Entities.Security.UserRole;
import beetle.Entities.Security.UserRoleEnum;
import beetle.Services.SecurityService;
import beetle.Services.UserRoleService;
import beetle.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
    @Bean
    public CommandLineRunner addToList (final UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                 for (int i = 0; i <= 27; i++) {
                     userService.addAllId();
                }
            }
        };
    }
/*
    @Bean
    public CommandLineRunner secur(final UserRoleService userRoleService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                userRoleService.addUserRole(new UserRole(UserRoleEnum.ADMIN));
                userRoleService.addUserRole(new UserRole(UserRoleEnum.USER));
            }
        };
    }


    @Bean
    public CommandLineRunner securTwo(final SecurityService securityService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                securityService.addUser(new CustomUser("admin","admin", new UserRole(UserRoleEnum.ADMIN)));
            }
        };
    }*/
}
