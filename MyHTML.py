time = 550

time += 60

another_string = "testing"

my_variable = '''
<html>

<link rel='shortcut icon' href='img/favicon.png'>
    <head>
        <title>Daniel Hong</title>
    </head>

        <body>
        
        <h1>Welcome to Daniel's website</h1>
        <img alt="Daniel's image"  src="img/daniel4.jpg">
        <br><br>
        <a href='https://www.facebook.com/daniel.hong.180' target="_blank">Click me for my Facebook profile</a>
        <br><br>
        <a href='https://www.linkedin.com/in/dongminhong' target="_blank">Click me for my LinkedIn profile</a>
        <br><br>
        <a href='https://bitbucket.org/dhong0716/' target="_blank">Click me for my BitBucket projects</a>
        <br><br>
        <a href='https://youtu.be/-F6PDE3idKs?t=" + str(time) + "'>Click here for where I learned this</a>
        
        </body>

</html>
'''


my_html_file = open("C:/Users/Daniel/Documents/College/python/my_html_file.html", "w")  # write a new file if it doesn't exist

my_html_file.write(my_variable)

my_html_file.close()



