# WonderBoot
### A Travel social network web app, made in spring boot

### Docker 
The Docker file has been configured.
Now, to build the image of our application, run the following command:

    docker build -t wonderboot .

Finally, to run the image, use the following command:

    docker run -d -p 8080:8080 wonderboot