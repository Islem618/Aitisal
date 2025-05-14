-- À placer dans src/test/resources/
INSERT INTO users (id, username, email) VALUES
                                            ('usr1', 'testUser1', 'test1@email.com'),
                                            ('usr2', 'testUser2', 'test2@email.com');

INSERT INTO posts (id, author_id, content) VALUES
                                               ('post1', 'usr1', 'Premier post de test'),
                                               ('post2', 'usr2', 'Deuxième post de test');