-- This is the database schema that is used to set up the tables and data
-- The application assumes this structure of the DB

-- Drop the tables we will be using if they exists. Allows us to start with a clean slate.

DROP TABLE IF EXISTS 'Users';
DROP TABLE IF EXISTS 'Categories';
DROP TABLE IF EXISTS 'Providers';
DROP TABLE IF EXISTS 'Courses';
DROP TABLE IF EXISTS 'Users_Courses';
DROP TABLE IF EXISTS 'Providers_Courses';

-- Create all necessary tables.

CREATE TABLE 'Users' (
    'id' int NOT NULL AUTO_INCREMENT,
    'firstName' varchar(20) NOT NULL,
    'lastName' varchar(20) NOT NULL,
    'userName' varchar(20) NOT NULL,
    'password' varchar(20) NOT NULL,
    'type' varchar(20) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = MySQL AUTO_INCREMENT=1 DEFAULT CHAR SET= utf8mb4;

CREATE TABLE 'Categories' (
    'id' int NOT NULL,
    'name' varchar(20),
    PRIMARY KEY (id)
) ENGINE = MySQL AUTO_INCREMENT=1 DEFAULT CHAR SET= utf8mb4;

CREATE TABLE 'Providers' (
    'id' int NOT NULL AUTO_INCREMENT,
    'name' varchar(20),
    PRIMARY KEY (id)
) ENGINE = MySQL AUTO_INCREMENT=1 DEFAULT CHAR SET= utf8mb4;

CREATE TABLE 'Courses' (
    'id' int NOT NULL AUTO_INCREMENT,
    'category' int NOT NULL,
    'title' varchar(20) NOT NULL,
    'description' varchar(300) NOT NULL,
    'level' varchar(20) NOT NULL,
    'credits' float NOT NULL,
    'hours' float NOT NULL,
    'certification' varchar(20) NOT NULL,
    'keywords' varchar(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category) REFERENCES categories(id),
    CHECK ( hours > 0 ),
    CHECK (credits >= 0)

) ENGINE = MySQL AUTO_INCREMENT=1 DEFAULT CHAR SET= utf8mb4;

CREATE TABLE 'Users_Courses' (
    'uid' int NOT NULL,
    'cid' int NOT NULL,
    'status' varchar(20),
    'favorite' boolean,
    PRIMARY KEY (uid, cid),
    FOREIGN KEY (uid) REFERENCES users(id),
    FOREIGN KEY (cid) REFERENCES courses(id)

) ENGINE = MySQL AUTO_INCREMENT=1 DEFAULT CHAR SET= utf8mb4;

CREATE TABLE 'Providers_Courses' (
    'pid' int NOT NULL,
    'cid' int NOT NULL,
    'cost' int NOT NULL,
    'currency' varchar(10) NOT NULL,
    PRIMARY KEY (pid, cid),
    FOREIGN KEY (pid) REFERENCES providers(id),
    FOREIGN KEY (cid) REFERENCES courses(id),
    CHECK ( cost >= 0 )

) ENGINE = MySQL AUTO_INCREMENT=1 DEFAULT CHAR SET= utf8mb4;

CREATE TABLE 'CourseSessionTimes'(
    'cid'      int  NOT NULL,
    'start'    Date NOT NULL,
    'end'      Date NOT NULL,
    'location' varchar(20),
    PRIMARY KEY (cid)
)ENGINE = MySQL DEFAULT CHAR SET= utf8mb4;

-- Setup of testing data so that the database will not be empty

INSERT INTO 'Users' VALUES (1, 'Dave', 'Davidson', 'dave', 'Dangerous2024', 'regular'),
                           (2, 'Chuck', 'Truck', 'chuck', 'Nunchucks2024', 'administrator');

INSERT INTO 'Categories' VALUES (1, 'Information Technologies'),
                                (2, 'Digital Marketing'),
                                (3, 'Business and Entrepreneurship'),
                                (4, 'Data Science and Analytics');

INSERT INTO 'Courses' VALUES (1, 1, 'Real-Time Programming in Java',
                            'Description: Embark on a transformative learning experience with our expert-level online course, "Real- Time Programming in Java." Designed for seasoned developers and Java enthusiasts seeking mastery in real-time applications, this advanced course delves deep into the intricacies of leveraging Java for mission-critical systems. Explore cutting-edge concepts such as multithreading, synchronization, and low-latency programming, equipping you with the skills needed to build responsive and robust real-time solutions. Led by industry experts with extensive hands-on experience, this course combines theoretical insights with practical application, ensuring you not only grasp the theoretical underpinnings but also gain the proficiency to implement real-time solutions confidently. Elevate your Java programming
expertise to new heights and stay ahead in the ever-evolving landscape of real-time systems with our comprehensive and immersive course.',
                              'Expert', 7.5, 40, 'Java SE 17 Programmer Professional',
                              'Java, real-time programming, multi-threading, programming'),
                          (2, 1, 'Introduction to SQL Essentials',
                           '
Description: Dive into the fundamentals of database management with our beginner-level online course, "Introduction to SQL Essentials." Geared towards those new to the world of databases and SQL, this course provides a comprehensive foundation for understanding and utilizing SQL for effective data management. While MySQL is touched upon to broaden your practical knowledge, the core focus is on SQL''s universal principles applicable across various database systems. Led by seasoned instructors, the course covers database design, querying data, and basic data manipulation using SQL commands. With a hands-on approach, you''ll engage in practical exercises to reinforce your learning, ensuring you gain the skills necessary to navigate and interact with databases confidently. Whether you''re a budding developer, analyst, or anyone eager to harness the power of databases, this course offers an accessible entry point into the world of SQL, setting the stage for your future success in data-driven environments.',
                           'Beginner', 2, 20, 'SQL Fundamentals', 'SQL, relational databases, MySQL'),
                          (3, 1, 'Creating Web Application with .Net',
                           'Description: Embark on your journey into web development with our beginner-level online course, "Creating Web Applications with .NET." Tailored for those stepping into the dynamic world of web development, this course provides a solid foundation in utilizing the versatile .NET framework to build powerful and interactive web applications. Guided by experienced instructors, you''ll explore fundamental concepts such as web application architecture, user interface design, and server-side scripting using .NET technologies like ASP.NET. Throughout the course, you''ll engage in hands-on projects that walk you through the entire development process, from designing responsive user interfaces to implementing server-side functionality. Gain practical skills in C# programming and discover how to leverage the robust features of .NET to bring your web applications to life. Whether you''re a programming novice or transitioning from another language, this course offers a welcoming entry point into the exciting realm of web application development with .NET, setting you on a path to create dynamic and engaging online experiences.',
                           'Beginner', 4, 40, '.Net Developer Fundamentals',
                           'web, programming, .net, C#'),
                          (4, 1, 'Azure Cloud Fundamentals',
                           'Description: Embark on your cloud computing journey with our beginner-level online course, "Azure Fundamentals," meticulously crafted to prepare you for the AZ-900 exam. Whether you''re new to cloud
technologies or seeking to validate your foundational knowledge, this course provides a comprehensive introduction to Microsoft Azure, one of the industry''s leading cloud platforms. Delve into the essentials of cloud concepts, Azure services, pricing, and compliance, all while guided by expert instructors who understand the importance of building a strong cloud foundation. Through a combination of engaging lectures, hands-on labs, and real-world scenarios, you''ll gain practical insights into deploying solutions on Azure and mastering fundamental cloud principles. By the end of the course, you''ll not only be well- prepared to ace the AZ-900 exam but will also have a solid understanding of Azure''s capabilities, empowering you to confidently navigate the vast landscape of cloud computing. Join us on this educational journey and unlock the potential of cloud technology with Azure Fundamentals.
',
                           'Beginner', 2, 10, 'AZ-900 Azure Fundamentals',
                           'Azure, cloud services'),
                          (5, 1, 'Azure Administration (Intermediate)',
                           '
Description: Elevate your cloud expertise with our intermediate-level online course, "Azure Administrator," meticulously designed to prepare you for the AZ-104 exam – your gateway to becoming a Microsoft Certified Cloud Administrator. Tailored for individuals with a foundational understanding of Azure, this course takes a deep dive into advanced administration and management tasks, honing the skills required for efficient cloud operations. Led by seasoned Azure professionals, you''ll explore intricate topics such as virtual networking, identity management, and governance strategies, gaining hands-on experience through practical exercises and real-world scenarios. The course''s comprehensive coverage aligns seamlessly with the AZ-104 exam objectives, ensuring that you not only pass the certification but emerge as a proficient Azure Administrator capable of implementing robust cloud solutions. Whether you''re looking to enhance your career or solidify your position as a cloud expert, this course is your key to mastering the intricacies of Azure administration and achieving Microsoft Certified Cloud Administrator status. Join us on this transformative journey towards advanced Azure proficiency.',
                           'Intermediate', 4, 5, 'AZ-104 Microsoft Certified Cloud Administrator',
                           'Azure, cloud services, administration'),
                          (6, 2, 'AWS Cloud Practitioner',
                           'Description: Discover the fundamentals of cloud computing in our beginner-level online course, "AWS Cloud Practitioner," designed to prepare you for the CLF-C02 certification exam. Tailored for individuals with minimal prior experience in cloud technologies, this course provides a robust foundation in understanding the essential concepts of Amazon Web Services (AWS). Led by experienced AWS professionals, the course delves into core topics, including cloud architecture, AWS services, security, and pricing models. Through dynamic lectures and hands-on labs, you''ll gain practical insights into navigating the AWS console, setting up basic infrastructure, and comprehending key cloud principles. By the course''s end, you''ll be well-equipped to excel in the CLF-C02 exam and possess a foundational understanding of AWS, empowering you to confidently explore and leverage cloud services. Join us in this educational journey, and initiate your AWS Cloud Practitioner certification with assurance and proficiency.',
                           'Beginner', 2, 20, 'CLF-C02 AWS Certified Cloud Practitioner',
                           'AWS, cloud services');

INSERT INTO Providers VALUES (1, 'NTNU'),
                             (2, 'Oracle'),
                             (3, 'Apache Software Foundation'),
                             (4, 'Pearson'),
                             (5, 'Microsoft'),
                             (6, 'Amazon');

INSERT INTO Providers_Courses VALUES (1, 1, 29999, 'NOK'),
                                     (2,1, 32000, 'NOK'),
                                     (3, 2, 800, 'USD'),
                                     (1, 2, 10000, 'NOK'),
                                     (4, 2, 899, 'USD'),
                                     (5, 3, 2999, 'NOK'),
                                     (4, 3, 3000, 'NOK'),
                                     (2, 3, 200, 'USD'),
                                     (5, 4, 200, 'USD'),
                                     (1, 4, 1800, 'NOK'),
                                     (4, 4, 200, 'USD'),
                                     (5, 5, 400, 'USD'),
                                     (1, 5, 3600, 'NOK'),
                                     (4, 5, 400, 'USD'),
                                     (6, 6, 100, 'USD'),
                                     (4, 6, 120, 'USD'),
                                     (1, 6, 1800, 'NOK');











