Import the project in the netbeans
Create database named portal containing four tables as following
1)student
2)company
3)stud_comp
4)admin

We used MySQL for database connectivity with a database named `portal` containing the following tables:
dbname="portal";
userName="root";

student(regno varchar(10) primary key,name varchar(10),gender varchar(10),email varchar(10),dob date,phone varchar(10) ,resume text,cgpa varchar(10));`
company(name varchar(10) primary key,branch varchar(10),dateproc date,offer varchar(10),cgpa varchar(10),ctc varchar(10),stipend varchar(10));`
stud_comp(regno varchar(10) foreign key,Company_name varchar(10) foreign key);`
admin(name varchar(10),password varchar(10));

Any company or student can be registered only by admin(placement officer)

For run code:
1)In the xampp start the mysql and apache server
2)Then from the project folder of placement folder run tcpserver.java and server.java file.
3)Run The placement portal project by clicking on it 
4)Then admin can select admin login and student can select student login


