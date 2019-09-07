INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('mclient', '$2a$10$mZlYEciS6Sxu.tZCMhpARuKD3RwtDu5R4ikN6behMrNNI0gfWPIi.', 'read,write',
    'password,authorization_code,refresh_token,client_credentials', null, null, 36000, 360000, null, true);