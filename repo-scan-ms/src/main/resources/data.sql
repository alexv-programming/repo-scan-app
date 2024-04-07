INSERT INTO users (id, username, email) VALUES (1, 'user1', 'user1@example.com');


-- Insert Workspaces (2 for each User)
INSERT INTO workspaces (id, name, user_id) VALUES (1, 'u1w1', 1);
INSERT INTO workspaces (id, name, user_id) VALUES (2, 'u1w2', 1);


-- Insert Repositories (2 for each Workspace)
INSERT INTO repos (id, name, workspace_id) VALUES (1, 'u1w1r1', 1);
INSERT INTO repos (id, name, workspace_id) VALUES (2, 'u1w1r2', 1);
INSERT INTO repos (id, name, workspace_id) VALUES (3, 'u1w2r1', 2);
INSERT INTO repos (id, name, workspace_id) VALUES (4, 'u1w2r2', 2);


-- Insert 8 Branches for the Repositories
-- For u1w1r1
INSERT INTO branches (id, name, repo_id) VALUES (1, 'u1w1r1b1', 1);
INSERT INTO branches (id, name, repo_id) VALUES (2, 'u1w1r1b2', 1);
-- For u1w1r2
INSERT INTO branches (id, name, repo_id) VALUES (3, 'u1w1r2b1', 2);
INSERT INTO branches (id, name, repo_id) VALUES (4, 'u1w1r2b2', 2);
-- For u1w2r1
INSERT INTO branches (id, name, repo_id) VALUES (5, 'u1w2r1b1', 3);
INSERT INTO branches (id, name, repo_id) VALUES (6, 'u1w2r1b2', 3);
-- For u1w2r2
INSERT INTO branches (id, name, repo_id) VALUES (7, 'u1w2r2b1', 4);
INSERT INTO branches (id, name, repo_id) VALUES (8, 'u1w2r2b2', 4);

-- Insert Scans (16 scans distributed across various branches)
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (1, 2, false, 'SAST', 'COMPLETED', DATEADD(DAY, -3, CURRENT_TIMESTAMP), 1);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (2, 3, false, 'SCA', 'PENDING', DATEADD(DAY, -6, CURRENT_TIMESTAMP), 2);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (3, 1, false, 'RENOVATE', 'COMPLETED', DATEADD(DAY, -2, CURRENT_TIMESTAMP), 1);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (4, 5, false, 'SCA', 'COMPLETED', DATEADD(DAY, -4, CURRENT_TIMESTAMP), 2);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (5, 2, false, 'SAST', 'PENDING', DATEADD(DAY, -1, CURRENT_TIMESTAMP), 3);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (6, 3, false, 'RENOVATE', 'COMPLETED', DATEADD(DAY, -7, CURRENT_TIMESTAMP), 3);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (7, 1, false, 'SCA', 'PENDING', DATEADD(DAY, -5, CURRENT_TIMESTAMP), 4);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (8, 0, true, 'SAST', 'COMPLETED', DATEADD(DAY, -2, CURRENT_TIMESTAMP), 4);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (9, 0, true, 'RENOVATE', 'PENDING', DATEADD(DAY, -9, CURRENT_TIMESTAMP), 5);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (10, 3, false, 'SCA', 'COMPLETED', DATEADD(DAY, -3, CURRENT_TIMESTAMP), 5);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (11, 2, false, 'SAST', 'PENDING', DATEADD(DAY, -8, CURRENT_TIMESTAMP), 6);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (12, 4, false, 'RENOVATE', 'COMPLETED', DATEADD(DAY, -6, CURRENT_TIMESTAMP), 6);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (13, 1, false, 'SCA', 'PENDING', DATEADD(DAY, -10, CURRENT_TIMESTAMP), 7);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (14, 0, true, 'SAST', 'COMPLETED', DATEADD(DAY, -4, CURRENT_TIMESTAMP), 7);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (15, 5, false, 'RENOVATE', 'PENDING', DATEADD(DAY, -7, CURRENT_TIMESTAMP), 8);
INSERT INTO scans (id, issues, valid, type, status, submission_time, branch_id) VALUES (16, 3, false, 'SCA', 'COMPLETED', DATEADD(DAY, -1, CURRENT_TIMESTAMP), 8);
