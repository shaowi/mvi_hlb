# HLB Spring Boot Application

## Prerequisites

Before you begin, ensure that you have the following prerequisites installed on your machine:

1. Git (version control system)
1. Java Development Kit (JDK) 11
1. MySQL
1. Visual Studio Code
	- Extension Pack for Java
	- Test Runner for Java

## Steps for local development

1. Clone the repository: Open a terminal or command prompt and navigate to the directory where you want to clone the Spring Boot application. Run the following command to clone the repository:

	```bash
	git clone https://github.com/shaowi/mvi_hlb.git
	```

1. Start up MySQL server by running it in a port number (One such app to execute it is [XAMPP](https://www.apachefriends.org/download.html))

	![XAMPP_MySQL](./docs/images/XAMPP_MySQL.png)

1. Navigate to the project directory: After the cloning process is complete, navigate into the cloned project directory using the following command and open it in VS code.

	```bash
	cd mvi_hlb

	code .
	```

1. When the project is successfully opened and loaded in VS code, right click on `HlbApplication.java` and click `Run Java`.
1. An instance of the Spring Boot application will be started.
