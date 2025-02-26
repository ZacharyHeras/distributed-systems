from flask import Flask

app = Flask(__name__)

@app.route('/')
def sayHelloWorld():
    return 'Hello World'

@app.route('/<username>')
def say_welcome(username):
    return f'Welcome, {username.replace("_", " ")}'
