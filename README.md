# Info-Cave blogs backend

Blogs operations are done in this project

## Endpoints:

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
    	"detail": "this is where the actual blogs is written",
    	"blogDate": "Timestamp()"
    }
    ```

-   **/update/{blogId}** : updates a blog by blog id. **Request body same as `/add`**

-   **/delete/{blogId}** : deletes a blog by blog id.
