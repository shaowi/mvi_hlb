# API endpoints

## UserController

| Type             | HTTP Request | Endpoint      | Description                                                                                                                       |
|------------------|--------------|---------------|-----------------------------------------------------------------------------------------------------------------------------------|
| Login            | POST         | /user/login   | Logs in the user<br/><br/>Accepts username and password as payload in JSON format<br/><br/>Adds a user token into the web storage |
| Logout           | POST         | /user/logout  | Logs out the user<br/><br/>Remove any user token in web storage                                                                   |
| Sign Up          | POST         | /user/signup  | Signs up the user<br/><br/>Accepts username and password as payload in JSON format                                                |
| Get current user | GET          | /user/current | Gets the user who is currently logged in<br/><br/>The user is stored in HttpSession                                               |
| Get all users    | GET          | /user/all     | Gets all signed-up users                                                                                                          |

## OnlineController

| Type                                      | HTTP Request | Endpoint                         | Description                                                                                                                                                                                                                            |
|-------------------------------------------|--------------|----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Create payment transaction                | POST         | online/cbft/create               | Accepts JSON payload with OnlineCbftForm attributes (Applicant, Beneficiary and ForeignPaymentForm id should be null)<br/><br/>Map it to OnlineCbftData and added to the online_cbft_trasactions table                                 |
| Read all payment transactions             | GET          | online/cbft/all                  | Returns a list of OnlineCbftForm data                                                                                                                                                                                                  |
| Read all payment transactions by filename | GET          | online/cbft?filename=\<filename> | Returns a list of OnlineCbftForm data with the specified filename                                                                                                                                                                      |
| Update payment transaction                | POST         | online/cbft/update               | Accepts JSON payload with OnlineCbftForm attributes (Applicant, Beneficiary and ForeignPaymentForm id are retrieved from the database)<br/><br/>Map it to OnlineCbftData and updated it in the online_cbft_trasactions table by its id |
