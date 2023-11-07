# Users_CommentManagement

This is an application which deals with the users and their comments database.
 * This is the main application class from where the application starts to run.
 * It has two tables in the database :
 * 1. users_api : (u_id,commentFrom,commentTo)
 * 2. comment: (c_id, message, date, postedByUserId[foreign key])
 * 
 * I have created two API's :
 * 1. To add user with their message.
 * 2. To get All the message given to a particular user.
 * 
 * 
 * I have Covered all the validation checks on Name, Date , etc. 
