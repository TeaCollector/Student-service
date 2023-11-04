# Application to store user and do some action.

## For using:

1. Clone consoleRepository through SSH: `https://github.com/TeaCollector/Student-consoleService.git`
2. Run postgresql container: `sudo docker-compose-up -d`
3. Install Apache Tomcat 10.1.15 and configure it
4. In browser input `http://localhost:8080/persons?class=10`
5. Please wait 2 minutes for copy all data from .scv file to postgres container...
6. After copy you will see result
7. And the second command is to update persons score in browser `http://localhost:8080/persons`
   in the body of request input
   `{
   "name": "Алёна",
   "lastName": "Яшина",
   "lesson": "literature",
   "classroom": 12,
   "score": 5,
   }`
12. Enjoy it!
