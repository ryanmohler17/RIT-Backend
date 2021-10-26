/*	status_action table	*/
CREATE TABLE status_action(
	status_id SERIAL PRIMARY KEY NOT NULL,
	status_name VARCHAR(15) NOT NULL
);

/*	users table	*/
CREATE TABLE users(
	user_id SERIAL PRIMARY KEY NOT NULL,
	user_username VARCHAR(25) UNIQUE NOT NULL,
	user_password VARCHAR(25) NOT NULL,
	email VARCHAR(75) UNIQUE NOT NULL,
	avatar VARCHAR(30),
	user_level VARCHAR(15)
);

/*	issues table	*/
CREATE TABLE issues(
	issue_id SERIAL PRIMARY KEY NOT NULL,
	issue_title VARCHAR(250) NOT NULL,
	issue_description VARCHAR(250) NOT NULL,
	issue_creator INTEGER REFERENCES users(user_id) NOT NULL,
	issue_category VARCHAR(25) NOT NULL,
	issue_severity VARCHAR(25) NOT NULL,
	issue_status VARCHAR(25) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/*	issues_labels table	*/
CREATE TABLE issues_labels(
	issue_label_id SERIAL PRIMARY KEY NOT NULL,
	issue_id_fk INTEGER REFERENCES issues(issue_id) NOT NULL,
	issue_label VARCHAR(20) NULL
);

/*	actions table	*/
CREATE TABLE actions(
	action_id SERIAL PRIMARY KEY NOT NULL,
	action_name VARCHAR(250)
);

/*	issues_action table	*/
CREATE TABLE issues_action(
	issue_action_id SERIAL PRIMARY KEY NOT NULL,
	user_id_fk INTEGER REFERENCES users(user_id) NOT NULL,
	issue_id_fk INTEGER REFERENCES issues(issue_id) NOT NULL,
	action_type VARCHAR(250),
	done_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/*	comment_action table	*/
CREATE TABLE comments_action(
	comment_id SERIAL PRIMARY KEY NOT NULL,
	comment_action VARCHAR(250) NOT NULL,
	reply_to INTEGER REFERENCES comments_action(comment_id) NULL,
	issue_action_id_fk INTEGER REFERENCES issues_action(issue_action_id) NOT NULL
);

/*	board table	*/
CREATE TABLE board(
	board_id SERIAL PRIMARY KEY NOT NULL,
	board_title VARCHAR(250) NOT NULL,
	description VARCHAR(250) NOT NULL,
	user_id_fk INTEGER REFERENCES users(user_id) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/*	board_users table	*/
CREATE TABLE board_users(
	board_user_id SERIAL PRIMARY KEY NOT NULL,
	board_id_fk INTEGER REFERENCES board(board_id) NOT NULL,
	user_id_fk INTEGER REFERENCES users(user_id) NOT NULL
);

/*	board_list table	*/
CREATE TABLE board_list(
	board_list_id SERIAL PRIMARY KEY NOT NULL,
	title VARCHAR(250) NOT NULL,
	board_id_fk INTEGER REFERENCES board(board_id) NOT NULL
);

/*	list_items table	*/
CREATE TABLE list_items(
	list_item_id SERIAL PRIMARY KEY NOT NULL,
	issue_id_fk INTEGER REFERENCES issues(issue_id) NOT NULL,
	board_list_id_fk INTEGER REFERENCES board_list(board_list_id) NOT NULL
);