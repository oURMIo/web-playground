package com.home.web.exeption

class UserAppNotFoundException(message: String, exception: Exception = Exception(message)) :
    Exception(message, exception)