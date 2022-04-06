# Info-Cave blogs backend

Blogs operations are done in this project

## Endpoints:

Main endpoint: **/api/blogs**

Variables:

-   **/get/all** : fetches all the blogs from DB.

-   **/get/all/author/{authorId}** : fetches all blogs by author id.

-   **/get/{blogId}** : gets a single blog by blog id.

-   **/add** : adds a new blog to the DB.

    ```json
    Headers:
    {
    	"Content-Type": "application/json"
    }
    ```

    ```json
    Body:
    {
    	"title": "The Outsider",
    	"author": 2154, // Author id
    	"snippet": "Alien invasion on earth", // Small description
    	"detail": "this is where the actual blogs is written",
    	"blogDate": Timestamp
    }
    ```

-   **/update/{blogId}** : updates a blog by blog id. **Request body same as `/add`**

-   **/delete/{blogId}** : deletes a blog by blog id.
