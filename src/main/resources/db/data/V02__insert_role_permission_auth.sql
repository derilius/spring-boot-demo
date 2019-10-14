INSERT INTO auth.roles(id, name) VALUES
       (1, 'USER'),
       (2, 'ADMIN');

INSERT INTO auth.permissions(id, group_name, name, permission) VALUES
       (1, 'SYSTEM', 'USER', 'ROLE_USER'),
       (2, 'SYSTEM', 'ADMIN', 'ROLE_ADMIN');

INSERT INTO auth.role2permission(id, permission_id, role_id) VALUES
       (1, 1, 1),
       (2, 2, 2);
