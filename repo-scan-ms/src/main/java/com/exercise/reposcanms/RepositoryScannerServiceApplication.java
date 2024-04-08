package com.exercise.reposcanms;

import com.exercise.reposcanms.model.*;
import com.exercise.reposcanms.model.enums.ScanStatus;
import com.exercise.reposcanms.model.enums.ScanType;
import com.exercise.reposcanms.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class RepositoryScannerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepositoryScannerServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(UserRepo userRepo, WorkspaceRepo workspaceRepo, RepositoryRepo repoRepo, BranchRepo branchRepo, ScanRepo scanRepo) {
        return (args) -> {
            User user1 = userRepo.save(User.builder().username("user1").email("user1@mend.io").build());
            Workspace w1 = workspaceRepo.save(Workspace.builder().name("workspace 1").user(user1).build());
            Workspace w2 = workspaceRepo.save(Workspace.builder().name("workspace 2").user(user1).build());
            Repo r1 = repoRepo.save(Repo.builder().name("repo 1").workspace(w1).build());
            Repo r2 = repoRepo.save(Repo.builder().name("repo 2").workspace(w1).build());
            Repo r3 = repoRepo.save(Repo.builder().name("repo 3").workspace(w2).build());
            Repo r4 = repoRepo.save(Repo.builder().name("repo 4").workspace(w2).build());
            Branch b1 = branchRepo.save(Branch.builder().name("branch 1").repo(r1).build());
            Branch b2 = branchRepo.save(Branch.builder().name("branch 2").repo(r1).build());
            Branch b3 = branchRepo.save(Branch.builder().name("branch 3").repo(r2).build());
			Branch b4 = branchRepo.save(Branch.builder().name("branch 4").repo(r2).build());
			Branch b5 = branchRepo.save(Branch.builder().name("branch 5").repo(r3).build());
			Branch b6 = branchRepo.save(Branch.builder().name("branch 6").repo(r3).build());
			Branch b7 = branchRepo.save(Branch.builder().name("branch 7").repo(r4).build());
			Branch b8 = branchRepo.save(Branch.builder().name("branch 8").repo(r4).build());
			scanRepo.save(Scan.builder().type(ScanType.SCA).branch(b1).status(ScanStatus.COMPLETED)
					.valid(true).issues(0).submissionTime(LocalDateTime.now().minusDays(2)).build());
			scanRepo.save(Scan.builder().type(ScanType.SAST).branch(b2).status(ScanStatus.COMPLETED)
					.valid(false).issues(2).submissionTime(LocalDateTime.now().minusDays(3)).build());
			scanRepo.save(Scan.builder().type(ScanType.RENOVATE).branch(b3).status(ScanStatus.COMPLETED)
					.valid(true).issues(0).submissionTime(LocalDateTime.now().minusDays(1)).build());
			scanRepo.save(Scan.builder().type(ScanType.SCA).branch(b4).status(ScanStatus.COMPLETED)
					.valid(false).issues(1).submissionTime(LocalDateTime.now().minusDays(4)).build());
			scanRepo.save(Scan.builder().type(ScanType.RENOVATE).branch(b5).status(ScanStatus.COMPLETED)
					.valid(true).issues(0).submissionTime(LocalDateTime.now().minusDays(2)).build());
			scanRepo.save(Scan.builder().type(ScanType.SCA).branch(b6).status(ScanStatus.COMPLETED)
					.valid(true).issues(0).submissionTime(LocalDateTime.now().minusDays(1)).build());
			scanRepo.save(Scan.builder().type(ScanType.SAST).branch(b7).status(ScanStatus.COMPLETED)
					.valid(false).issues(3).submissionTime(LocalDateTime.now().minusDays(5)).build());
			scanRepo.save(Scan.builder().type(ScanType.RENOVATE).branch(b8).status(ScanStatus.COMPLETED)
					.valid(true).issues(0).submissionTime(LocalDateTime.now().minusDays(4)).build());
			scanRepo.save(Scan.builder().type(ScanType.RENOVATE).branch(b1).status(ScanStatus.PENDING)
					.valid(true).issues(0).submissionTime(LocalDateTime.now().minusDays(4)).build());
			scanRepo.save(Scan.builder().type(ScanType.SAST).branch(b2).status(ScanStatus.COMPLETED)
					.valid(false).issues(2).submissionTime(LocalDateTime.now().minusDays(1)).build());
			scanRepo.save(Scan.builder().type(ScanType.SCA).branch(b3).status(ScanStatus.PENDING)
					.valid(true).issues(0).submissionTime(LocalDateTime.now().minusDays(3)).build());
			scanRepo.save(Scan.builder().type(ScanType.RENOVATE).branch(b4).status(ScanStatus.COMPLETED)
					.valid(false).issues(3).submissionTime(LocalDateTime.now().minusDays(2)).build());
			scanRepo.save(Scan.builder().type(ScanType.SAST).branch(b5).status(ScanStatus.COMPLETED)
					.valid(false).issues(4).submissionTime(LocalDateTime.now().minusDays(3)).build());
			scanRepo.save(Scan.builder().type(ScanType.SCA).branch(b6).status(ScanStatus.COMPLETED)
					.valid(true).issues(0).submissionTime(LocalDateTime.now().minusDays(2)).build());
			scanRepo.save(Scan.builder().type(ScanType.RENOVATE).branch(b7).status(ScanStatus.COMPLETED)
					.valid(false).issues(1).submissionTime(LocalDateTime.now().minusDays(1)).build());
			scanRepo.save(Scan.builder().type(ScanType.SAST).branch(b8).status(ScanStatus.COMPLETED)
					.valid(true).issues(0).submissionTime(LocalDateTime.now().minusDays(5)).build());
        };
    }
}
