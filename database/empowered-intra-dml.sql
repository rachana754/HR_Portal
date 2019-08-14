-- Dumping data for table hr-portal.profile:
DELETE FROM `profile`;

-- Insert values into Profile table
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `username`, `email`, `password`) VALUES
    (1, 'User', 'Test', 'userTest', 'userTest@email.com', '7PLnXTFWzvGjn7Uk3gwEji8jLtOxZ5w9dAxL3Eo/Z3Y=$bWcNljX8ZqeIQ6UqpGvNv+SqA0p6Wj/JUX4SbjBks6s='),
    (2, 'User2', 'Test2', 'userTest2', 'user2@email.com', 'rKWHTS1kTilXA+B48/vkLTxrIf9KPKfRmbHdamb6K4Q=$FLaPwiRjy9HzGYrV5ygJ1RInHbRdKOVXrPYRd7s2Bv8='),
    (3, 'User3', 'Test3', 'userTest3', 'user3@email.com', 'm3mCDaF0J5efq/BvU0F18qBGCyNZCimK0QzMTC4OyPE=$aXDuL+EeNGJm9DZVMzsrZfFhS9PtO6Om4BjYBWKFaLA='),
    (4, 'User4', 'Test4', 'userTest4', 'user4@email.com', 'PzkcrmvfevKSEedM2tc0dNpLEGVfqTMeBC1NIGrnmw8=$BpYSWfSiDcngEsPqW3kuVoFMXf2SDiwOhXfcAs4WkVA='),
    (5, 'User5', 'Test5', 'userTest5', 'user5@email.com', '53VTUs6aOnADu7J7XprmGjogtva3kr4KQB5JrpYD17o=$E/jRVDFW6FlVo7Y8GxOOBqsWu11526GT+RZqR2Qz+nw=');

 
-- Inserting values into Alert Table
INSERT INTO `alert` (`subject`, `description`, `create_date`, `last_modified_date`, `is_active`) VALUES 
         ('BUILDING IS OUT OF WATER', 'We\'re thirsty.', '2019-07-26 13:59:39', '2019-07-26 13:59:40', '1'),
         ('BUILDING IS OUT OF FOOD', 'We\'re hungry.', '2019-07-26 13:59:39', '2019-07-26 13:59:40', '1'),
         ('BUILDING IS OUT OF CODE', 'We\'re fired.', '2019-07-26 13:59:39', '2019-07-26 13:59:40', '1');


-- Inserting values into Announcement Table
INSERT INTO `announcement` (`id`,`subject`, `description`,`color`,`is_active`, `create_date`, `last_modified_date`,`delete_date`) VALUES 
         (1,'Welcome to Empowered', 'What happens when you pair transformative technology with human empathy? You get solutions that work the way people do. Empowered\'s human-focused approach to software began nearly two decades ago. ','PURPLE','1', '2019-07-31 16:42:10', '2019-07-31 16:42:12', '2019-07-31 16:42:13'),
         (2,'9th Floor Restroom', 'Hello Team, The 9th floor restrooms have reopened. Seat covers have not been restocked as they must be ordered in a new size.Thank you for your patience during the remodel', 'ORANGE', '1', '2019-07-31 16:44:30', '2019-07-31 16:44:28', '2019-07-31 16:44:31'),
         (3,'Food Truck Schedule: August + The Dumpling Lady starting 8/15!', 'I\'m excited! You\'re going to be excited! The new Food Truck line up we have for you is Bonkers. We have 6 new food trucks. We have something for everyone this month. Please show all your support for our Food Truck vendors who so lovingly prepare some of the best food in Charlotte and they bring it right here, to our doorstep! If some of your favorites are gone, no worries they may be back for the next cycle.', 'BLUE', '1', '2019-07-31 16:46:18','2019-07-31 16:46:19','2019-07-31 16:46:20');


-- Add Config
INSERT INTO `hr-portal`.`config_specification` (`name`, `data_type`, `default_value`) VALUES 
    ('home.tell_hr.allowed_subjects', 'LIST_STRING', 'Benefits,Request,Complaint,Suggestion,Other'),
    ('home.tell_hr.display', 'BOOLEAN', 'true');