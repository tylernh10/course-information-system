### Course Report System

This is a java application that allows a user to interact with and explore data about a course via the command line.

Course information is stored in a separate file. An example of the file format can be found in CourseRecord.txt.
The format consists of Number, Name, Instructors, Staff, Undergraduates, and Graduates. More details can be found in the text file.
While there may be duplicates in the text file, the parser ensures that each unique actor is only accounted for once.

Upon running "java CourseReport" in the command line, a user is expected to specify the name of the text file where the course information is stored. In this repo, there is course information stored in the aforementioned file CourseRecord.txt.

Following this, the file is parsed and stored; the user is then prompted with 13 options via the command line which allows them to explore the information of the course.

The user can exit the program by typing "exit".

This project uses object-oriented programming via data managers, data containers, inheritance, and observers. There is a hierarchal structure involving various classes such as Employees, Students, etc. in the program. There is a parser class which receives a line from the course record text file, identifies which type of line it is, parses the information, and notifies the course report once the data is ready to be accessed upon which the report fetches the data. This allows decoupling from the course report functionality and parsing functionality. Furthermore, the data manager Course which holds all course related info is also decoupled from both the report and the Parser. Where possible and sensible, composition is preferred over inheritance.
