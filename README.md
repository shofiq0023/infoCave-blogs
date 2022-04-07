# Info-Cave Blogs

Blogs operations are done in this project

## Endpoints:

### **For Blogs:**

Main endpoint: **/api/blogs**

Variables:

-   **/get/all** : fetches all the blogs from DB.

-   **/get/all/author/{authorId}** : fetches all blogs by author id.

-   **/get/{blogId}** : gets a single blog by blog id.

-   **/add** : adds a new blog to the DB.

    Header:

    ```json
    {
    	"Content-Type": "application/json"
    }
    ```

    Body:

    ```json
    {
    	"title": "The Outsider",
    	"authorId": 2154,
    	"snippet": "Alien invasion on earth",
    	"detail": "this is where the actual blogs is written"
    }
    ```

-   **/update/{blogId}** : updates a blog by blog id. **Request body same as `/add`**

-   **/delete/{blogId}** : deletes a blog by blog id.

---

### **For User**:

Main endpoint: **/api/users/**

Variables:

-   **/get/all** : gets all user detail from DB.

-   **/get/{userId}** : gets a single user detail using user id from DB.

-   **/add** : adds a new user to DB.

    Header:

    ```json
    {
    	"Content-Type": "application/json"
    }
    ```

    Body:

    ```json
    {
    	"name": "John Doe",
    	"authorName": "john",
    	"email": "john.doe_002@gmail.com",
    	"password": "johndoe123"
    }
    ```

    **Password will be encoded in the backend**

-   **/delete/{userId}** : deletes a user using user id. Returns a message.

-   **/login** : login with email and password. Returns boolean if credentials matches with database.

    Header:

    ```json
    {
    	"Content-Type": "application/json"
    }
    ```

    Body:

    ```json
    {
    	"email": "john.doe_002@gmail.com",
    	"password": "johndoe123"
    }
    ```
