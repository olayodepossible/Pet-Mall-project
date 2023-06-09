
-- USER --
INSERT IGNORE INTO users (user_type, id, username, first_name, last_name, email, password, address, city, country, privilege, designation, profile_image, speciality)
VALUES ("customer", 1, "Joe204", "Joe", "Mark", "joe@gmail.com", "12345", "22, MacLaure Street", "LA", "USA", "ROLE_USER", "CUSTOMER", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85", null);

INSERT IGNORE INTO users (user_type, id, username, first_name, last_name, email, password, address, city, country, privilege, designation, profile_image, speciality)
VALUES ("customer", 2, "Doe204", "Doe", "Park", "doe@gmail.com", "12345", "25, MacLaure Street", "Atlanta", "USA", "ROLE_USER", "CUSTOMER", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85", null);

INSERT IGNORE INTO users (user_type, id, username, first_name, last_name, email, password, address, city, country, privilege, designation, profile_image, speciality)
VALUES ("customer", 3, "Toe204", "Toe", "Clark", "toe@gmail.com", "12345", "32, MacLaure Street", "CA", "USA", "ROLE_USER", "CUSTOMER", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85", null);

INSERT IGNORE INTO users (user_type, id, username, first_name, last_name, email, password, address, city, country, privilege, designation, profile_image, speciality)
VALUES ("customer", 4, "Zoe204", "Zoe", "Jark", "zoe@gmail.com", "12345", "52, MacLaure Street", "LA", "USA", "ROLE_USER", "CUSTOMER", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85", null);

INSERT IGNORE INTO users (user_type, id, username, first_name, last_name, email, password, address, city, country, privilege, designation, profile_image, speciality)
VALUES ("vet", 5, "Coe204", "Coe", "Blark", "coe@gmail.com", "12345", "3, Plane Street", "CA", "USA", "ROLE_VET_ADMIN", "VET", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85", "Dentistry");

INSERT IGNORE INTO users (user_type, id, username, first_name, last_name, email, password, address, city, country, privilege, designation, profile_image, speciality)
VALUES ("vet", 6, "Boe20", "Boe", "Park", "boe@gmail.com", "12345", "5, Laure Street", "Texas", "USA", "ROLE_VET_ADMIN", "VET", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85", "Doctor");

INSERT IGNORE INTO users (user_type, id, username, first_name, last_name, email, password, address, city, country, privilege, designation, profile_image, speciality)
VALUES ("store_owner", 7, "Paul204", "Paul", "Clark", "paul@gmail.com", "12345", "32, MacLaure Street", "CA", "USA", "ROLE_STORE_ADMIN", "STORE_OWNER", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85", null);

INSERT IGNORE INTO users (user_type, id, username, first_name, last_name, email, password, address, city, country, privilege, designation, profile_image, speciality)
VALUES ("store_owner", 8, "Peter204", "Peter", "Jark", "peter@gmail.com", "12345", "52, MacLaure Street", "LA", "USA", "ROLE_STORE_ADMIN", "STORE_OWNER", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85", null);

INSERT IGNORE INTO users (user_type, id, username, first_name, last_name, email, password, address, city, country, privilege, designation, profile_image, speciality)
VALUES ("admin", 9, "Pete204", "Pete", "Klark", "pete@gmail.com", "12345", "52, MacLaure Street", "LA", "USA", "ROLE_ADMIN", "ADMIN", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85", null);

-- PET --

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 1, "Mou", "Female", 20, "Nice look","https://images.dog.ceo/breeds/dachshund/dog-1018408_640.jpg", 0, "BULLDOG", 1, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 2, "Badoo", "Male", 20, "Get acquaintance","https://images.dog.ceo/breeds/terrier-dandie/n02096437_1793.jpg", 0, "GERMAN_SHEPHERD", 2, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 3, "Luckk", "Male", 20, "Nice to have","https://images.dog.ceo/breeds/hound-english/n02089973_4359.jpg", 0, "PIT_BULL", 3, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 4, "Blace", "Male", 20, "Nice look","https://images.dog.ceo/breeds/schnauzer-miniature/n02097047_4018.jpg", 0, "COCKER_SPANIEL", 4, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 5, "Lace", "Male", 20, "Nice look","https://images.dog.ceo/breeds/havanese/00100trPORTRAIT_00100_BURST20191112123933390_COVER.jpg", 100, "HUSKY", 7, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 6, "Brace", "Female", 20, "Robot look","https://images.dog.ceo/breeds/leonberg/n02111129_3675.jpg", 150, "BORDER_COLLIE", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 7, "Pace", "Male", 20, "Nice Pretty", "https://images.dog.ceo/breeds/terrier-norwich/n02094258_257.jpg", 200, "POODLE", 7, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("cat", 8, "Ace Parrot", "Male", 20, "Nice look","https://www.cdc.gov/importation/images/cat.jpg?_=18560", 150, "PERSIAN", 7, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("cat", 9, "Snowy", "Male", 20, "Pretty look","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShzt3IYxgnU1D9hJ8OZMZy8KqJLcPZpOT9-6HEfM1ZiEbahAn0h3oCN9Pl8_TowMZZpiY&usqp=CAU", 100, "SCOTTISH_FOLD", 7, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 10, "Jack", "Female", 20, "Get acquaintance","https://images.dog.ceo/breeds/keeshond/n02112350_7038.jpg", 250, "GERMAN_SHEPHERD", 7, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 11, "Kace", "Female", 20, "Check it out","https://images.dog.ceo/breeds/saluki/n02091831_7665.jpg", 100, "BULLDOG", 7, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("parrot", 12, "Omlet", "Male", 20, "Nice look","https://t4.ftcdn.net/jpg/02/21/13/63/360_F_221136309_xOE9WXNjjQwFlY8xx9llZcq0ozo1Mtd9.jpg", 100, "GREY", 7, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("parrot", 13, "Pexels", "Male", 20, "Nice look","https://www.aejames.com/wp-content/uploads/2019/01/Parrot-Care.jpg", 150, "MOLUCCAN", 7, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 14, "Mace", "Male", 20, "Get acquaintance","https://images.dog.ceo/breeds/cotondetulear/100_2397.jpg", 200, "BEAGLE", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 15, "Jagua", "Male", 20, "Nice look","https://images.dog.ceo/breeds/pointer-germanlonghair/hans1.jpg", 200, "BEAGLE", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 16, "Lance", "Female", 20, "What a friend","https://images.dog.ceo/breeds/sheepdog-shetland/n02105855_7161.jpg", 150, "PIT_BULL", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 17, "Mace", "Male", 20, "Get acquaintance","https://images.dog.ceo/breeds/cotondetulear/100_2397.jpg", 200, "BEAGLE", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("parrot", 18, "Britannica", "Male", 20, "Nice look","https://images.unsplash.com/photo-1552728089-57bdde30beb3?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGFycm90fGVufDB8fDB8fHww&w=1000&q=80", 200, "BUDGIE", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("parrot", 19, "Vecteezy", "Male", 20, "Nice look","https://www.shutterstock.com/image-photo/awesome-new-tia-beautiful-picture-260nw-2292031823.jpg", 200, "CAROLINA_PARAKEET", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("cat", 20, "Blacey", "Male", 20, "Get acquaintance","https://static.standard.co.uk/2021/06/07/12/erik-jan-leusink-IbPxGLgJiMI-unsplash.jpg?width=968&auto=webp&quality=50&crop=968%3A645%2Csmart", 200, "SIBERIAN", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("cat", 21, "Blurry", "Male", 20, "Get acquaintance", "https://static.toiimg.com/thumb/resizemode-4,width-1200,height-900,msid-72295960/72295960.jpg", 150, "SPHYNX", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 22, "Hannah", "Male", 20, "Get acquaintance", "https://images.dog.ceo/breeds/germanshepherd/Hannah.jpg", 250, "SPHYNX", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 23, "Alsatian", "Male", 20, "Get acquaintance", "https://images.dog.ceo/breeds/germanshepherd/KSYR_German-Shepherd-dog-Alsatian.jpg", 350, "SPHYNX", 8, null);

INSERT IGNORE INTO pets (pet_type, id, name, gender, age, description, image_url, price, breed, user_id, vet_id)
VALUES ("dog", 24, "KSYR-German_Shepherd", "Male", 20, "Get acquaintance", "https://images.dog.ceo/breeds/germanshepherd/KSYR_German_Sheperd.jpg", 450, "SPHYNX", 7, null);

-- STORE --
INSERT IGNORE INTO stores ( id, name, address, city, country, owner_id )
VALUES ( 1, "McLaurel Pet Store", "22, MacLaure Street", "LA", "USA", 7);

INSERT IGNORE INTO stores ( id, name, address, city, country, owner_id )
VALUES ( 2, "Pete Pet Store", "52, MacLaure Street", "LA", "USA", 8);



