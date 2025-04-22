CREATE TABLE messages (
	message_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	content VARCHAR(255) NOT NULL,
	created_at TIMESTAMP,
	updated_at TIMESTAMP
);