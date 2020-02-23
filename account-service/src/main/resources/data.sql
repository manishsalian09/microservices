insert into wf_policy (active, created_by, created_on, json, policy_description, policy_name, policy_type, policy_id) values (true, 1, now(), null, 'This policy has full access rights', 'Admin', 'Administrator', 1);
insert into wf_role (created_by, created_on, enabled, role_name, role_id) values (1, now(), true, 'AdministratorRole', 1);
insert into wf_role_policy (role_id, policy_id) values (1, 1);
insert into wf_account (active, created_by, created_on, first_name, last_login_date, last_name, locked, login_attempts, middle_name, password, user_id, account_id, temporary_password, email_id) values (true, 1, now(), 'Root', null, 'Administrator', false, 0, null, '$2a$10$0IpkBhLJ3TW1AC9gq5/WXOrznjJmYSm2JMTLrgjaZI/8aPAHzL0aW', 'root', 1, null, 'manishsalian9@gmail.com');
insert into wf_account_role (account_id, role_id) values (1, 1);
insert into wf_group (created_by, created_on, enabled, group_description, group_name, group_id) values (1, now(), true, 'Developer group', 'Developers', 1);
insert into wf_account_group (account_id, group_id) values (1, 1);