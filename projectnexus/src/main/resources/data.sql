-- Insert default roles
INSERT INTO roles (name, created_at, updated_at)
VALUES
('ROLE_ADMIN', NOW(), NOW()),
('ROLE_PROJECT_MANAGER', NOW(), NOW()),
('ROLE_TEAM_MEMBER', NOW(), NOW())
ON CONFLICT DO NOTHING;

-- Create admin user (password: admin123)
INSERT INTO users (username, email, password, first_name, last_name, status, created_at, updated_at)
VALUES
('admin', 'admin@projectnexus.com', '$2a$10$rDkPvvAFV8kqwvKJzwlRv.i.q.wz1w1pz0bFX5qpV6L3.FdRSj/72', 'System', 'Administrator', 'ACTIVE', NOW(), NOW())
ON CONFLICT DO NOTHING;

-- Assign admin role to admin user
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u, roles r
WHERE u.username = 'admin' AND r.name = 'ROLE_ADMIN'
ON CONFLICT DO NOTHING;